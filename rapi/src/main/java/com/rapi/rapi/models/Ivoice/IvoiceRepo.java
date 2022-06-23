package com.rapi.rapi.models.Ivoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IvoiceRepo extends JpaRepository<IvoiceEntity, Long>{
    
}
