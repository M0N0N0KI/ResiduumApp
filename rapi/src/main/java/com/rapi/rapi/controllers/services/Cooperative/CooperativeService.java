package com.rapi.rapi.controllers.services.Cooperative;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Cooperative.CooperativeSDTO;
import com.rapi.rapi.models.AvailableWaste.AvailablewasteEntity;
import com.rapi.rapi.models.Certificate.CertificateEntity;
import com.rapi.rapi.models.Cooperative.CooperativeEntity;
import com.rapi.rapi.models.Cooperative.CooperativeRepo;
import com.rapi.rapi.models.Ivoice.IvoiceEntity;

@Service
public class CooperativeService {

    @Autowired
    private CooperativeRepo repo;

    public Boolean SearchExistence(String identifier)
    {
        Optional<CooperativeEntity> search = repo.searchExistence(identifier);
        return search.isPresent();
    }

    public CooperativeEntity RegisterCooperative(CooperativeSDTO cooperative)
    {
        CooperativeEntity entity = new CooperativeEntity(cooperative);
        return repo.save(entity);
    }

    public ResponseEntity AddCooperative(CooperativeSDTO cooperative)
    {
        CooperativeEntity searchdata = new CooperativeEntity(cooperative);
        if(SearchExistence(searchdata.getUser().getIdentifier()))
        {
            return ResponseEntity.ok("Cooperativa ja Cadastrada");
        }
        else
        {
            CooperativeEntity entity = new CooperativeEntity(cooperative);
            CooperativeSDTO response = new CooperativeSDTO(repo.save(entity));
            return(response != null)
                ?ResponseEntity.ok(response)
                :ResponseEntity.ok("Erro ao Cadastrar Cooperativa");
        }
    }

    public CooperativeEntity GetCooperative(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        return search.get();
    }

    public ResponseEntity GetCooperativeByID(Long id)
    {
        CooperativeSDTO response = new CooperativeSDTO(GetCooperative(id));
        return(response != null)
            ?ResponseEntity.ok(response)
            :ResponseEntity.ok("Erro em recuperar Cooperativa");
    }

    public ResponseEntity UpdateCooperative(CooperativeSDTO cooperative)
    {
        CooperativeEntity entity = new CooperativeEntity(cooperative);
        CooperativeEntity update = repo.save(entity);
        return(entity.equals(update))
            ?ResponseEntity.ok("Atualizado com Sucesso")
            :ResponseEntity.ok("Erro ao Atualizar");
    }

    public List<AvailablewasteEntity> listofAvailableWaste(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        return search.get().getAvailablewaste();
    }
    public List<CertificateEntity> listofCertificate(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        return search.get().getCertificatesissued();
    }

    public List<IvoiceEntity> listofIvoices(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        return search.get().getIvoicedissued();
    }

    public List<Long> ListAWasteIDs(long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            CooperativeEntity cooperative = search.get();
            if(cooperative.getAvailablewaste() != null)
            {
                List<Long> ids = new ArrayList<>();
                for(AvailablewasteEntity awaste : cooperative.getAvailablewaste())
                {
                    ids.add(awaste.getId());
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

    public List<Long> ListCertificateIDs(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            CooperativeEntity cooperative = search.get();
            if(cooperative.getCertificatesissued() != null)
            {
                List<Long> ids = new ArrayList<>();
                for(CertificateEntity certificate : cooperative.getCertificatesissued())
                {
                    ids.add(certificate.getId());
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

    public List<Long> ListIvoiceIDs(Long id)
    {
        Optional<CooperativeEntity> search = repo.findById(id);
        if(search.isPresent())
        {
            CooperativeEntity cooperative = search.get();
            if(cooperative.getIvoicedissued() != null)
            {
                List<Long> ids = new ArrayList<>();
                for(IvoiceEntity ivoices : cooperative.getIvoicedissued())
                {
                    ids.add(ivoices.getId());
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
