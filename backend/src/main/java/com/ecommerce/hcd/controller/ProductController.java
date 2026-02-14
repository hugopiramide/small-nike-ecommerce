package com.ecommerce.hcd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

import com.ecommerce.hcd.dto.request.ProductRequest;
import com.ecommerce.hcd.dto.response.ProductResponse;
import com.ecommerce.hcd.service.interfaces.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Optional<ProductResponse> opt = productService.findByIdDto(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find-first-10")
    public ResponseEntity<List<ProductResponse>> findFirst10() {
        return ResponseEntity.ok(productService.findFirst10());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProductsByName(
            @org.springframework.web.bind.annotation.RequestParam String name) {
        return ResponseEntity.ok(productService.searchByName(name));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest req) {
        ProductResponse created = productService.saveDto(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest req) {
        ProductResponse updated = productService.updateDto(id, req);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
