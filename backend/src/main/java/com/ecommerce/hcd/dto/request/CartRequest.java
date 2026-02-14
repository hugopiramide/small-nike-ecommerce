package com.ecommerce.hcd.dto.request;

import java.util.List;

public class CartRequest {

    private Long userId;
    private List<CartItemsRequest> cartItems;

    public CartRequest() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemsRequest> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemsRequest> cartItems) {
        this.cartItems = cartItems;
    }

}
