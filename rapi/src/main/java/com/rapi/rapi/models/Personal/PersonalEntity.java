package com.rapi.rapi.models.Personal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.controllers.DTO.Personal.PersonalSDTO;
import com.rapi.rapi.controllers.services.User.UserService;
import com.rapi.rapi.models.User.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "personal")
public class PersonalEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_id")
    private long id;

    @Column(name = "personal_score", length = 10)
    private String score;

    @OneToOne
    @JoinColumn(name = "personal_user")
    private UserEntity user;

    public PersonalEntity(){}

    public PersonalEntity(UserEntity user)
    {
        if(user != null)
        {
            this.setScore("0");
            this.setUser(user);
        }
    }

    public PersonalEntity(PersonalSDTO user)
    {
        UserService userserv = new UserService();

        if(user.getScore() != null)this.setScore(user.getScore());
        if(user.getIdentifier() != null)
        {
            if(!userserv.searchExistence(user.getIdentifier()))
            {
                this.setUser(userserv.GetUser(user.getUserid()));
            }
        }

    }
    
}
