package com.ecommerce.hcd.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.hcd.dto.request.ProductVariantRequest;
import com.ecommerce.hcd.dto.response.ProductVariantResponse;
import com.ecommerce.hcd.model.ProductVariant;
import com.ecommerce.hcd.model.Product;

public class ProductVariantMapper {

    public static ProductVariant toEntity(ProductVariantRequest req) {
        if (req == null) return null;
        ProductVariant pv = new ProductVariant();
        pv.setSize(req.getSize());
        pv.setStock(req.getStock());
        pv.setPriceModifier(req.getPriceModifier());
        if (req.getProductId() != null) {
            Product p = new Product();
            p.setId(req.getProductId());
            pv.setProduct(p);
        }
        return pv;
    }

    public static ProductVariantResponse toResponse(ProductVariant pv, Product product) {
        if (pv == null) return null;
        ProductVariantResponse r = new ProductVariantResponse();
        r.setId(pv.getId());
        if (pv.getProduct() != null) r.setProduct(ProductMapper.toShortResponse(product));
        r.setSize(pv.getSize());
        r.setStock(pv.getStock());
        r.setPriceModifier(pv.getPriceModifier());
        return r;
    }

    public static ProductVariantResponse toResponse(ProductVariant pv) {
        if (pv == null) return null;
        ProductVariantResponse r = new ProductVariantResponse();
        r.setId(pv.getId());
        r.setSize(pv.getSize());
        r.setStock(pv.getStock());
        r.setPriceModifier(pv.getPriceModifier());
        return r;
    }

    public static List<ProductVariant> toEntityList(List<ProductVariantRequest> list) {
        if (list == null) return null;
        List<ProductVariant> out = new ArrayList<>();
        for (ProductVariantRequest r : list) out.add(toEntity(r));
        return out;
    }

}
