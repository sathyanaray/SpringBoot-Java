package com.sathya.product_service.service;

import com.sathya.product_service.dto.ProductRequest;
import com.sathya.product_service.dto.ProductResponse;
import com.sathya.product_service.model.Product;
import com.sathya.product_service.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {
    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest){
       Product product = Product.builder()
               .name(productRequest.getName())
               .description(productRequest.getDescription())
               .price(productRequest.getPrice())
               .build();
       productRepo.save(product);
       log.info("Product {} is saved",product.getId());
   }

    public List<ProductResponse> getAllProducts() {
        List<Product>products =  productRepo.findAll();
        return products.stream().map(this::mapToPorductResponeses).toList();

    }

    private ProductResponse mapToPorductResponeses(Product product) {
       return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
               .description(product.getDescription())
               .price(product.getPrice())
                .build();
    }
}
