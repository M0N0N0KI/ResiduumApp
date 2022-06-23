package com.rapi.rapi.models.CollectRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectrequestRepo extends JpaRepository<CollectrequestEntity, Long>{
    
}
