package com.rapi.rapi.models.Certificate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<CertificateEntity, Long>{
    
    @Query("select C from CertificateEntity C where C.number = ?1")
    public Optional<CertificateEntity> searchExistencebyNumber(String number);

}
