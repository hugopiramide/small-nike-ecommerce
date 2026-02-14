package com.ecommerce.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.hcd.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findFirst10By();

    List<Product> findByNameContainingIgnoreCase(String name);
}
