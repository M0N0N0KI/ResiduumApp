package com.rapi.rapi.controllers.DTO.Ivoice;

import java.util.List;

import com.rapi.rapi.controllers.DTO.Cooperative.CooperativeCDTO;
import com.rapi.rapi.controllers.DTO.WasteSold.WastesoldCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class IvoiceCDTO {
    
    private long id;
    private long issuenumber;
    private String applicant;
    private CooperativeCDTO issuer;
    private List<WastesoldCDTO> wastesold;

}
