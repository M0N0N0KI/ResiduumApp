package com.rapi.rapi.controllers.DTO.CollectRequest;

import java.util.Date;
import java.util.List;

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

}
