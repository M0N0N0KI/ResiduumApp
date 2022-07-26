package com.rapi.rapi.models.Colletedwaste;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColletedwasteRepo extends JpaRepository<ColletedwasteEntity,Long>{
    
    @Query("select C from ColletedwasteEntity C where C.type = ?1 and C.riskrating = ?2 and C.report.id = ?3")
    public Optional<ColletedwasteEntity> searchExistence(String type, String risk,long report);

    @Query("select C.id from ColletedwasteEntity C where C.report.id = ?1")
    public List<Long> listIDbyReport(Long id);

    @Query("select C from ColletedwasteEntity C where C.report.id = ?1")
    public List<ColletedwasteEntity> listWastebyReport(Long id);

}
