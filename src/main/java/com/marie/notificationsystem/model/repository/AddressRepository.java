package com.marie.notificationsystem.model.repository;

import com.marie.notificationsystem.model.model.Address;
import com.marie.notificationsystem.model.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository <Address, Long> {
    List<Address> findBySystemUser (SystemUser user);
}
