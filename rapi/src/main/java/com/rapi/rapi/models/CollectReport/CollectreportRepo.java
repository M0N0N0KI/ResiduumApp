package com.rapi.rapi.models.CollectReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectreportRepo extends JpaRepository<CollectreportEntity, Long>{
    
}
