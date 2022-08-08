package com.rapi.rapi.models.AvailableWaste;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rapi.rapi.controllers.DTO.AvailableWaste.AvailablewasteSDTO;
import com.rapi.rapi.controllers.services.Cooperative.CooperativeService;
import com.rapi.rapi.models.Cooperative.CooperativeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "availablewaste")
public class AvailablewasteEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availablewaste_id")
    private Long id;

    @Column(name = "availablewaste_type", length = 20)
    private String type;

    @Column(name = "availablewaste_weight", length = 6)
    private String weight;

    @Column(name = "availablewaste_riskrating", length = 10)
    private String riskrating;

    @ManyToOne
    @JoinColumn(name="availablewaste_owner", nullable = false)
    private CooperativeEntity owner;

    public AvailablewasteEntity(){}

    public AvailablewasteEntity(AvailablewasteSDTO awaste)
    {
        if(awaste != null)
        {
            CooperativeService coopserv = new CooperativeService();

            this.setId(awaste.getId());
            this.setType(awaste.getType());
            this.setWeight(awaste.getWeight());
            this.setRiskrating(awaste.getRiskrating());
            this.setOwner(coopserv.GetCooperative(awaste.getOwner()));
        }
    }
    
}
