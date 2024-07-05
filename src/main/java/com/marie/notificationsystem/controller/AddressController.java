package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.model.model.Address;
import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.service.AddressService;
import com.marie.notificationsystem.service.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth/address")
public class AddressController {

    private final AddressService addressService;
    private final SystemUserService systemUserService;

    @Autowired
    public AddressController(AddressService addressService, SystemUserService systemUserService) {
        this.addressService = addressService;
        this.systemUserService = systemUserService;
    }

    @GetMapping("/get-addresses")
    public ResponseEntity<List<Address>> getAddresses(@AuthenticationPrincipal SystemUser systemUser) {
        List<Address> addresses = addressService.findAddress();
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/add-address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address, @AuthenticationPrincipal SystemUser systemUser) throws Exception {
        address.setSystemUser(systemUser);
        Address newAddress = addressService.addAddress(address);
        return ResponseEntity.ok(newAddress);
    }

    @PutMapping("/update-address")
    public ResponseEntity<Boolean> updateAddress(@RequestBody Address address) {
        try {
            boolean updated = addressService.updateAddress(address);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping("/delete-address/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
