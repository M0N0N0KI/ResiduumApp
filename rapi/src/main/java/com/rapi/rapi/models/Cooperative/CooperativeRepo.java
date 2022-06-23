package com.rapi.rapi.models.Cooperative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepo extends JpaRepository<CooperativeEntity, Long>{
    
}
