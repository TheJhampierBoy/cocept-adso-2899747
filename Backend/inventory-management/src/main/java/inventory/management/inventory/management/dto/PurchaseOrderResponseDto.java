package inventory.management.inventory.management.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseOrderResponseDto {
    private Long orderId;
    private String orderNumber;
    private Long supplierId;
    private LocalDateTime orderDate;
    private LocalDateTime expectedDeliveryDate;
    private BigDecimal totalAmount;
    private String status;
    private String notes;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}