package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SupplierResponseDto {
    private Long supplierId;
    private String supplierName;
    private String contactPerson;
    private String phone;
    private String email;
    private String address;
    private Boolean isActive;
    private LocalDateTime createdAt;
}