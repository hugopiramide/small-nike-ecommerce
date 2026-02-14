package com.ecommerce.hcd.dto.request;

public class CartItemsRequest {

    private Long productVariantId;
    private int quantity;

    public CartItemsRequest() {}

    public Long getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Long productVariantId) {
        this.productVariantId = productVariantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
