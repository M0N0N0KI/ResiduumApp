package com.rapi.rapi.models.Address;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long>{

}
