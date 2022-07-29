package com.rapi.rapi.controllers.DTO.WasteSold;

import com.rapi.rapi.models.WasteSold.WastesoldEntity;

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

    public WastesoldSDTO(){}

    public WastesoldSDTO(WastesoldEntity wsold)
    {
        if(wsold != null)
        {
            this.setId(wsold.getId());
            this.setType(wsold.getType());
            this.setWeight(wsold.getWeight());
            this.setRiskrating(wsold.getRiskrating());
            this.setPrice(wsold.getPrice());
            this.setIvoice(wsold.getIvoice().getId());
        }
    }

}
