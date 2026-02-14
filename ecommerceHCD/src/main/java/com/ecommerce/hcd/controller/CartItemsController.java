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

import com.ecommerce.hcd.dto.request.CartItemsRequest;
import com.ecommerce.hcd.dto.response.CartItemsResponse;
import com.ecommerce.hcd.service.interfaces.CartItemsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/cart-items")
public class CartItemsController {

    private final CartItemsService cartItemsService;

    public CartItemsController(CartItemsService cartItemsService) {
        this.cartItemsService = cartItemsService;
    }

    @GetMapping
    public ResponseEntity<List<CartItemsResponse>> findAll() {
        return ResponseEntity.ok(cartItemsService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemsResponse> findById(@PathVariable Long id) {
        Optional<CartItemsResponse> opt = cartItemsService.findByIdDto(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CartItemsResponse> create(@RequestBody CartItemsRequest req) {
        CartItemsResponse created = cartItemsService.saveDto(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemsResponse> update(@PathVariable Long id, @RequestBody CartItemsRequest req) {
        CartItemsResponse updated = cartItemsService.updateDto(id, req);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartItemsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
