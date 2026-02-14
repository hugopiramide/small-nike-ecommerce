package com.ecommerce.hcd.dto.response;

import java.util.List;

public class ProductResponse {

    private Long id;
    private CategoryResponse category;
    private String name;
    private String description;
    private double basePrice;
    private String imageUrl;
    private boolean active;
    private List<ProductVariantResponse> variants;

    public ProductResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryResponse getCategory() {
        return category;
    }
    
    public void setCategory(CategoryResponse category) {
        this.category = category;
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

    public List<ProductVariantResponse> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariantResponse> variants) {
        this.variants = variants;
    }

}
