package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.Category;
import com.ecommerce.hcd.repository.CategoryRepository;
import com.ecommerce.hcd.service.interfaces.CategoryService;
import com.ecommerce.hcd.dto.request.CategoryRequest;
import com.ecommerce.hcd.dto.response.CategoryResponse;
import com.ecommerce.hcd.mapper.CategoryMapper;
import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> findAllDto() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryResponse> out = new ArrayList<>();
        for (Category c : list) out.add(CategoryMapper.toResponse(c));
        return out;
    }

    @Override
    public java.util.Optional<CategoryResponse> findByIdDto(Long id) {
        return categoryRepository.findById(id).map(CategoryMapper::toResponse);
    }

    @Override
    public CategoryResponse saveDto(CategoryRequest req) {
        Category c = CategoryMapper.toEntity(req);
        Category saved = categoryRepository.save(c);
        return CategoryMapper.toResponse(saved);
    }

    @Override
    public CategoryResponse updateDto(Long id, CategoryRequest req) {
        Category c = CategoryMapper.toEntity(req);
        c.setId(id);
        Category saved = categoryRepository.save(c);
        return CategoryMapper.toResponse(saved);
    }

}
