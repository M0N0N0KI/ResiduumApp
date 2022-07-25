package com.rapi.rapi.controllers.DTO.CollectedWaste;

import com.rapi.rapi.models.Colletedwaste.ColletedwasteEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectedwasteSDTO {
    
    private long id;
    private String type;
    private String weight;
    private String riskrating;
    private long report;

    public CollectedwasteSDTO(){}

    public CollectedwasteSDTO(ColletedwasteEntity collectedwaste)
    {
        if(collectedwaste != null)
        {
            this.setId(collectedwaste.getId());
            this.setType(collectedwaste.getType());
            this.setWeight(collectedwaste.getWeight());
            this.setRiskrating(collectedwaste.getRiskrating());
            this.setReport(collectedwaste.getReport().getId());
        }
    }

}
