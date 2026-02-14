package com.ecommerce.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.hcd.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	java.util.Optional<Cart> findByUserId(Long userId);

}
