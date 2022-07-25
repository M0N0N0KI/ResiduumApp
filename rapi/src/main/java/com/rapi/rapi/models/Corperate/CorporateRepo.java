package com.rapi.rapi.models.Corperate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepo extends JpaRepository<CorporateEntity, Long>{
    
    @Query("select C from CorporateEntity C where C.user.id = ?1")
    public Optional<CorporateEntity> searchByUserID(Long id);

}
