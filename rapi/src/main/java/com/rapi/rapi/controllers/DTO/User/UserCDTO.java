package com.rapi.rapi.controllers.DTO.User;

import java.util.List;

import com.rapi.rapi.controllers.DTO.Address.AddressDTO;
import com.rapi.rapi.controllers.DTO.CollectRequest.CollectrequestCDTO;
import com.rapi.rapi.controllers.DTO.Contact.ContactDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserCDTO {
    
    private Long id;
    private String name;
    private String identifier;
    private String password;
    private String status;
    private ContactDTO contact;
    private AddressDTO address;
    private List<CollectrequestCDTO> collectrequest;

}
