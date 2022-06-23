package com.rapi.rapi.models.Colletedwaste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColletedwasteRepo extends JpaRepository<ColletedwasteEntity,Long>{
    
}
