package com.rapi.rapi.models.Cooperative;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepo extends JpaRepository<CooperativeEntity, Long>{

    @Query("select C from CooperativeEntity C where C.user.identifier =?2")
    public Optional<CooperativeEntity> searchExistence(String identifier);
    
}
