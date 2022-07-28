package com.rapi.rapi.models.Cooperative;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.AvailableWaste.AvailablewasteEntity;
import com.rapi.rapi.models.Certificate.CertificateEntity;
import com.rapi.rapi.models.Ivoice.IvoiceEntity;
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
    private UserEntity user;

    @OneToMany(mappedBy = "owner")
    private List<AvailablewasteEntity> availablewaste;

    @OneToMany(mappedBy = "origin")
    private List<CertificateEntity> certificatesissued;

    @OneToMany(mappedBy = "issuer")
    private List<IvoiceEntity> ivoicedissued;

}
