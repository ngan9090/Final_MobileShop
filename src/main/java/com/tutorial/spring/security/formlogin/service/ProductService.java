package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.payload.Paged;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    List<Product> productDetail(Integer productCode);


    List<Product> getAllProductList(Integer pageNo, Integer pageSize, String sortBy);

    Paged<Product> getPage(int pageNumber, int size);

    //Page<Product> findPaginated(Pageable pageable);
}
