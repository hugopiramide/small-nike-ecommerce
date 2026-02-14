package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.CartItems;
import com.ecommerce.hcd.repository.CartItemsRepository;
import com.ecommerce.hcd.service.interfaces.CartItemsService;
import com.ecommerce.hcd.dto.request.CartItemsRequest;
import com.ecommerce.hcd.dto.response.CartItemsResponse;
import com.ecommerce.hcd.mapper.CartItemsMapper;
import java.util.ArrayList;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    private final CartItemsRepository cartItemsRepository;

    public CartItemsServiceImpl(CartItemsRepository cartItemsRepository) {
        this.cartItemsRepository = cartItemsRepository;
    }

    @Override
    public List<CartItems> findAll() {
        return cartItemsRepository.findAll();
    }

    @Override
    public Optional<CartItems> findById(Long id) {
        return cartItemsRepository.findById(id);
    }

    @Override
    public CartItems save(CartItems cartItem) {
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public CartItems update(Long id, CartItems cartItem) {
        cartItem.setId(id);
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public void deleteById(Long id) {
        cartItemsRepository.deleteById(id);
    }

    @Override
    public List<CartItemsResponse> findAllDto() {
        List<CartItems> list = cartItemsRepository.findAll();
        List<CartItemsResponse> out = new ArrayList<>();
        for (CartItems ci : list) out.add(CartItemsMapper.toResponse(ci));
        return out;
    }

    @Override
    public java.util.Optional<CartItemsResponse> findByIdDto(Long id) {
        return cartItemsRepository.findById(id).map(CartItemsMapper::toResponse);
    }

    @Override
    public CartItemsResponse saveDto(CartItemsRequest req) {
        CartItems ci = CartItemsMapper.toEntity(req);
        CartItems saved = cartItemsRepository.save(ci);
        return CartItemsMapper.toResponse(saved);
    }

    @Override
    public CartItemsResponse updateDto(Long id, CartItemsRequest req) {
        CartItems ci = CartItemsMapper.toEntity(req);
        ci.setId(id);
        CartItems saved = cartItemsRepository.save(ci);
        return CartItemsMapper.toResponse(saved);
    }

}
