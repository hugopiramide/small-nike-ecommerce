package com.ecommerce.hcd.dto.request;

import java.util.List;

public class ProductRequest {

    private Long categoryId;
    private String name;
    private String description;
    private double basePrice;
    private String imageUrl;
    private boolean active;
    private List<ProductVariantRequest> variants;

    public ProductRequest() {}

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public java.util.List<ProductVariantRequest> getVariants() {
        return variants;
    }

    public void setVariants(java.util.List<ProductVariantRequest> variants) {
        this.variants = variants;
    }

}
