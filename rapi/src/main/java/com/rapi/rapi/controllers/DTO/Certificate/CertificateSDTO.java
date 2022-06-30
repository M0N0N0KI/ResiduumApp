package com.rapi.rapi.controllers.DTO.Certificate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CertificateSDTO {
    
    private long id;
    private String weight;
    private String wastetype;
    private String status;
    private String destiny;
    private long origin;

}
