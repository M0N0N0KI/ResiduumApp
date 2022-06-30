package com.rapi.rapi.controllers.DTO.Address;

import com.rapi.rapi.models.Address.AddressEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddressDTO {
    
    private long id;
    private String street;
    private String hnumber;
    private String district;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String latitude;
    private String longitude;

    public AddressDTO(){}

    public AddressDTO(AddressEntity address)
    {
        this.id = address.getId();
        this.street = address.getStreet();
        this.hnumber = address.getHnumber();
        this.district = address.getDistrict();
        this.complement = address.getComplement();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.postalCode = address.getPostalCode();
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
    }

}
