package com.rapi.rapi.controllers.DTO.Contact;

import com.rapi.rapi.models.Contact.ContactEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContactDTO {
    
    private long id;
    private String email;
    private String telephone;
    private String cellphone;

    public ContactDTO(){}

    public ContactDTO(ContactEntity contact)
    {
        this.id = contact.getId();
        this.email = contact.getEmail();
        this.telephone = contact.getTelephone();
        this.cellphone = contact.getCellphone();
    }
}
