package com.ecommerce.hcd.mapper;

import com.ecommerce.hcd.dto.request.CategoryRequest;
import com.ecommerce.hcd.dto.response.CategoryResponse;
import com.ecommerce.hcd.model.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequest req) {
        if (req == null) return null;
        Category c = new Category();
        c.setName(req.getName());
        c.setDescription(req.getDescription());
        return c;
    }

    public static CategoryResponse toResponse(Category c) {
        if (c == null) return null;
        CategoryResponse r = new CategoryResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setDescription(c.getDescription());
        return r;
    }

}
