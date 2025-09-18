package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.ProductRequestDto;
import inventory.management.inventory.management.dto.ProductResponseDto;
import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto requestDto);
    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto);
    void deleteProduct(Long id);
}