package com.rapi.rapi.models.WasteSold;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WastesoldRepo extends JpaRepository<WastesoldEntity, Long>{

    @Query("select W from WastesoldEntity W where W.type = ?1 and W.riskrating = ?2 and W.ivoice.id = ?3")
    public Optional<WastesoldEntity> searchExistence(String type, String risk, Long ivoice);
    
}
