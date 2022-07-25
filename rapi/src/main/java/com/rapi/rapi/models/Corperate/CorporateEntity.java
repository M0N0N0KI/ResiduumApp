package com.rapi.rapi.models.Corperate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.controllers.DTO.Corporate.CorporateSDTO;
import com.rapi.rapi.controllers.services.User.UserService;
import com.rapi.rapi.models.User.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "corporate")
public class CorporateEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporate_id")
    private long id;

    @Column(name = "corporate_type")
    private String type;

    @OneToOne
    @JoinColumn(name = "corporate_user")
    private UserEntity user;

    public CorporateEntity(){}

    public CorporateEntity(UserEntity user)
    {
        if(user != null)
        {
            this.setType("defina seu tipo de empresa");
            this.setUser(user);
        }
    }

    public CorporateEntity(CorporateSDTO corporate)
    {
        UserService userserv = new UserService();
        
        if(corporate.getType() != null)this.setType(corporate.getType());
        if(corporate.getIdentifier() != null)
        {
            if(!userserv.searchExistence(corporate.getIdentifier()))
            {
                this.setUser(userserv.GetUser(corporate.getUserid()));
            }
        }
    }

}
