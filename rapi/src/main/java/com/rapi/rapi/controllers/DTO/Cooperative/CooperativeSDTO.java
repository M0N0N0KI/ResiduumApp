package com.rapi.rapi.controllers.DTO.Cooperative;

import java.util.List;

import com.rapi.rapi.controllers.DTO.User.UserSDTO;
import com.rapi.rapi.controllers.services.Cooperative.CooperativeService;
import com.rapi.rapi.models.Cooperative.CooperativeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CooperativeSDTO extends UserSDTO{
    
    private long userid;
    private List<Long> availablewaste;
    private List<Long> certificatesissued;
    private List<Long> ivoicedissued;

    public CooperativeSDTO(){}

    public CooperativeSDTO(CooperativeEntity cooperative)
    {
        if(cooperative != null)
        {
            CooperativeService coopserv = new CooperativeService();

            this.setId(cooperative.getId());
            this.setUserid(cooperative.getUser().getId());
            this.setAvailablewaste(coopserv.ListAWasteIDs(cooperative.getId()));
            this.setCertificatesissued(coopserv.ListCertificateIDs(cooperative.getId()));
            this.setIvoicedissued(coopserv.ListIvoiceIDs(cooperative.getId()));
        }
    }

}
