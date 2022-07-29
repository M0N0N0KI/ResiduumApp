package com.rapi.rapi.controllers.services.WasteSold;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.WasteSold.WastesoldSDTO;
import com.rapi.rapi.models.WasteSold.WastesoldEntity;
import com.rapi.rapi.models.WasteSold.WastesoldRepo;

@Service
public class WasteSoldService {

    @Autowired
    private WastesoldRepo repo;

    public Boolean SearchExistence(WastesoldSDTO wsold)
    {
        Optional<WastesoldEntity> search = repo.searchExistence(wsold.getType(), wsold.getRiskrating(), wsold.getIvoice());
        return search.isPresent();
    }

    public WastesoldEntity RegisterWasteSold(WastesoldSDTO wsold)
    {
        WastesoldEntity entity = new WastesoldEntity(wsold);
        return repo.save(entity);
    }

    public ResponseEntity AddWasteSold(WastesoldSDTO wsold)
    {
        if(SearchExistence(wsold))
        {
            return ResponseEntity.ok("Residuo ja cadastrado nessa nota");
        }
        else
        {
            WastesoldEntity entity = new WastesoldEntity(wsold);
            WastesoldSDTO response = new WastesoldSDTO(repo.save(entity));
            return (response != null)
                ?ResponseEntity.ok(response)
                :ResponseEntity.ok("Erro ao Cadastrar Residuo a nota");
        }
    }

    public WastesoldEntity GetWasteSold(Long id)
    {
        Optional<WastesoldEntity> search = repo.findById(id);
        return search.get();
    }

    public ResponseEntity GetWasteSoldByID(Long id)
    {
        WastesoldSDTO response = new WastesoldSDTO(GetWasteSold(id));
        return(response != null)
            ?ResponseEntity.ok(response)
            :ResponseEntity.ok("Erro ao recuperar Registro");
    }

    public ResponseEntity UpdateWasteSold(WastesoldSDTO wsold)
    {
        WastesoldEntity entity = new WastesoldEntity(wsold);
        WastesoldEntity update = repo.save(entity);
        return(entity.equals(update))
            ?ResponseEntity.ok("Atualizado com Sucesso")
            :ResponseEntity.ok("Erro em atualizar Certificado");
    }
    
}
