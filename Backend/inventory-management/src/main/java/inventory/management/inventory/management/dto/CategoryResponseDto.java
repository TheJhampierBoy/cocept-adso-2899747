package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;
}