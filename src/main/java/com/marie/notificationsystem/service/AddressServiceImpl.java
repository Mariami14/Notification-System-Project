package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.Address;
import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.model.repository.AddressRepository;
import com.marie.notificationsystem.model.repository.SystemUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceImpl implements AddressService {


    private AddressRepository addressRepository;
    private SystemUser systemUser;
    private SystemUserRepository systemUserRepository;


    @Override
    public Address addAddress(Address address) throws Exception {
        return addressRepository.save(address);
    }

    @Transactional
    @Override
    public boolean updateAddress(Address address) {
        Address existingAddress = addressRepository.findById(address.getId()).orElse(null);
        if (existingAddress != null) {
            existingAddress.setAddressDetails(address.getAddressDetails());
            existingAddress.setActive(address.isActive());
            addressRepository.save(existingAddress);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAddress(Long id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Address> findAddress() {
        SystemUser user = systemUserRepository.findById(systemUser.getId()).orElse(null);
        if (user != null) {
            return addressRepository.findBySystemUser(user);
        }
        return List.of();
    }

    @Override
    public void deleteOutdatedAddresses() {
        List<Address> addresses = addressRepository.findAll();
        for (Address address : addresses) {
            if (!address.isActive()) {
                addressRepository.delete(address);


            }
        }
    }
}