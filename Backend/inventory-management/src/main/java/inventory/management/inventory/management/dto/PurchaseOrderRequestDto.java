package inventory.management.inventory.management.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseOrderRequestDto {
    private String orderNumber;
    private Long supplierId;
    private LocalDateTime orderDate;
    private LocalDateTime expectedDeliveryDate;
    private BigDecimal totalAmount;
    private String status;
    private String notes;
    private Long createdBy;
}