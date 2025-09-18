package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}