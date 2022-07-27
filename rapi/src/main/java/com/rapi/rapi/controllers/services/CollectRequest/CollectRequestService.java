package com.rapi.rapi.controllers.services.CollectRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.CollectRequest.CollectrequestSDTO;
import com.rapi.rapi.models.CollectRequest.CollectrequestEntity;
import com.rapi.rapi.models.CollectRequest.CollectrequestRepo;
import com.rapi.rapi.models.User.UserEntity;

@Service
public class CollectRequestService {

    @Autowired
    private CollectrequestRepo repo;

    public CollectrequestEntity RegisterRequest(CollectrequestSDTO request)
    {
        CollectrequestEntity entity = new CollectrequestEntity(request);
        return repo.save(entity);
    }

    public CollectrequestEntity GetRequest(Long id)
    {
        Optional<CollectrequestEntity> search = repo.findById(id);
        return search.get();
    }
    
    public ResponseEntity GetRequestbyID(Long id)
    {
        CollectrequestSDTO response = new CollectrequestSDTO(GetRequest(id));
        return ResponseEntity.ok(response);
    }

    public ResponseEntity UpdateRequest(CollectrequestSDTO request)
    {
        CollectrequestEntity entity = new CollectrequestEntity(request);
        CollectrequestEntity update = repo.save(entity);
        return(entity.equals(update))
            ?ResponseEntity.ok("Atualizado com sucesso")
            :ResponseEntity.ok("Erro ao Atualizar");
    }
    
    public Set<UserEntity> listApplicantsbyRequest(Long id)
    {
        Optional<CollectrequestEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            CollectrequestEntity request = search.get();
            return(request.getUserr() != null)
                ?request.getUserr()
                :null;
        }
        else
        {
            return null;
        }
    }
    
    public List<Long> listApplicantidbyRequest(Long id)
    {
        Optional<CollectrequestEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            CollectrequestEntity request = search.get();
            if(request.getUserr() != null)
            {
                List<Long> ids = new ArrayList<>();
                for(UserEntity entity : request.getUserr())
                {
                    ids.add(entity.getId());
                }
                return ids;
            }
            else
            {
                return null;
            }
        }
        else 
        {
            return null;
        }
    }
    
}
