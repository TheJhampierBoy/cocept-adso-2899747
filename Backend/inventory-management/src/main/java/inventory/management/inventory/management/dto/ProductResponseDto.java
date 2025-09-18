package inventory.management.inventory.management.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Integer currentStock;
    private Integer minStock;
    private String location;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private Long categoryId;
    private Long supplierId;
}