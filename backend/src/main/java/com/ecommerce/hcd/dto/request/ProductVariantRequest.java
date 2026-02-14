package com.ecommerce.hcd.dto.request;

public class ProductVariantRequest {

    private Long productId;
    private String size;
    private Long stock;
    private double priceModifier;

    public ProductVariantRequest() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public double getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(double priceModifier) {
        this.priceModifier = priceModifier;
    }

}
