package com.rapi.rapi.controllers.services.AvailableWaste;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.AvailableWaste.AvailablewasteSDTO;
import com.rapi.rapi.models.AvailableWaste.AvailablewasteEntity;
import com.rapi.rapi.models.AvailableWaste.AvailablewasteRepo;

@Service
public class AvailableWasteService {

    @Autowired
    private AvailablewasteRepo repo;

    public Boolean SearchExistence(String type, String riskrating, Long owner)
    {
        Optional<AvailablewasteEntity> search = repo.searchExistence(type, riskrating, owner);
        return search.isPresent();
    }

    public AvailablewasteEntity RegisterAvailableWaste(AvailablewasteSDTO awaste)
    {
        AvailablewasteEntity entity = new AvailablewasteEntity(awaste);
        return repo.save(entity);
    }

    public ResponseEntity AddAvailableWaste(AvailablewasteSDTO awaste)
    {
        if(SearchExistence(awaste.getType(), awaste.getRiskrating(), awaste.getOwner()))
        {
            return ResponseEntity.ok("Tipo de Residuo ja Cadastrado");
        }
        else
        {
            AvailablewasteEntity entity = new AvailablewasteEntity(awaste);
            AvailablewasteSDTO response = new AvailablewasteSDTO(repo.save(entity));
            return(response != null)
                ?ResponseEntity.ok(response)
                :ResponseEntity.ok("Erro ao Cadastrar Tipo de Residuo");
        }
    }

    public AvailablewasteEntity GetAvailableWaste(Long id)
    {
        Optional<AvailablewasteEntity> search = repo.findById(id);
        return search.get();
    }
    
    public ResponseEntity GetAvailableWasteByID(Long id)
    {
        AvailablewasteSDTO response = new AvailablewasteSDTO(GetAvailableWaste(id));
        return(response != null)
            ?ResponseEntity.ok(response)
            :ResponseEntity.ok("Erro Tipo de Residuo não encontrado");
    }

    public ResponseEntity UpdateAvailableWaste(AvailablewasteSDTO awaste)
    {
        AvailablewasteEntity entity = new AvailablewasteEntity(awaste);
        AvailablewasteEntity update = repo.save(entity);
        return (entity.equals(update))
            ?ResponseEntity.ok("Atualizado com sucesso")
            :ResponseEntity.ok("Erro ao atualizar Residuo");
    }
    
}
