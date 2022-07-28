package com.rapi.rapi.controllers.DTO.Certificate;

import com.rapi.rapi.models.Certificate.CertificateEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CertificateSDTO {
    
    private long id;
    private String number;
    private String weight;
    private String wastetype;
    private String status;
    private String destiny;
    private long origin;

    public CertificateSDTO(){}

    public CertificateSDTO(CertificateEntity certificate)
    {
        if(certificate != null)
        {
            this.setId(certificate.getId());
            this.setNumber(certificate.getNumber());
            this.setWeight(certificate.getWeight());
            this.setWastetype(certificate.getWastetype());
            this.setStatus(certificate.getStatus());
            this.setDestiny(certificate.getDestiny());
            this.setOrigin(certificate.getOrigin().getId());
        }
    }

}
