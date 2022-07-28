package com.rapi.rapi.models.Certificate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.Cooperative.CooperativeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "certificate")
public class CertificateEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private long id;

    @Column(name = "certificate_weight")
    private String weight;

    @Column(name = "certificate_wastetype",length = 20)
    private String wastetype;

    @Column(name = "certificate_status",length = 10)
    private String status;

    @Column(name = "certificate_destiny")
    private String destiny;

    @ManyToOne
    @JoinColumn(name = "certificate_origin", nullable = false)
    private CooperativeEntity origin;

}
