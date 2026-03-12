package com.ecommerce.hcd.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.ecommerce.hcd.controller.ProductController;
import com.ecommerce.hcd.dto.response.CategoryResponse;
import com.ecommerce.hcd.dto.response.ProductResponse;
import com.ecommerce.hcd.model.Product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductResponse> {

    public ProductModelAssembler() {
        super(ProductController.class, ProductResponse.class);
    }

    @Override
    public ProductResponse toModel(Product entity) {
        ProductResponse res = instantiateModel(entity);

        res.setId(entity.getId());
        res.setName(entity.getName());
        res.setDescription(entity.getDescription());
        res.setBasePrice(entity.getBasePrice());
        res.setImageUrl(entity.getImageUrl());
        res.setActive(entity.isActive());

        if (entity.getCategory() != null) {
            CategoryResponse catRes = new CategoryResponse();
            catRes.setId(entity.getCategory().getId());
            catRes.setName(entity.getCategory().getName());
            res.setCategory(catRes);
        }

        res.add(linkTo(methodOn(ProductController.class).findById(entity.getId())).withSelfRel());

        return res;
    }
}