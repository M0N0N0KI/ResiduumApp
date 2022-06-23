package com.rapi.rapi.models.WasteSold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WastesoldRepo extends JpaRepository<WastesoldEntity, Long>{
    
}
