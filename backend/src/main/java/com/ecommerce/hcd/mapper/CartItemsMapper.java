package com.ecommerce.hcd.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.hcd.dto.request.CartItemsRequest;
import com.ecommerce.hcd.dto.response.CartItemsResponse;
import com.ecommerce.hcd.model.CartItems;
import com.ecommerce.hcd.model.ProductVariant;

public class CartItemsMapper {

    public static CartItems toEntity(CartItemsRequest req) {
        if (req == null) return null;
        CartItems ci = new CartItems();
        ci.setQuantity(req.getQuantity());
        if (req.getProductVariantId() != null) {
            ProductVariant pv = new ProductVariant();
            pv.setId(req.getProductVariantId());
            ci.setProductVariant(pv);
        }
        return ci;
    }

    public static CartItemsResponse toResponse(CartItems ci) {
        if (ci == null) return null;
        CartItemsResponse r = new CartItemsResponse();
        r.setId(ci.getId());
        r.setQuantity(ci.getQuantity());
        if (ci.getProductVariant() != null) r.setProductVariantId(ProductVariantMapper.toResponse(ci.getProductVariant(), ci.getProductVariant().getProduct()));
        return r;
    }

    public static List<CartItems> toEntityList(List<CartItemsRequest> list) {
        if (list == null) return null;
        List<CartItems> out = new ArrayList<>();
        for (CartItemsRequest r : list) out.add(toEntity(r));
        return out;
    }

    public static List<CartItemsResponse> toResponseList(List<CartItems> list) {
        if (list == null) return null;
        List<CartItemsResponse> out = new ArrayList<>();
        for (CartItems ci : list) out.add(toResponse(ci));
        return out;
    }

}
