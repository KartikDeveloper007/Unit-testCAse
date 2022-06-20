package com.uoons.users.service;

import com.uoons.users.enitity.UserEntity;

import java.util.List;

public interface AdminService {

    public UserEntity saveAdmin(UserEntity admin);


    public List<UserEntity> getAllUser();

    public List<UserEntity> getAllCustomer();


    public List<UserEntity> getAllSeller();
    public UserEntity getSeller(Long email);

    public void isDeleted(Long id);

    public void isActive(Long id);
}
