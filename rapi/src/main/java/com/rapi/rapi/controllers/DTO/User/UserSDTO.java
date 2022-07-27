package com.rapi.rapi.controllers.DTO.User;

import java.util.List;

import com.rapi.rapi.controllers.services.User.UserService;
import com.rapi.rapi.models.User.UserEntity;

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

    public UserSDTO(){}
    
    public UserSDTO(UserEntity user)
    {
        UserService userserv = new UserService();

        this.setId(user.getId());
        if(user.getName() != null)this.setName(user.getName());
        if(user.getIdentifier() != null)this.setIdentifier(user.getIdentifier());
        if(user.getPassword() != null)this.setPassword(user.getPassword());
        if(user.getStatus() != null)this.setStatus(user.getStatus());
        if(user.getContact() != null)this.setContact(user.getContact().getId());
        if(user.getAddress() != null)this.setAddress(user.getAddress().getId());
        this.setCollectrequest(userserv.listRequestIdsbyUser(user.getId())); 
    }

}
