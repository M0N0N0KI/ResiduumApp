package com.rapi.rapi.models.Address;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long>{

    @Query("select A from AddressEntity A where A.postalCode = ?1")
    public Optional<AddressEntity> SearchExistence(String postalCode);

}
