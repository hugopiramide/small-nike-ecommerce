package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.Product;
import com.ecommerce.hcd.dto.request.ProductRequest;
import com.ecommerce.hcd.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Product update(Long id, Product product);

    void deleteById(Long id);

    List<ProductResponse> findAllDto();

    Optional<ProductResponse> findByIdDto(Long id);

    ProductResponse saveDto(ProductRequest req);

    ProductResponse updateDto(Long id, ProductRequest req);

    List<ProductResponse> findFirst10();

    Page<ProductResponse> findAll(Pageable pageable);

    List<ProductResponse> searchByName(String name);
}
