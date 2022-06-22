package com.rapi.rapi.models.Address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "address")
public class AddressEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long id;

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_hnumber",length = 10)
    private String hnumber;

    @Column(name = "address_district",length = 60)
    private String district;

    @Column(name = "address_complement", columnDefinition = "TEXT")
    private String complement;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_state")
    private String state;

    @Column(name = "address_country")
    private String country;

    @Column(name = "address_postalCode")
    private String postalCode;

    @Column(name = "address_latitude")
    private String latitude;

    @Column(name = "address_longitude")
    private String longitude;

}
