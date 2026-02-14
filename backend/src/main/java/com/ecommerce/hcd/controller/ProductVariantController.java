package com.ecommerce.hcd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.hcd.dto.request.ProductVariantRequest;
import com.ecommerce.hcd.dto.response.ProductVariantResponse;
import com.ecommerce.hcd.service.interfaces.ProductVariantService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    @GetMapping
    public ResponseEntity<List<ProductVariantResponse>> findAll() {
        return ResponseEntity.ok(productVariantService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariantResponse> findById(@PathVariable Long id) {
        Optional<ProductVariantResponse> opt = productVariantService.findByIdDto(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductVariantResponse> create(@RequestBody ProductVariantRequest req) {
        ProductVariantResponse created = productVariantService.saveDto(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductVariantResponse> update(@PathVariable Long id, @RequestBody ProductVariantRequest req) {
        ProductVariantResponse updated = productVariantService.updateDto(id, req);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productVariantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
