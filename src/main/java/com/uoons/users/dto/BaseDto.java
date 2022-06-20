package com.uoons.users.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDto {
    public Date createdDate;
    public Date updateDate;
    public String createdBy;
    public String updatedBy;
    public Boolean isActive;
    public Boolean isDeleted;
}

