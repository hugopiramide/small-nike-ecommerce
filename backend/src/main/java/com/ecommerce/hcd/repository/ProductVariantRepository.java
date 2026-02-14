package com.ecommerce.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.hcd.model.ProductVariant;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

}
