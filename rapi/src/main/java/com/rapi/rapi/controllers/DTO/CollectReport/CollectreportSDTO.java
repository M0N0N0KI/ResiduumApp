package com.rapi.rapi.controllers.DTO.CollectReport;

import java.util.Date;
import java.util.List;

import com.rapi.rapi.controllers.services.CollectedWaste.CollectedWasteService;
import com.rapi.rapi.models.CollectReport.CollectreportEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectreportSDTO {
    
    private long id;
    private String status;
    private Date executiondate;
    private long request;
    private long destiny;
    private List<Long> wastes;

    public CollectreportSDTO(){}

    public CollectreportSDTO(CollectreportEntity creport)
    {
        if(creport != null)
        {
            CollectedWasteService cwasteserv = new CollectedWasteService();

            this.setId(creport.getId());
            this.setStatus(creport.getStatus());
            this.setExecutiondate(creport.getExecutiondate());
            this.setRequest(creport.getRequest().getId());
            this.setDestiny(creport.getDestiny().getId());
            this.setWastes(cwasteserv.ListofWasteid(creport.getId()));
        }
    }

}
