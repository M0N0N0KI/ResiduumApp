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
@Table(name = "user")
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_identifier")
    private String identifier;

    @Column(name = "user_status")
    private String status;

    @OneToOne
    @JoinColumn(name = "user_address")
    private AddressEntity address;

    @OneToOne
    @JoinColumn(name = "user_contact")
    private ContactEntity contact;
    
}
