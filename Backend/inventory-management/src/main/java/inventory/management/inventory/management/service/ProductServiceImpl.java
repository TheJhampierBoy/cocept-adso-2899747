package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.ProductRequestDto;
import inventory.management.inventory.management.dto.ProductResponseDto;
import inventory.management.inventory.management.entity.Product;
import inventory.management.inventory.management.entity.Category;
import inventory.management.inventory.management.entity.Supplier;
import inventory.management.inventory.management.repository.ProductRepository;
import inventory.management.inventory.management.repository.CategoryRepository;
import inventory.management.inventory.management.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setProductName(requestDto.getProductName());
        product.setDescription(requestDto.getDescription());
        product.setPurchasePrice(requestDto.getPurchasePrice());
        product.setSalePrice(requestDto.getSalePrice());
        product.setCurrentStock(requestDto.getCurrentStock());
        product.setMinStock(requestDto.getMinStock());
        product.setLocation(requestDto.getLocation());
        product.setIsActive(requestDto.getIsActive());
        if (requestDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(requestDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        if (requestDto.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(requestDto.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
            product.setSupplier(supplier);
        }
        Product saved = productRepository.save(product);
        return mapToResponseDto(saved);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(requestDto.getProductName());
        product.setDescription(requestDto.getDescription());
        product.setPurchasePrice(requestDto.getPurchasePrice());
        product.setSalePrice(requestDto.getSalePrice());
        product.setCurrentStock(requestDto.getCurrentStock());
        product.setMinStock(requestDto.getMinStock());
        product.setLocation(requestDto.getLocation());
        product.setIsActive(requestDto.getIsActive());
        if (requestDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(requestDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        if (requestDto.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(requestDto.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
            product.setSupplier(supplier);
        }
        Product updated = productRepository.save(product);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductResponseDto mapToResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setPurchasePrice(product.getPurchasePrice());
        dto.setSalePrice(product.getSalePrice());
        dto.setCurrentStock(product.getCurrentStock());
        dto.setMinStock(product.getMinStock());
        dto.setLocation(product.getLocation());
        dto.setIsActive(product.getIsActive());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setCategoryId(product.getCategory() != null ? product.getCategory().getCategoryId() : null);
        dto.setSupplierId(product.getSupplier() != null ? product.getSupplier().getSupplierId() : null);
        return dto;
    }
}