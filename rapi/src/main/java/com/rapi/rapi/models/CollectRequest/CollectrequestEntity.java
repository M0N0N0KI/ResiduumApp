package com.rapi.rapi.models.CollectRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.Address.AddressEntity;
import com.rapi.rapi.models.User.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "collectrequest")
public class CollectrequestEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collectrequest_id")
    private long id;

    @Column(name = "collectrequest_status", length = 30)
    private String status;

    @Column(name = "collectrequest_requestdate")
    private Date requestdate;

    @OneToOne
    @JoinColumn(name="collectrequest_collectlocation")
    private AddressEntity collectlocation;

    @ManyToMany
    private List<UserEntity> applicant;

}
