package inventory.management.inventory.management.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemRequestDto {
    private Long orderId;
    private Long productId;
    private Integer quantityOrdered;
    private Integer quantityReceived;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private LocalDateTime receivedDate;
    private String status;
}