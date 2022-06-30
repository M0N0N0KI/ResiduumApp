package com.rapi.rapi.controllers.DTO.WasteSold;

import com.rapi.rapi.controllers.DTO.Ivoice.IvoiceCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WastesoldCDTO {
    
    private long id;
    private String type;
    private String weight;
    private String riskrating;
    private String price;
    private IvoiceCDTO ivoice;

}
