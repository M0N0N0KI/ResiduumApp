package com.rapi.rapi.controllers.DTO.Corporate;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CorporateSDTO extends UserSDTO{
    
    private String type;
    private long userid;

}
