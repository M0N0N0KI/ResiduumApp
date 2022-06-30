package com.rapi.rapi.controllers.DTO.Corporate;

import com.rapi.rapi.controllers.DTO.User.UserCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CorporateCDTO extends UserCDTO{
    
    private String type;
    private long userid;

}
