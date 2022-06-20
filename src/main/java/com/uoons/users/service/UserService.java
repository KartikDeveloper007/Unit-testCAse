package com.uoons.users.service;

import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.exception.BusinessException;

import java.util.List;

public interface UserService {
    public UserEntity saveCustomer(UserEntity userEntity);

    public UserEntity updateCustsomer(UserEntity userEntity, Long id);


    public  AddressEntity saveAddress(AddressEntity address, Long userid, AddressType addressType) throws Exception;

    public  AddressEntity updateAddress(AddressEntity address, Long userid);

    public List<AddressEntity> getAddresses(Long userid);
    public UserEntity getById(Long id);

   public String isPrimaryAddress(Long userid,AddressType addressType);
}
