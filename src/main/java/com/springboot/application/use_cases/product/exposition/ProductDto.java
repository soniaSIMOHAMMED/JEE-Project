package com.springboot.application.use_cases.product.exposition;

import com.springboot.application.use_cases.product.domain.Fragrance;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductDto {

    public Long productId;

    @NotEmpty(message = "product name should not be null or empty")
    public String productName;

    @NotEmpty(message = "product fragrance should not be null or empty")
    public String fragrance;

}
