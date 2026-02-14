package com.ecommerce.hcd.dto.response;

public class ProductVariantResponse {

    private Long id;
    private ProductShortResponse product;
    private String size;
    private Long stock;
    private double priceModifier;

    public ProductVariantResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductShortResponse getProduct() {
        return product;
    }

    public void setProduct(ProductShortResponse product) {
        this.product = product;
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
