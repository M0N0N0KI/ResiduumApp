package com.rapi.rapi.controllers.DTO.Cooperative;

import java.util.List;

import com.rapi.rapi.controllers.DTO.AvailableWaste.AvailablewasteCDTO;
import com.rapi.rapi.controllers.DTO.Certificate.CertificateCDTO;
import com.rapi.rapi.controllers.DTO.Ivoice.IvoiceCDTO;
import com.rapi.rapi.controllers.DTO.User.UserCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CooperativeCDTO extends UserCDTO{
    
    private long userid;
    private List<AvailablewasteCDTO> availablewaste;
    private List<CertificateCDTO> certificatesissued;
    private List<IvoiceCDTO> ivoicedissued;

}
