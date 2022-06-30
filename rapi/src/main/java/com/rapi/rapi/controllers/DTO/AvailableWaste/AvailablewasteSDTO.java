package com.rapi.rapi.controllers.DTO.AvailableWaste;

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

}
