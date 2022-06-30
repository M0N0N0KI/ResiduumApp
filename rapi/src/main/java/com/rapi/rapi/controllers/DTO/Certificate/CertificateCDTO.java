package com.rapi.rapi.controllers.DTO.Certificate;

import com.rapi.rapi.controllers.DTO.Cooperative.CooperativeCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CertificateCDTO {
    
    private long id;
    private String weight;
    private String wastetype;
    private String status;
    private String destiny;
    private CooperativeCDTO origin;

}
