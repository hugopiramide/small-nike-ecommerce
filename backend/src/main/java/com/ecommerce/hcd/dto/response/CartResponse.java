package com.ecommerce.hcd.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class CartResponse {

    private Long id;
    private UserResponse user;
    private List<CartItemsResponse> cartItems;
    private LocalDateTime updateAt;

    public CartResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
    
    public List<CartItemsResponse> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemsResponse> cartItems) {
        this.cartItems = cartItems;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}
