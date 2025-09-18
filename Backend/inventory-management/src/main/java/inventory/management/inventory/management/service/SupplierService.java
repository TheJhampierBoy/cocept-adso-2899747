package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.SupplierRequestDto;
import inventory.management.inventory.management.dto.SupplierResponseDto;
import java.util.List;

public interface SupplierService {
    SupplierResponseDto createSupplier(SupplierRequestDto requestDto);
    SupplierResponseDto getSupplierById(Long id);
    List<SupplierResponseDto> getAllSuppliers();
    SupplierResponseDto updateSupplier(Long id, SupplierRequestDto requestDto);
    void deleteSupplier(Long id);
}