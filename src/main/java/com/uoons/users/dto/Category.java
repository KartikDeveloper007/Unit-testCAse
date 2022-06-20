package com.uoons.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uoons.users.enitity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends BaseEntity {
    private Long categoryId;

    private String categoryName;

    private Long userId;

    private Boolean isDeleted;

    private Boolean isActive;

    private Category parentCategory;

    private List<Category> subCategories;

    private List<Product> products;

}