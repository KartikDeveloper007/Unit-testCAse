package com.uoons.users.serviceImpl;


import com.uoons.users.enitity.RoleEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.repository.RoleRepository;
import com.uoons.users.repository.UserRepository;
import com.uoons.users.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${role.name.admin}")
    private String adminRole;

    @Value("${role.name.customer}")
    private String customerRole;

    @Value("${role.name.seller}")
    private String sellerRole;

    @Override
    public UserEntity saveAdmin(UserEntity admin) {
        if (admin.getFirstName().isEmpty() || admin.getLastName().isEmpty() ||
                admin.getEmail().isEmpty() || admin.getPassword().isEmpty()) {
            throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "please fill all fields");
        } else {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin.setCreatedBy(admin.getEmail());
            admin.setCreatedDate(new Date());
            admin.setIsActive(Boolean.TRUE);
            admin.setIsDeleted(Boolean.FALSE);
            RoleEntity roleCustomer = roleRepository.findByRoleName(adminRole);
            admin.addRole(roleCustomer);

            return userRepository.save(admin);
        }

    }


    @Override
    public List<UserEntity> getAllUser() {

        List<UserEntity> userEntities = userRepository.findAll();
        if (ObjectUtils.isEmpty(userEntities)) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Does not have any list");
        }
        else {
            return userEntities;
        }
    }


    @Override
    public List<UserEntity> getAllCustomer() {

        List<UserEntity> userList = userRepository.findAll();
        if (ObjectUtils.isEmpty(userList)) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Does not have any coustomer !!");
        }
        else {
            List<UserEntity> customerList = userList.stream().filter(user -> user.getRole().contains(roleRepository.findByRoleName(customerRole))).collect(Collectors.toList());
            return customerList;
        }
    }


    @Override
    public UserEntity getSeller(Long id) {
        UserEntity seller = userRepository.findSellerById(id);
        if (seller==null) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "No Seller Found !!");

        } else {
            return seller;
        }
    }

    @Override
    public List<UserEntity> getAllSeller() {
        List<UserEntity> userEntities = userRepository.findAll();
        if (ObjectUtils.isEmpty(userEntities)) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Seller List is not exist !");
        }else {
            List<UserEntity> userlist=userEntities.stream().filter(user -> user.getRole().contains(roleRepository.findByRoleName(sellerRole))).collect(Collectors.toList());
            return userlist;

        }
    }

    @Override
    public void isDeleted(Long id) {

            Optional<UserEntity> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()) {
                UserEntity byId=optionalUser.get();
                byId.setIsActive(Boolean.FALSE);
                byId.setIsDeleted(Boolean.TRUE);
                userRepository.save(byId);
            }else {
                throw new NotFound(HttpStatus.NOT_FOUND.value(),"Please enter the valid id !");
            }
        }

    @Override
    public void isActive(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                UserEntity byId=optionalUser.get();
                byId.setIsActive(Boolean.TRUE);
                byId.setIsDeleted(Boolean.FALSE);
                userRepository.save(byId);
            } else {
                throw new NotFound(HttpStatus.NOT_FOUND.value(), "Please enter the valid id !!");
            }
    }
}
