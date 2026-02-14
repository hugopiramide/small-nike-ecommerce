package com.ecommerce.hcd.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.hcd.dto.request.CartRequest;
import com.ecommerce.hcd.dto.response.CartResponse;
import com.ecommerce.hcd.model.Cart;
import com.ecommerce.hcd.model.CartItems;
import com.ecommerce.hcd.model.User;

public class CartMapper {

    public static Cart toEntity(CartRequest req) {
        if (req == null) return null;
        Cart c = new Cart();
        if (req.getUserId() != null) {
            User u = new User();
            u.setId(req.getUserId());
            c.setUser(u);
        }
        if (req.getCartItems() != null) {
            List<CartItems> items = CartItemsMapper.toEntityList(req.getCartItems());
            for (CartItems ci : items) ci.setCart(c);
            c.setCartItems(items);
        }
        return c;
    }

    public static CartResponse toResponse(Cart c) {
        if (c == null) return null;
        CartResponse r = new CartResponse();
        r.setId(c.getId());
        if (c.getUser() != null) r.setUser(UserMapper.toResponse(c.getUser()));
        if (c.getCartItems() != null) r.setCartItems(CartItemsMapper.toResponseList(c.getCartItems()));
        r.setUpdateAt(c.getUpdate_at());
        return r;
    }

    public static List<Cart> toEntityList(List<CartRequest> list) {
        if (list == null) return null;
        List<Cart> out = new ArrayList<>();
        for (CartRequest r : list) out.add(toEntity(r));
        return out;
    }

    public static List<CartResponse> toResponseList(List<Cart> list) {
        if (list == null) return null;
        List<CartResponse> out = new ArrayList<>();
        for (Cart c : list) out.add(toResponse(c));
        return out;
    }

}
