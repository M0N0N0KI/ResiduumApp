package com.rapi.rapi.models.AvailableWaste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailablewasteRepo extends JpaRepository<AvailablewasteEntity, Long>{
    
}
