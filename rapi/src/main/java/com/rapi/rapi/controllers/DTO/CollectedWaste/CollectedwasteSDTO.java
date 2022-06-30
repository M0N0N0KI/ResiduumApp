package com.rapi.rapi.controllers.DTO.CollectedWaste;

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

}
