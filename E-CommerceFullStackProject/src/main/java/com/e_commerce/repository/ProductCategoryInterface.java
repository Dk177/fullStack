package com.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.e_commerce.entity.ProductCategory;

@RepositoryRestResource(collectionResourceRel ="productCategory",path = "product-category")
@CrossOrigin("http://localhost:4200")
public interface ProductCategoryInterface extends JpaRepository<ProductCategory,Long> {

}
