package com.example.amazonmarketplace.controllers;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling product-related HTTP requests.
 */

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    /**
     * Service layer for performing operations on products.
     */
    private final ProductService productService;

    /**
     * Endpoint to create a new product.
     *
     * @param productDto the product data transfer object to be created
     * @return ResponseEntity with status 200 (OK) and the saved product data transfer object,
     *         or ResponseEntity with status 404 (Not Found) if product saving failed
     */
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProductDto = productService.saveProduct(productDto);
        if (savedProductDto != null) {
            return ResponseEntity.ok().body(savedProductDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}