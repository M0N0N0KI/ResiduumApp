package com.rapi.rapi.controllers.DTO.User;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserSDTO {
    
    private long id;
    private String name;
    private String identifier;
    private String password;
    private String status;
    private Long contact;
    private Long address;
    private List<Long> collectrequest;

}
