package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.Cart;
import com.ecommerce.hcd.repository.CartRepository;
import com.ecommerce.hcd.service.interfaces.CartService;
import com.ecommerce.hcd.dto.request.CartRequest;
import com.ecommerce.hcd.dto.response.CartResponse;
import com.ecommerce.hcd.mapper.CartMapper;
import com.ecommerce.hcd.model.CartItems;
import com.ecommerce.hcd.model.ProductVariant;
import com.ecommerce.hcd.model.User;
import com.ecommerce.hcd.repository.CartItemsRepository;
import com.ecommerce.hcd.repository.ProductVariantRepository;
import com.ecommerce.hcd.repository.UserRepository;
import com.ecommerce.hcd.dto.request.CartItemsRequest;
import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemsRepository;
    private final ProductVariantRepository productVariantRepository;
    private final UserRepository userRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemsRepository cartItemsRepository,
            ProductVariantRepository productVariantRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartItemsRepository = cartItemsRepository;
        this.productVariantRepository = productVariantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Long id, Cart cart) {
        cart.setId(id);
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<CartResponse> findAllDto() {
        List<Cart> list = cartRepository.findAll();
        List<CartResponse> out = new ArrayList<>();
        for (Cart c : list)
            out.add(CartMapper.toResponse(c));
        return out;
    }

    @Override
    public java.util.Optional<CartResponse> findByIdDto(Long id) {
        return cartRepository.findById(id).map(CartMapper::toResponse);
    }

    @Override
    public CartResponse saveDto(CartRequest req) {
        Cart c = CartMapper.toEntity(req);
        Cart saved = cartRepository.save(c);
        return CartMapper.toResponse(saved);
    }

    @Override
    public CartResponse updateDto(Long id, CartRequest req) {
        Cart c = CartMapper.toEntity(req);
        c.setId(id);
        Cart saved = cartRepository.save(c);
        return CartMapper.toResponse(saved);
    }

    @Override
    public CartResponse addItemByUser(Long userId, CartItemsRequest req) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart c = new Cart();
            c.setUser(user);
            c.setCartItems(new java.util.ArrayList<>());
            return cartRepository.save(c);
        });

        ProductVariant pv = null;
        if (req.getProductVariantId() != null) {
            pv = productVariantRepository.findById(req.getProductVariantId())
                    .orElseThrow(() -> new IllegalArgumentException("ProductVariant not found"));
        }

        CartItems ci = new CartItems();
        ci.setCart(cart);
        ci.setProductVariant(pv);
        ci.setQuantity(req.getQuantity());

        CartItems savedItem = cartItemsRepository.save(ci);

        if (cart.getCartItems() == null) {
            java.util.List<CartItems> list = new java.util.ArrayList<>();
            list.add(savedItem);
            cart.setCartItems(list);
        } else {
            cart.getCartItems().add(savedItem);
        }

        cart.setUpdate_at(java.time.LocalDateTime.now());
        Cart savedCart = cartRepository.save(cart);
        return CartMapper.toResponse(savedCart);
    }

    @Override
    public CartResponse removeItemByUser(Long userId, Long cartItemId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user"));

        CartItems itemToRemove = cartItemsRepository.findById(cartItemId)
                .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));

        if (!itemToRemove.getCart().getId().equals(cart.getId())) {
            throw new IllegalArgumentException("CartItem does not belong to this cart");
        }

        cartItemsRepository.deleteById(cartItemId);

        if (cart.getCartItems() != null) {
            cart.getCartItems().removeIf(item -> item.getId().equals(cartItemId));
        }

        cart.setUpdate_at(java.time.LocalDateTime.now());
        Cart updatedCart = cartRepository.save(cart);
        return CartMapper.toResponse(updatedCart);
    }

    @Override
    public Integer countItemsByUserId(Long userId) {
        return cartItemsRepository.countItemsByUserId(userId);
    }

}
