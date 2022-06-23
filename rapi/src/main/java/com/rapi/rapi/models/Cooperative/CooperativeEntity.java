package com.rapi.rapi.models.Cooperative;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.User.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "cooperative")
public class CooperativeEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cooperative_id")
    private long id;

    

    @OneToOne
    @JoinColumn(name = "cooperative_user")
    private UserEntity user;

}
