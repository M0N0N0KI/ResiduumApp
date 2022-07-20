package com.rapi.rapi.controllers.services.Address;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.Address.AddressDTO;
import com.rapi.rapi.models.Address.AddressEntity;
import com.rapi.rapi.models.Address.AddressRepo;
import com.rapi.rapi.models.User.UserEntity;
import com.rapi.rapi.models.User.UserRepo;
@Service
public class AddressService {

    @Autowired
    private AddressRepo repo;
    private UserRepo urepo;

    public Boolean AlreadyExist(AddressDTO data)
    {
        Optional<AddressEntity> entity = repo.SearchExistence(data.getPostalCode());
        boolean exist = true;
        if(entity.isEmpty()) exist = false;
        else 
        {
            int x = 0;
            if(entity.get().getStreet() == data.getStreet()) x++;
            if(entity.get().getHnumber() == data.getHnumber()) x++;
            if(entity.get().getDistrict() == data.getDistrict()) x++;
            if(entity.get().getComplement() == data.getComplement()) x++;
            if(entity.get().getCity() == data.getCity()) x++;
            if(entity.get().getState() == data.getState()) x++;
            if(entity.get().getCountry() == data.getCountry()) x++;
            if(entity.get().getPostalCode() == data.getPostalCode()) x++;
            if(entity.get().getLatitude() == data.getLatitude()) x++;
            if(entity.get().getLongitude() == data.getLongitude()) x++;

            if(x == 10) exist = true;

        }
        return exist;
    }

    public AddressEntity RegisterAddress(AddressDTO data)
    {
        AddressEntity entity = null;
        if(AlreadyExist(data))
        {
            Optional<AddressEntity> wrap = repo.SearchExistence(data.getPostalCode());
            entity = wrap.get();
        }
        else
        {
            AddressEntity store = new AddressEntity(data);
            entity = repo.save(store);
        }
        return entity;
    }

    public ResponseEntity addAddress(AddressDTO data, long id, String stakeholder)
    {
        AddressEntity address = RegisterAddress(data);
        if(stakeholder == "user")
        {
            Optional<UserEntity> user = urepo.findById(id);
            user.get().setAddress(address);
            UserEntity test = urepo.save(user.get());
            if(test.getAddress().getId() == address.getId())
            {
                return ResponseEntity.ok(Long.toString(test.getAddress().getId()));
            }
            else
            {
                return ResponseEntity.ok("0");
            }
        }
        return null;
    }

    public ResponseEntity UpdateAddress(AddressDTO data)
    {
        AddressEntity store = new AddressEntity(data);
        repo.save(store);
        return ResponseEntity.ok("Endereco Atualizado");
    }

    public ResponseEntity GetAddressById(Long id)
    {
        Optional<AddressEntity> search = repo.findById(id);
        AddressDTO response = new AddressDTO(search.get());
        return ResponseEntity.ok(response);
    }

    public AddressEntity GetAddressByID(Long id)
    {
        Optional<AddressEntity> search = repo.findById(id);
        return search.get();
    }

}
