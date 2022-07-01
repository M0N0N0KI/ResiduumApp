package com.rapi.rapi.models.Address;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long>{
    
    @Query("select A from AddressEntity A where A.hnumber = ?1 and A.postalcode = ?2 and A.latitude = ?3 and A.longitude = ?4")
    public Optional<AddressEntity> verseExiste(String hnumber, String postalCode, String latitude, String longitude);

}
