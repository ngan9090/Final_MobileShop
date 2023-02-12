package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.payload.CartPayload;
import com.tutorial.spring.security.formlogin.payload.Paged;
import com.tutorial.spring.security.formlogin.payload.Paging;
import com.tutorial.spring.security.formlogin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

   @Autowired
    ProductRepository repository;

    @Override
    public List<Product> listProduct() {
        return repository.findAll();
    }

    @Override
    public List<Product> productDetail(Integer productCode) {
        return repository.findByProductCodeLike(productCode);
    }

    public List<Product> getAllProductList(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());

        Page<Product> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }



    public Paged<Product> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.sort(Product.class));
        Page<Product> postPage = repository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }

}
