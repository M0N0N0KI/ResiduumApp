package com.rapi.rapi.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
    
    @Query("select U from UserEntity U where U.identifier = ?1")
    public Optional<UserEntity> SearchByIdentifier(String identifier);

    @Query("select U from UserEntity U where U.identifier = ?1 and U.password = ?2")
    public Optional<UserEntity> ValidateUser(String identifier, String password);
}
