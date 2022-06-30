package com.rapi.rapi.controllers.DTO.Ivoice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class IvoiceSDTO {
    
    private long id;
    private long issuenumber;
    private String applicant;
    private long issuer;
    private List<Long> wastesold;
    
}
