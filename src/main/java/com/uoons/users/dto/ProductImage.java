package com.uoons.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductImage {

    private long productImageId;

    private URL productImageUrl;

    private String imageType;

}
