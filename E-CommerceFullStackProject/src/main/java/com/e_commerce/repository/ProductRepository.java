package com.e_commerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_commerce.entity.Product;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Long> {
    
	// path = http://localhost:2000/products/search/findByCategoryId?id=1
	Page<Product> findByCategoryId(@RequestParam("id") Long id,Pageable pageable);
	
   //  path = http://localhost:2000/products/search/findByNameContaining?name=Data
	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
	
	
	//   pagination path: "http://localhost:2000/products?page=0&size=10"

	
}
