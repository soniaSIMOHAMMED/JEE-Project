package com.springboot.application.use_cases.product.service;

import com.springboot.application.use_cases.product.domain.Fragrance;
import com.springboot.application.use_cases.product.domain.Product;
import com.springboot.application.use_cases.product.exposition.ProductDto;
import com.springboot.application.use_cases.product.infrastructure.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService{

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public DefaultProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product newProduct = this.productRepository.save(product);
        return mapToDto(newProduct);
    }

    @Override
    public ProductDto updateProduct(long productId, ProductDto productDto) {
        Product product = this.productRepository.getById(productId);

        product.setProductName(productDto.getProductName());
        product.setFragrance(Fragrance.valueOf(productDto.getFragrance()));

        Product updatedProduct = this.productRepository.save(product);

        return mapToDto(updatedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(long productId) {
        Product product = this.productRepository.getById(productId);
        return mapToDto(product);
    }

    @Override
    public List<ProductDto> getAllProductsByFragrance(String fragrance) {
        List<Product> products = this.productRepository.findAllByFragrance(Fragrance.valueOf(fragrance));
        return products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(long productId) {
        Product product = this.productRepository.getById(productId);
        this.productRepository.delete(product);
    }

    private ProductDto mapToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product mapToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }


}
