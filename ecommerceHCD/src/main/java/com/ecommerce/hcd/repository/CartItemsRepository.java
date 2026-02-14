package com.ecommerce.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.hcd.model.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

    @Query("SELECT COALESCE(SUM(ci.quantity), 0) FROM CartItems ci WHERE ci.cart.user.id = :userId")
    Integer countItemsByUserId(@Param("userId") Long userId);
}
