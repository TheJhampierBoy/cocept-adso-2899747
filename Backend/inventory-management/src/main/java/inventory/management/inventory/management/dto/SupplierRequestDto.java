package inventory.management.inventory.management.dto;

import lombok.Data;

@Data
public class SupplierRequestDto {
    private String supplierName;
    private String contactPerson;
    private String phone;
    private String email;
    private String address;
    private Boolean isActive;
}