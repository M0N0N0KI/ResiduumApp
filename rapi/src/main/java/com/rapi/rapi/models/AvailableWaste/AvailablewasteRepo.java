package com.rapi.rapi.models.AvailableWaste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailablewasteRepo extends JpaRepository<AvailablewasteEntity, Long>{

    @Query("select A from AvailablewasteEntity A where A.type = ?1 and A.riskrating = ?2 and A.owner.id = ?3")
    public Optional<AvailablewasteEntity> searchExistence(String type, String riskrating, Long owner);
    
}
