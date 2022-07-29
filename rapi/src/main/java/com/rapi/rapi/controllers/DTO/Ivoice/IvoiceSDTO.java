package com.rapi.rapi.controllers.DTO.Ivoice;

import java.util.List;

import com.rapi.rapi.controllers.services.Ivoice.IvoiceService;
import com.rapi.rapi.models.Ivoice.IvoiceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class IvoiceSDTO {
    
    private long id;
    private String issuenumber;
    private String applicant;
    private long issuer;
    private List<Long> wastesold;

    public IvoiceSDTO(){}

    public IvoiceSDTO(IvoiceEntity ivoice)
    {
        if(ivoice != null)
        {
            IvoiceService ivoiceserv = new IvoiceService();

            this.setId(ivoice.getId());
            this.setIssuenumber(ivoice.getIssuenumber());
            this.setApplicant(ivoice.getApplicant());
            this.setIssuer(ivoice.getIssuer().getId());
            this.setWastesold(ivoiceserv.ListWasteSoldIDs(ivoice.getId()));
        }
    }
    
}
