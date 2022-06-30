package com.rapi.rapi.controllers.DTO.Personal;

import com.rapi.rapi.controllers.DTO.User.UserCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonalCDTO extends UserCDTO{
    
    private String score;
    private long userid;

}
