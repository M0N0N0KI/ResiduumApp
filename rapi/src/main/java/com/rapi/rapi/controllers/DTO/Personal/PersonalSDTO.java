package com.rapi.rapi.controllers.DTO.Personal;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonalSDTO extends UserSDTO{
    
    private String score;
    private long userid;

}
