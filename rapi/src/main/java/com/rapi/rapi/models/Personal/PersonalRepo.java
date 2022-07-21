package com.rapi.rapi.models.Personal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepo extends JpaRepository<PersonalEntity, Long>{

    @Query("select P from PersonalEntity P where P.user.id = ?1")
    public Optional<PersonalEntity> searchByUserID(Long id);
    
}
