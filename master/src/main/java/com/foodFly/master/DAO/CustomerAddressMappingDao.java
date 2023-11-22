package com.foodFly.master.DAO;

import com.foodFly.master.Model.CustomerAddressMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerAddressMappingDao extends JpaRepository<CustomerAddressMapping, UUID> {

   void deleteByCustomerIdAndAddressId(Long customerId,Long addressId);
}
