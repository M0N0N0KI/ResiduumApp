package com.rapi.rapi.controllers.services.Contact;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Contact.ContactDTO;
import com.rapi.rapi.models.Contact.ContactEntity;
import com.rapi.rapi.models.Contact.ContactRepo;
import com.rapi.rapi.models.User.UserEntity;
import com.rapi.rapi.models.User.UserRepo;

@Service
public class ContactService {

    @Autowired
    private ContactRepo repo;
    private UserRepo urepo;

    public ContactEntity RegisterContact(ContactDTO data)
    {
        ContactEntity entity = new ContactEntity(data);
        ContactEntity response = repo.save(entity);
        return response;
    }

    public ResponseEntity addContact(ContactDTO data, long id)
    {
        ContactEntity contact = RegisterContact(data);
        if(contact !=null)
        {
            Optional<UserEntity> user = urepo.findById(id);
            user.get().setContact(contact);
            UserEntity test = urepo.save(user.get());
            if(test.getContact().getId() == contact.getId())
            {
                return ResponseEntity.ok(Long.toString(test.getContact().getId()));
            }
            else
            {
                return ResponseEntity.ok("0");
            }
        }
        else
        {
            return ResponseEntity.ok("0");
        }
    }

    public ResponseEntity UpdateContact(ContactDTO contact)
    {
        ContactEntity entity = new ContactEntity(contact);
        repo.save(entity);
        return ResponseEntity.ok("Contato Atualizado");
    }

    public ResponseEntity GetContactById(Long id)
    {
        Optional<ContactEntity> search = repo.findById(id);
        ContactDTO response = new ContactDTO(search.get());
        return ResponseEntity.ok(response);
    }

    public ContactEntity GetContactByID(Long id)
    {
        Optional<ContactEntity> search = repo.findById(id);
        return search.get();
    }

}
