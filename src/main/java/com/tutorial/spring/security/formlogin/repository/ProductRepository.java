package com.tutorial.spring.security.formlogin.repository;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, PagingAndSortingRepository<Product,Integer>
{
    List<Product> findByProductCodeLike(Integer productCode);

    Optional<Product> findByProductCode(Integer productCode);

}
