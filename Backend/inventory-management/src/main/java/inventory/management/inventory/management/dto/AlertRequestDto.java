package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlertRequestDto {
    private String alertType;
    private String alertMessage;
    private Boolean isResolved;
    private LocalDateTime resolvedAt;
    private Long productId;
}