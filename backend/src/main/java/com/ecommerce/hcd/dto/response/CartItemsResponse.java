package com.ecommerce.hcd.dto.response;

public class CartItemsResponse {

    private Long id;
    private ProductVariantResponse productVariantId;
    private int quantity;

    public CartItemsResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductVariantResponse getProductVariantId() {
        return productVariantId;
    }   

    public void setProductVariantId(ProductVariantResponse productVariantId) {
        this.productVariantId = productVariantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
