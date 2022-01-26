package com.example.springecommerce.repository;

import com.example.springecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
//@RepositoryRestResource(path = "products", itemResourceRel = "product", collectionResourceRel = "products") // Spring Data Rest makes it available at: http://localhost:8080/api/products?page=0&size=1
//@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductCategoryId(@RequestParam("id") Long id, Pageable pageable);
    // Spring Data Rest makes it available at: http://localhost:8080/api/products/search/findAllByProductCategoryId?id=4&size=1&page=0

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    // Spring Data Rest makes it available at: http://localhost:8080/api/products/search/findByNameContaining?name=python
}
