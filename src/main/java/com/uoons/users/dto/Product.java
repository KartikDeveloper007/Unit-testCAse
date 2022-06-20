package com.uoons.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private long productId;

    private String productName;

    private String brand;

    private double weight;

    private double length;

    private double height;

    private double width;
    private double price;

    private double offerPrice;

    private String color;

    private String varient;

    private String salientFeatures;
    private long userId;

    private boolean isAvailable;

    private int totalQuantity;

    private String description;

    private int gst;

    private List<ProductImage> productImages = new ArrayList<>();

    private Category category = new Category();

}
