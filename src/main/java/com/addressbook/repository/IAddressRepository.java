package com.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addressbook.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
