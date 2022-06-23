package com.rapi.rapi.models.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.Address.AddressEntity;
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

}
