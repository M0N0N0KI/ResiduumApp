package com.rapi.rapi.controllers.DTO.AvailableWaste;

import com.rapi.rapi.models.AvailableWaste.AvailablewasteEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AvailablewasteSDTO {
    
    private Long id;
    private String type;
    private String weight;
    private String riskrating;
    private Long owner;

    public AvailablewasteSDTO(){}
    
    public AvailablewasteSDTO(AvailablewasteEntity awaste)
    {
        if(awaste != null)
        {
            this.setId(awaste.getId());
            this.setType(awaste.getType());
            this.setWeight(awaste.getWeight());
            this.setRiskrating(awaste.getRiskrating());
            this.setOwner(awaste.getOwner().getId());
        }
    }

}
