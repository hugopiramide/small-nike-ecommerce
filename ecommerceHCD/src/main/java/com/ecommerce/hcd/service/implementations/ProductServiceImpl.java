package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.Product;
import com.ecommerce.hcd.repository.ProductRepository;
import com.ecommerce.hcd.service.interfaces.ProductService;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.hcd.dto.request.ProductRequest;
import com.ecommerce.hcd.dto.response.ProductResponse;
import com.ecommerce.hcd.mapper.ProductMapper;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<ProductResponse> findAllDto() {
        List<ProductResponse> out = new ArrayList<>();
        productRepository.findAll().stream()
                .map(product -> {
                    ProductResponse pr = ProductMapper.toResponse(product);
                    out.add(pr);
                    return product;
                }).toList();

        return out;
    }

    @Override
    public java.util.Optional<ProductResponse> findByIdDto(Long id) {
        return productRepository.findById(id).map(p -> ProductMapper.toResponse(p));
    }

    @Override
    public ProductResponse saveDto(ProductRequest req) {
        Product p = ProductMapper.toEntity(req, null);
        Product saved = productRepository.save(p);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public ProductResponse updateDto(Long id, ProductRequest req) {
        Product p = ProductMapper.toEntity(req, null);
        p.setId(id);
        Product saved = productRepository.save(p);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public List<ProductResponse> findFirst10() {
        List<ProductResponse> out = new ArrayList<>();
        productRepository.findFirst10By().stream()
                .map(product -> {
                    ProductResponse pr = ProductMapper.toResponse(product);
                    out.add(pr);
                    return product;
                }).toList();

        return out;
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductMapper::toResponse);
    }

    @Override
    public List<ProductResponse> searchByName(String name) {
        List<ProductResponse> out = new ArrayList<>();
        productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(product -> {
                    ProductResponse pr = ProductMapper.toResponse(product);
                    out.add(pr);
                    return product;
                }).toList();
        return out;
    }

}
