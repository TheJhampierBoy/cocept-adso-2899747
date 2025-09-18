package inventory.management.inventory.management.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String email;
    private String passwordHash;
    private String fullName;
    private String role;
    private Boolean isActive;
}