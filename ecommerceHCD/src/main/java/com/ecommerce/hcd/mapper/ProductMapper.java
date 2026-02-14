package com.ecommerce.hcd.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.hcd.dto.request.ProductRequest;
import com.ecommerce.hcd.dto.response.ProductResponse;
import com.ecommerce.hcd.dto.response.ProductShortResponse;
import com.ecommerce.hcd.model.Category;
import com.ecommerce.hcd.model.Product;
import com.ecommerce.hcd.model.ProductVariant;

public class ProductMapper {

    public static Product toEntity(ProductRequest req, Category category) {
        if (req == null) return null;
        Product p = new Product();
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setBasePrice(req.getBasePrice());
        p.setImageUrl(req.getImageUrl());
        p.setActive(req.isActive());
        if (category != null) {
            p.setCategory(category);
        }
        if (req.getVariants() != null) {
            List<ProductVariant> variants = ProductVariantMapper.toEntityList(req.getVariants());
            for (ProductVariant v : variants) v.setProduct(p);
            p.setVariants(variants);
        }
        return p;
    }
  
    public static ProductResponse toResponse(Product p) {
        if (p == null) return null;
        ProductResponse r = new ProductResponse();
        r.setId(p.getId());
        if (p.getCategory() != null) r.setCategory(CategoryMapper.toResponse(p.getCategory()));
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setBasePrice(p.getBasePrice());
        r.setImageUrl(p.getImageUrl());
        r.setActive(p.isActive());
        List<ProductVariant> variants = p.getVariants();
        if (variants != null && !variants.isEmpty()) r.setVariants(variants.stream().map(v -> ProductVariantMapper.toResponse(v)).toList());
        return r;
    }

    public static ProductShortResponse toShortResponse(Product p) {
        if (p == null) return null;
        ProductShortResponse r = new ProductShortResponse();
        r.setName(p.getName());
        r.setPrice(p.getBasePrice());
        r.setImageUrl(p.getImageUrl());
        r.setDescription(p.getDescription());
        if (p.getCategory() != null) {
            r.setCategory(CategoryMapper.toResponse(p.getCategory()));
        }
        return r;
    }

    public static List<Product> toEntityList(List<ProductRequest> list) {
        if (list == null) return null;
        List<Product> out = new ArrayList<>();
        for (ProductRequest r : list) out.add(toEntity(r, null));
        return out;
    }

    public static List<ProductResponse> toResponseList(List<Product> list) {
        if (list == null) return null;
        List<ProductResponse> out = new ArrayList<>();
        for (Product p : list) out.add(toResponse(p));
        return out;
    }

}
