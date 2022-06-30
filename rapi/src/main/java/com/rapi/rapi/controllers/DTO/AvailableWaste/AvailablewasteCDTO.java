package com.rapi.rapi.controllers.DTO.AvailableWaste;

import com.rapi.rapi.controllers.DTO.Cooperative.CooperativeCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AvailablewasteCDTO {
    
    private Long id;
    private String type;
    private String weight;
    private String riskrating;
    private CooperativeCDTO owner;

}
