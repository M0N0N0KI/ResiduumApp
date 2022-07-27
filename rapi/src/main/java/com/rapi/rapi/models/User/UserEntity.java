package com.rapi.rapi.models.User;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;
import com.rapi.rapi.controllers.services.Address.AddressService;
import com.rapi.rapi.controllers.services.Contact.ContactService;
import com.rapi.rapi.controllers.services.User.UserService;
import com.rapi.rapi.models.Address.AddressEntity;
import com.rapi.rapi.models.CollectRequest.CollectrequestEntity;
import com.rapi.rapi.models.Contact.ContactEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "userr")
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userr_id")
    private long id;

    @Column(name = "userr_name")
    private String name;

    @Column(name = "userr_identifier")
    private String identifier;

    @Column(name = "userr_password",columnDefinition = "TEXT")
    private String password;

    @Column(name = "userr_status")
    private String status;

    @OneToOne
    @JoinColumn(name = "userr_contact")
    private ContactEntity contact;

    @OneToOne
    @JoinColumn(name = "userr_address")
    private AddressEntity address;

    @ManyToMany(mappedBy = "userr")
    private Set<CollectrequestEntity> collectrequest;

    public UserEntity(){}

    public UserEntity(UserSDTO user)
    {

        ContactService contactserv = new ContactService();
        AddressService addressserv = new AddressService();
        UserService userserv = new UserService();
        
        this.setId(user.getId());
        if(user.getName() != null)this.setName(user.getName());
        if(user.getIdentifier() != null)this.setIdentifier(user.getIdentifier());
        if(user.getPassword() != null)this.setPassword(user.getPassword());
        if(user.getStatus() != null)this.setStatus(user.getStatus());
        if(user.getContact() != null)this.setContact(contactserv.GetContactByID(user.getContact()));
        if(user.getAddress() != null)this.setAddress(addressserv.GetAddressByID(user.getAddress()));
        this.setCollectrequest(userserv.listRequestbyUser(user.getId()));

    }

}
