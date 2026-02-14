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

import com.ecommerce.hcd.dto.request.CartRequest;
import com.ecommerce.hcd.dto.request.CartItemsRequest;
import com.ecommerce.hcd.dto.response.CartResponse;
import com.ecommerce.hcd.service.interfaces.CartService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartResponse>> findAll() {
        return ResponseEntity.ok(cartService.findAllDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> findById(@PathVariable Long id) {
        Optional<CartResponse> opt = cartService.findByIdDto(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CartResponse> create(@RequestBody CartRequest req) {
        CartResponse created = cartService.saveDto(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/user/{userId}/add")
    public ResponseEntity<CartResponse> addItem(@PathVariable Long userId, @RequestBody CartItemsRequest req) {
        CartResponse updated = cartService.addItemByUser(userId, req);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }

    @DeleteMapping("/user/{userId}/item/{cartItemId}")
    public ResponseEntity<CartResponse> removeItem(@PathVariable Long userId, @PathVariable Long cartItemId) {
        CartResponse updated = cartService.removeItemByUser(userId, cartItemId);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartResponse> update(@PathVariable Long id, @RequestBody CartRequest req) {
        CartResponse updated = cartService.updateDto(id, req);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Integer> countItems(@PathVariable Long userId) {
        Integer count = cartService.countItemsByUserId(userId);
        return ResponseEntity.ok(count);
    }
}
