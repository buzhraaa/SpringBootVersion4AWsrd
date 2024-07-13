package com.example.amazonmarketplace.services;

import com.example.amazonmarketplace.dto.ProductDto;

/**
 * Service interface for managing products.
 */

public interface ProductService {
    /**
     * Saves a product.
     *
     * @param product the product data transfer object to save
     * @return the saved product data transfer object
     */
    ProductDto saveProduct(ProductDto product);
}