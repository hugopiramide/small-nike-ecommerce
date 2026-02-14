package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.CartItems;
import com.ecommerce.hcd.dto.request.CartItemsRequest;
import com.ecommerce.hcd.dto.response.CartItemsResponse;

public interface CartItemsService {

    List<CartItems> findAll();

    Optional<CartItems> findById(Long id);

    CartItems save(CartItems cartItem);

    CartItems update(Long id, CartItems cartItem);
    
    void deleteById(Long id);

    List<CartItemsResponse> findAllDto();

    Optional<CartItemsResponse> findByIdDto(Long id);

    CartItemsResponse saveDto(CartItemsRequest req);

    CartItemsResponse updateDto(Long id, CartItemsRequest req);
}
