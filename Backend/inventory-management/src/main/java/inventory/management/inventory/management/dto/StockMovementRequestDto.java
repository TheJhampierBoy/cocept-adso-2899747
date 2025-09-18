package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockMovementRequestDto {
    private Integer quantity;
    private String reason;
    private String referenceNumber;
    private LocalDateTime movementDate;
    private Long productId;
    private Long movementTypeId;
    private Long userId;
}