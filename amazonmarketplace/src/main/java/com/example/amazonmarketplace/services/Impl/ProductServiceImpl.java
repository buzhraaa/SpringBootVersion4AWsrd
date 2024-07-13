package com.example.amazonmarketplace.services.Impl;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.mapper.ProductMapper;
import com.example.amazonmarketplace.models.Product;
import com.example.amazonmarketplace.repositories.ProductRepository;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link ProductService} interface for managing products.
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    /**
     * Repository for performing CRUD operations on Product entities.
     */
    private final ProductRepository productRepository;

    /**
     * Mapper for converting between Product entities and ProductDto objects.
     */
    private final ProductMapper productMapper;

    /**
     * Saves a product.
     *
     * @param productDto the product data transfer object to save
     * @return the saved product data transfer object
     */
    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product saveProduct = productRepository.save(product);
        return productMapper.toDTO(saveProduct);
    }
}
