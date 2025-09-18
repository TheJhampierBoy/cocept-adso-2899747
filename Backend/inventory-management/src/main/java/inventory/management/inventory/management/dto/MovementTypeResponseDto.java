package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MovementTypeResponseDto {
    private Long movementTypeId;
    private String typeName;
    private String description;
    private LocalDateTime createdAt;
}