package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress (Address address) throws Exception;

    boolean updateAddress (Address address);

    boolean deleteAddress(Long id);

    List<Address> findAddress();

    void deleteOutdatedAddresses();
}
