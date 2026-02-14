package com.ecommerce.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.hcd.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
