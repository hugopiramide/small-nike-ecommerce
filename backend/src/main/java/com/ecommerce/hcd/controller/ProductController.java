package com.ecommerce.hcd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.ecommerce.hcd.assembler.ProductModelAssembler;
import com.ecommerce.hcd.dto.request.ProductRequest;
import com.ecommerce.hcd.dto.response.ProductResponse;
import com.ecommerce.hcd.model.Product;
import com.ecommerce.hcd.repository.ProductRepository;
import com.ecommerce.hcd.service.interfaces.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    private final ProductService productService;

    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @Autowired
    private ProductModelAssembler productModelAssembler;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping
    // public ResponseEntity<List<Product>> findAll() {
    //     return ResponseEntity.ok(productService.findAll());
    // }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Optional<ProductResponse> opt = productService.findByIdDto(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @PageableDefault(page = 0, size = 10) If some pagination parameters are not provided, it will default to page 0 and size 10.

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedModel<ProductResponse>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        PagedModel<ProductResponse> pagedModel = pagedResourcesAssembler.toModel(page, product -> productModelAssembler.toModel(product));
        return ResponseEntity.ok(pagedModel);
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
