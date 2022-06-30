package com.rapi.rapi.controllers.DTO.Cooperative;

import java.util.List;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CooperativeSDTO extends UserSDTO{
    
    private long userid;
    private List<Long> availablewaste;
    private List<Long> certificatesissued;
    private List<Long> ivoicedissued;

}
