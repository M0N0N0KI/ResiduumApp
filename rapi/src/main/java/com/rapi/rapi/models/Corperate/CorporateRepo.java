package com.rapi.rapi.models.Corperate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepo extends JpaRepository<CorporateEntity, Long>{
    
}
