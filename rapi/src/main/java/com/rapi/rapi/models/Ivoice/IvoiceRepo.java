package com.rapi.rapi.models.Ivoice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IvoiceRepo extends JpaRepository<IvoiceEntity, Long>{

    @Query("select I from IvoiceEntity I where I.issuenumber = ?1")
    public Optional<IvoiceEntity> searchExistence(String issuenumber);
    
}
