package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlertResponseDto {
    private Long alertId;
    private String alertType;
    private String alertMessage;
    private Boolean isResolved;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
    private Long productId;
}