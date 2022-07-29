package com.rapi.rapi.controllers.services.Ivoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Ivoice.IvoiceSDTO;
import com.rapi.rapi.models.Ivoice.IvoiceEntity;
import com.rapi.rapi.models.Ivoice.IvoiceRepo;
import com.rapi.rapi.models.WasteSold.WastesoldEntity;

@Service
public class IvoiceService {
    
    @Autowired
    private IvoiceRepo repo;

    public Boolean SearchExistence(String issuenumber)
    {
        Optional<IvoiceEntity> search = repo.searchExistence(issuenumber);
        return search.isPresent();
    }

    public IvoiceEntity RegisteIvoice(IvoiceSDTO ivoice)
    {
        IvoiceEntity entity = new IvoiceEntity(ivoice);
        return repo.save(entity);
    }

    public ResponseEntity AddIvoice(IvoiceSDTO ivoice)
    {
        if(SearchExistence(ivoice.getIssuenumber()))
        {
            return ResponseEntity.ok("Nota ja Cadastrada");
        }
        else
        {
            IvoiceEntity entity = new IvoiceEntity(ivoice);
            IvoiceSDTO response = new IvoiceSDTO(repo.save(entity));
            return(response != null)
                ?ResponseEntity.ok(response)
                :ResponseEntity.ok("Erro ao Cadastrar Nota");
        }
    }

    public IvoiceEntity GetIvoice(Long id)
    {
        Optional<IvoiceEntity> search = repo.findById(id);
        return search.get();
    }

    public ResponseEntity GetIvoiceByID(Long id)
    {
        IvoiceSDTO response = new IvoiceSDTO(GetIvoice(id));
        return(response != null)
            ?ResponseEntity.ok(response)
            :ResponseEntity.ok("Erro em Recuperar a Nota");
    }

    public ResponseEntity UpdateIvoice(IvoiceSDTO ivoice)
    {
        IvoiceEntity entity = new IvoiceEntity(ivoice);
        IvoiceEntity update = repo.save(entity);
        return (entity.equals(update))
            ?ResponseEntity.ok("Atualizado com sucesso")
            :ResponseEntity.ok("Erro ao atualizar");
    }

    public List<WastesoldEntity> ListWasteSold(Long id)
    {
        Optional<IvoiceEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            IvoiceEntity ivoice = search.get();
            return ivoice.getWastesold();
        }
        else
        {
            return null;
        }
    }

    public List<Long> ListWasteSoldIDs(Long id)
    {
        Optional<IvoiceEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            IvoiceEntity ivoice = search.get();
            if(ivoice.getWastesold() != null)
            {
                List<Long> ids = new ArrayList<>();
                for(WastesoldEntity wsold : ivoice.getWastesold())
                {
                    ids.add(wsold.getId());
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
