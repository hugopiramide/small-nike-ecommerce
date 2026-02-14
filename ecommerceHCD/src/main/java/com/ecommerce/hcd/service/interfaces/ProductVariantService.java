package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.ProductVariant;
import com.ecommerce.hcd.dto.request.ProductVariantRequest;
import com.ecommerce.hcd.dto.response.ProductVariantResponse;

public interface ProductVariantService {

    List<ProductVariant> findAll();

    Optional<ProductVariant> findById(Long id);

    ProductVariant save(ProductVariant productVariant);

    ProductVariant update(Long id, ProductVariant productVariant);
    
    void deleteById(Long id);

    List<ProductVariantResponse> findAllDto();

    Optional<ProductVariantResponse> findByIdDto(Long id);

    ProductVariantResponse saveDto(ProductVariantRequest req);

    ProductVariantResponse updateDto(Long id, ProductVariantRequest req);
}
