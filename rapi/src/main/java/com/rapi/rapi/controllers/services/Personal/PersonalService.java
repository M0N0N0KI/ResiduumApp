package com.rapi.rapi.controllers.services.Personal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Personal.PersonalSDTO;
import com.rapi.rapi.models.Personal.PersonalEntity;
import com.rapi.rapi.models.Personal.PersonalRepo;
import com.rapi.rapi.models.User.UserEntity;

@Service
public class PersonalService {

    @Autowired
    public PersonalRepo repo;

    public PersonalSDTO RegisterPersonal(UserEntity user)
    {
        PersonalEntity entity = new PersonalEntity(user);
        return new PersonalSDTO(repo.save(entity));
    }

    public ResponseEntity AddScore(double Score, Long id)
    {
        Optional<PersonalEntity> search = repo.findById(id);
        if(search.isEmpty())
        {
            return ResponseEntity.ok("Usuario não encontrado");
        }
        else
        {
            double oldscore = Double.parseDouble(search.get().getScore());
            String response = Double.toString(oldscore + Score);
            PersonalEntity update = search.get();
            update.setScore(response);
            repo.save(update);
            return ResponseEntity.ok(response);
        }
    }

    public PersonalSDTO GetSimplePersonal(Long id)
    {
        Optional<PersonalEntity> search = repo.searchByUserID(id);   
        return new PersonalSDTO(search.get());
    }
    
}
