package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.Category;
import com.ecommerce.hcd.dto.request.CategoryRequest;
import com.ecommerce.hcd.dto.response.CategoryResponse;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    Category update(Long id, Category category);
    
    void deleteById(Long id);

    List<CategoryResponse> findAllDto();

    Optional<CategoryResponse> findByIdDto(Long id);

    CategoryResponse saveDto(CategoryRequest req);

    CategoryResponse updateDto(Long id, CategoryRequest req);
}
