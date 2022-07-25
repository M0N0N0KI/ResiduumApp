package com.rapi.rapi.controllers.services.Corporate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Corporate.CorporateSDTO;
import com.rapi.rapi.models.Corperate.CorporateEntity;
import com.rapi.rapi.models.Corperate.CorporateRepo;
import com.rapi.rapi.models.User.UserEntity;

@Service 
public class CorporateService {

    @Autowired
    public CorporateRepo repo;

    public CorporateSDTO RegisterCorporate(UserEntity user)
    {
        CorporateEntity entity = new CorporateEntity(user);
        return new CorporateSDTO(repo.save(entity));
    }

    public CorporateSDTO GetSimpleCorporate(Long id)
    {
        Optional<CorporateEntity> search = repo.searchByUserID(id);
        return new CorporateSDTO(search.get());
    }
    
}
