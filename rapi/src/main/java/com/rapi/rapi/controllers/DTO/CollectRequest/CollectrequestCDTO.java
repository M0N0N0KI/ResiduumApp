package com.rapi.rapi.controllers.DTO.CollectRequest;

import java.util.Date;
import java.util.List;

import com.rapi.rapi.controllers.DTO.Address.AddressDTO;
import com.rapi.rapi.controllers.DTO.User.UserCDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CollectrequestCDTO {
    
    private Long id;
    private String status;
    private Date requestdate;
    private AddressDTO collectlocation;
    private List<UserCDTO> applicant;

}
