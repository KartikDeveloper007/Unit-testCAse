package com.uoons.users.repository;

import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    List<AddressEntity> findByUserId(Long userid);
    AddressEntity findByAddressType(String addressType);
    AddressEntity findByUserIdAndAddressType(Long userid,String addressType);
}
