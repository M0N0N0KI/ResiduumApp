package com.rapi.rapi.controllers.DTO.Corporate;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;
import com.rapi.rapi.models.Corperate.CorporateEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CorporateSDTO extends UserSDTO{
    
    private String type;
    private long userid;

    public CorporateSDTO(){}

    public CorporateSDTO(CorporateEntity corporate)
    {
        if(corporate.getType() != null)this.type = corporate.getType();
        if(corporate.getUser() != null)
        {
            this.setUserid(corporate.getUser().getId());
            this.setId(corporate.getId());
            this.setName(corporate.getUser().getName());
            this.setIdentifier(corporate.getUser().getIdentifier());
            this.setPassword(corporate.getUser().getPassword());
            this.setStatus(corporate.getUser().getStatus());
            this.setContact(corporate.getUser().getContact().getId());
            this.setAddress(corporate.getUser().getAddress().getId());
        }
    }

}
