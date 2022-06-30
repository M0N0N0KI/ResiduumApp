package com.rapi.rapi.controllers.DTO.CollectReport;

import java.util.Date;
import java.util.List;

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

}
