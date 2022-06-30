package com.rapi.rapi.controllers.DTO.WasteSold;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WastesoldSDTO {
    
    private long id;
    private String type;
    private String weight;
    private String riskrating;
    private String price;
    private long ivoice;

}
