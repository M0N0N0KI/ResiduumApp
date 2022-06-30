package com.rapi.rapi.controllers.DTO.CollectedWaste;

import com.rapi.rapi.controllers.DTO.CollectReport.CollectreportCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectedwasteCDTO {
    
    private long id;
    private String type;
    private String weight;
    private String riskrating;
    private CollectreportCDTO report;

}
