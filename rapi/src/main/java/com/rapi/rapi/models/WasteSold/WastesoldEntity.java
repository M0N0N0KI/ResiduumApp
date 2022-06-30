package com.rapi.rapi.models.WasteSold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.Ivoice.IvoiceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "wastesold")
public class WastesoldEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wastesold_id")
    private long id;

    @Column(name = "wastesold_type", length = 20)
    private String type;

    @Column(name = "wastesold_weight", length = 6)
    private String weight;

    @Column(name = "wastesold_riskrating", length = 10)
    private String riskrating;

    @Column(name = "wastesold_price", length = 11)
    private String price;

    @ManyToOne
    @JoinColumn(name = "wastesold_ivoice")
    private IvoiceEntity ivoice;
    
}
