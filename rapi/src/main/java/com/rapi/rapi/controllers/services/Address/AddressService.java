package com.rapi.rapi.controllers.services.Address;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Address.AddressDTO;
import com.rapi.rapi.models.Address.AddressEntity;
import com.rapi.rapi.models.Address.AddressRepo;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepo repo;

    public AddressEntity registerAddress(AddressDTO address)
    {
        Optional<AddressEntity> search = repo.verseExiste(
            address.getHnumber(), 
            address.getPostalCode(), 
            address.getLatitude(), 
            address.getLongitude());
        if(search.isEmpty())
        {
            AddressEntity entity = new AddressEntity(address);
            return repo.save(entity);
        }
        else
        {
            return search.get();
        }
    }

    public AddressDTO searchById(Long id)
    {
        final Optional<AddressEntity> search = repo.findById(id);
        if(search.isEmpty())
        {
            return null;
        }
        else
        {
            AddressDTO address = new AddressDTO(search.get());
            return address;
        }
    }
}
