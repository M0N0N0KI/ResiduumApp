package com.rapi.rapi.controllers.services.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Auth.AuthDTO;
import com.rapi.rapi.controllers.DTO.User.UserSDTO;
import com.rapi.rapi.models.User.UserEntity;
import com.rapi.rapi.models.User.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Boolean searchExistence(String identifier)
    {
        Optional<UserEntity> search = repo.SearchByIdentifier(identifier);
        return search.isEmpty();
    }

    public UserEntity RegisterUser(UserSDTO data)
    {
        if(searchExistence(data.getIdentifier()))
        {
            UserEntity entity = new UserEntity(data);
            UserEntity response = repo.save(entity);
            return response;
        }
        else
        {
            return null;
        }
    }

    public ResponseEntity addUser(UserSDTO data, String type)
    {
        UserEntity user = RegisterUser(data);
        if(user != null)
        {
            if(type == "pessoaF")
            {
                return null;
            }
            else if(type == "pessoaJ")
            {
                return null;
            }
            else if(type == "Cooperativa")
            {
                return null;
            }
            else if(type == "prefeitura")
            {
                return null;
            }
            else 
            {
                return null;
            }
        }
        else
        {
            return ResponseEntity.ok("Usuario ja Cadastrado");
        }
    }

    public ResponseEntity UpdateUser(UserSDTO user)
    {
        UserEntity entity = new UserEntity(user);
        repo.save(entity);
        return ResponseEntity.ok("Usuario Atualizado");
    }


    public ResponseEntity ValidateUser(AuthDTO auth)
    {
        Optional<UserEntity> search = repo.ValidateUser(auth.getIdentifier(), auth.getPassword());
        if(search.isEmpty())
        {
            return ResponseEntity.ok("Usuario não encontrado");
        }
        else
        {
            UserSDTO response = new UserSDTO(search.get());
            return ResponseEntity.ok(response);
        }
    }
    
}
