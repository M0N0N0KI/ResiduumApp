package com.rapi.rapi.controllers.DTO.CollectReport;

import java.util.Date;
import java.util.List;

import com.rapi.rapi.controllers.DTO.CollectRequest.CollectrequestCDTO;
import com.rapi.rapi.controllers.DTO.CollectedWaste.CollectedwasteCDTO;
import com.rapi.rapi.controllers.DTO.Cooperative.CooperativeCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectreportCDTO {
    
    private long id;
    private String status;
    private Date executiondate;
    private CollectrequestCDTO request;
    private CooperativeCDTO destiny;
    private List<CollectedwasteCDTO> waste;

}
