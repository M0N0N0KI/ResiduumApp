package com.rapi.rapi.models.Colletedwaste;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rapi.rapi.models.CollectReport.CollectreportEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "colletedwaste")
public class ColletedwasteEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colletedwaste_id")
    private long id;

    @Column(name = "colletedwaste_type",length = 20)
    private String type;

    @Column(name = "colletedwaste_weight", length = 6)
    private String weight;

    @Column(name = "colletedwaste_riskrating", length = 10)
    private String riskrating;

    @ManyToOne
    @JoinColumn(name = "colletedwaste_report")
    private CollectreportEntity report;
    
}
