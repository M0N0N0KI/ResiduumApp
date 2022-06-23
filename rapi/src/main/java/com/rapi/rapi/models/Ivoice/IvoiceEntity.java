package com.rapi.rapi.models.Ivoice;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rapi.rapi.models.Cooperative.CooperativeEntity;
import com.rapi.rapi.models.WasteSold.WastesoldEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "ivoice")
public class IvoiceEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ivoice_id")
    private long id;

    @Column(name = "ivoice_issuenumber")
    private long issuenumber;

    @Column(name ="ivoice_applicant")
    private String applicant;

    @ManyToOne
    @JoinColumn(name = "ivoice_issuer")
    private CooperativeEntity issuer;

    @OneToMany
    private List<WastesoldEntity> wastesold;

}
