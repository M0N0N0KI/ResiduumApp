package com.rapi.rapi.models.CollectRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.controllers.DTO.CollectRequest.CollectrequestSDTO;
import com.rapi.rapi.controllers.services.Address.AddressService;
import com.rapi.rapi.controllers.services.CollectRequest.CollectRequestService;
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
    @JoinTable(name="request_userr",
               joinColumns = @JoinColumn(name = "request_id"),
               inverseJoinColumns = @JoinColumn(name ="userr_id"))
    private Set<UserEntity> userr;

    public CollectrequestEntity(){}

    public CollectrequestEntity(CollectrequestSDTO request)
    {
        if(request != null)
        {
            AddressService addressserv = new AddressService();
            CollectRequestService requestserv = new CollectRequestService();

            this.setId(request.getId());
            this.setStatus(request.getStatus());
            this.setRequestdate(request.getRequestdate());
            this.setCollectlocation(addressserv.GetAddressByID(request.getCollectlocation()));
            this.setUserr(requestserv.listApplicantsbyRequest(request.getId()));

        }
    }

}
