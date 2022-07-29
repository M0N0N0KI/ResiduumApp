package com.rapi.rapi.controllers.services.Certificate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Certificate.CertificateSDTO;
import com.rapi.rapi.models.Certificate.CertificateEntity;
import com.rapi.rapi.models.Certificate.CertificateRepo;

@Service
public class CertificateService {
    
    @Autowired
    private CertificateRepo repo;

    public Boolean SearchExistence(String number)
    {
        Optional<CertificateEntity> search = repo.searchExistencebyNumber(number);
        return search.isPresent();
    }

    public CertificateEntity RegisterCertificate(CertificateSDTO certificate)
    {
        CertificateEntity entity = new CertificateEntity(certificate);
        return repo.save(entity);
    }

    public ResponseEntity AddCertificate(CertificateSDTO certificate)
    {
        if(SearchExistence(certificate.getNumber()))
        {
            return ResponseEntity.ok("Certificado já cadastrado");
        }
        else
        {
            CertificateEntity entity = new CertificateEntity(certificate);
            CertificateSDTO response = new CertificateSDTO(repo.save(entity));
            return (response != null)
                ?ResponseEntity.ok(response)
                :ResponseEntity.ok("Erro ao cadastrar Certificado");
        }
    }

    public CertificateEntity GetCertificate(Long id)
    {
        Optional<CertificateEntity> search = repo.findById(id);
        return search.get();
    }

    public ResponseEntity GetCertificateByID(Long id)
    {
        CertificateSDTO response = new CertificateSDTO(GetCertificate(id));
        return(response != null)
            ?ResponseEntity.ok(response)
            :ResponseEntity.ok("Erro ao Recuperar Certificado");
    }

    public ResponseEntity UpdateCertificate(CertificateSDTO certificate)
    {
        CertificateEntity entity = new CertificateEntity(certificate);
        CertificateEntity update = repo.save(entity);
        return(entity.equals(update))
            ?ResponseEntity.ok("Atualizado com Sucesso")
            :ResponseEntity.ok("Erro em atualizar Certificado");
    }

}
