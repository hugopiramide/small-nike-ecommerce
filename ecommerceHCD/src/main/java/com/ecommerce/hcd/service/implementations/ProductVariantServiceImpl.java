package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.ProductVariant;
import com.ecommerce.hcd.repository.ProductVariantRepository;
import com.ecommerce.hcd.service.interfaces.ProductVariantService;
import com.ecommerce.hcd.dto.request.ProductVariantRequest;
import com.ecommerce.hcd.dto.response.ProductVariantResponse;
import com.ecommerce.hcd.mapper.ProductVariantMapper;
import java.util.ArrayList;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    public ProductVariantServiceImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public List<ProductVariant> findAll() {
        return productVariantRepository.findAll();
    }

    @Override
    public Optional<ProductVariant> findById(Long id) {
        return productVariantRepository.findById(id);
    }

    @Override
    public ProductVariant save(ProductVariant productVariant) {
        return productVariantRepository.save(productVariant);
    }

    @Override
    public ProductVariant update(Long id, ProductVariant productVariant) {
        productVariant.setId(id);
        return productVariantRepository.save(productVariant);
    }

    @Override
    public void deleteById(Long id) {
        productVariantRepository.deleteById(id);
    }

    @Override
    public List<ProductVariantResponse> findAllDto() {
        List<ProductVariant> list = productVariantRepository.findAll();
        List<ProductVariantResponse> out = new ArrayList<>();
        for (ProductVariant pv : list) out.add(ProductVariantMapper.toResponse(pv, pv.getProduct()));
        return out;
    }

    @Override
    public java.util.Optional<ProductVariantResponse> findByIdDto(Long id) {
        return productVariantRepository.findById(id).map(pv -> ProductVariantMapper.toResponse(pv, pv.getProduct()));
    }

    @Override
    public ProductVariantResponse saveDto(ProductVariantRequest req) {
        ProductVariant pv = ProductVariantMapper.toEntity(req);
        ProductVariant saved = productVariantRepository.save(pv);
        return ProductVariantMapper.toResponse(saved, saved.getProduct());
    }

    @Override
    public ProductVariantResponse updateDto(Long id, ProductVariantRequest req) {
        ProductVariant pv = ProductVariantMapper.toEntity(req);
        pv.setId(id);
        ProductVariant saved = productVariantRepository.save(pv);
        return ProductVariantMapper.toResponse(saved, saved.getProduct());
    }

}
