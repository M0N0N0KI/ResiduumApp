package com.rapi.rapi.controllers.DTO.Personal;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;
import com.rapi.rapi.models.Personal.PersonalEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonalSDTO extends UserSDTO{
    
    private String score;
    private long userid;

    public PersonalSDTO(){}

    public PersonalSDTO(PersonalEntity personal)
    {
        if(personal.getScore() != null)this.score = personal.getScore();
        if(personal.getUser() != null)
        {
            this.setUserid(personal.getUser().getId());
            this.setId(personal.getId());
            this.setName(personal.getUser().getName());
            this.setIdentifier(personal.getUser().getIdentifier());
            this.setPassword(personal.getUser().getPassword());
            this.setStatus(personal.getUser().getStatus());
            this.setContact(personal.getUser().getContact().getId());
            this.setAddress(personal.getUser().getAddress().getId());
        }
    }

}
