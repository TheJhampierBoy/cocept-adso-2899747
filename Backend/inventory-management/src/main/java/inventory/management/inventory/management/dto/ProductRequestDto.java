package inventory.management.inventory.management.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    private String productName;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Integer currentStock;
    private Integer minStock;
    private String location;
    private Boolean isActive;
    private Long categoryId;
    private Long supplierId;
}