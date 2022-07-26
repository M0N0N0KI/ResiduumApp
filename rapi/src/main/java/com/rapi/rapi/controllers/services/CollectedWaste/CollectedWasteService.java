package com.rapi.rapi.controllers.services.CollectedWaste;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.CollectedWaste.CollectedwasteSDTO;
import com.rapi.rapi.models.Colletedwaste.ColletedwasteEntity;
import com.rapi.rapi.models.Colletedwaste.ColletedwasteRepo;

@Service
public class CollectedWasteService {

    @Autowired
    private ColletedwasteRepo repo;

    public boolean searchExistence(String type, String riskrating, long report)
    {
        Optional<ColletedwasteEntity> search = repo.searchExistence(type, riskrating, report);
        return search.isPresent();
    }

    public ColletedwasteEntity RegisterCollectedWaste(CollectedwasteSDTO cwaste)
    {
        if(searchExistence(cwaste.getType(), cwaste.getRiskrating(), cwaste.getReport()))
        {
            return null;
        }
        else 
        {
            ColletedwasteEntity entity = new ColletedwasteEntity(cwaste);
            return repo.save(entity);
        }
    }

    public ColletedwasteEntity GetCollectedWaste(Long id)
    {
        Optional<ColletedwasteEntity> search = repo.findById(id);
        return search.get();
    }

    public ResponseEntity UpateCollectedWaste(CollectedwasteSDTO cwaste)
    {
        ColletedwasteEntity entity = new ColletedwasteEntity(cwaste);
        ColletedwasteEntity update = repo.save(entity);
        if(entity.equals(update))
        {
            return ResponseEntity.ok("Valores atualizados");
        }
        else
        {
            return ResponseEntity.ok("Erro ao atualizar Dados");
        }
    }

    public List<Long> ListofWasteid(Long id)
    {
        return repo.listIDbyReport(id);
    }
    public List<ColletedwasteEntity> ListofWaste(Long id)
    {
        return null;
    }
    
}
