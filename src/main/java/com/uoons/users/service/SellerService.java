package com.uoons.users.service;

import com.uoons.users.enitity.BankDetails;
import com.uoons.users.enitity.BusinessDetails;
import com.uoons.users.enitity.PickupAddress;
import com.uoons.users.enitity.UserEntity;

import java.util.List;

public interface SellerService {

    public UserEntity saveSeller(UserEntity userEntity);

    public UserEntity updateSeller(Long id, UserEntity userEntity);

    public BusinessDetails saveBusinessDetails(BusinessDetails businessDetails, Long id);

    public BusinessDetails getBusinessDetail(Long id);

    public BusinessDetails updateBusinessDetail(Long id, BusinessDetails businessDetails);

    public BankDetails saveBankDetails(BankDetails bankDetails, Long id);

    public BankDetails getBankDetails(Long id);

    public BankDetails updateBankDetails(Long id, BankDetails bankDetails);

    public PickupAddress savePickupAddress(PickupAddress pickupAddress, Long id);

    public PickupAddress getPickupAddress(Long id);

    public PickupAddress updatePickupAddress(Long id, PickupAddress pickupAddress);



}
