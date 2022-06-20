package com.uoons.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@AllArgsConstructor
public enum AddressType {
    HOME("HOME"),OFFICE("OFFICE"),OTHER("OTHER");
    private String addressType;

    AddressType(String addressType){
        this.addressType = addressType;
    }


}
