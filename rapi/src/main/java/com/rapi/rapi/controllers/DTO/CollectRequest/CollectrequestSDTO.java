package com.rapi.rapi.controllers.DTO.CollectRequest;

import java.util.Date;
import java.util.List;

import com.rapi.rapi.models.CollectRequest.CollectrequestEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectrequestSDTO {
    
    private long id;
    private String status;
    private Date requestdate;
    private long collectlocation;
    private List<Long> applicant;

    public CollectrequestSDTO(){}

    public CollectrequestSDTO(CollectrequestEntity request)
    {
        if(request != null)
        {
            this.setId(request.getId());
            this.setStatus(request.getStatus());
            this.setRequestdate(request.getRequestdate());
            this.setCollectlocation(request.getCollectlocation().getId());
            /**
             *  insert applicant
             */
        }
    }

}
