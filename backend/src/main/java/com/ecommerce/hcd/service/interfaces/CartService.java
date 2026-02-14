package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.Cart;
import com.ecommerce.hcd.dto.request.CartRequest;
import com.ecommerce.hcd.dto.response.CartResponse;

public interface CartService {

    List<Cart> findAll();

    Optional<Cart> findById(Long id);

    Cart save(Cart cart);

    Cart update(Long id, Cart cart);

    void deleteById(Long id);

    List<CartResponse> findAllDto();

    Optional<CartResponse> findByIdDto(Long id);

    CartResponse saveDto(CartRequest req);

    CartResponse updateDto(Long id, CartRequest req);

    CartResponse addItemByUser(Long userId, com.ecommerce.hcd.dto.request.CartItemsRequest req);

    CartResponse removeItemByUser(Long userId, Long cartItemId);

    Integer countItemsByUserId(Long userId);
}
