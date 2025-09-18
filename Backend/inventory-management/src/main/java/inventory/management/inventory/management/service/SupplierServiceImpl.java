package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.SupplierRequestDto;
import inventory.management.inventory.management.dto.SupplierResponseDto;
import inventory.management.inventory.management.entity.Supplier;
import inventory.management.inventory.management.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponseDto createSupplier(SupplierRequestDto requestDto) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(requestDto.getSupplierName());
        supplier.setContactPerson(requestDto.getContactPerson());
        supplier.setPhone(requestDto.getPhone());
        supplier.setEmail(requestDto.getEmail());
        supplier.setAddress(requestDto.getAddress());
        supplier.setIsActive(requestDto.getIsActive());
        Supplier saved = supplierRepository.save(supplier);
        return mapToResponseDto(saved);
    }

    @Override
    public SupplierResponseDto getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        return mapToResponseDto(supplier);
    }

    @Override
    public List<SupplierResponseDto> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public SupplierResponseDto updateSupplier(Long id, SupplierRequestDto requestDto) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setSupplierName(requestDto.getSupplierName());
        supplier.setContactPerson(requestDto.getContactPerson());
        supplier.setPhone(requestDto.getPhone());
        supplier.setEmail(requestDto.getEmail());
        supplier.setAddress(requestDto.getAddress());
        supplier.setIsActive(requestDto.getIsActive());
        Supplier updated = supplierRepository.save(supplier);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    private SupplierResponseDto mapToResponseDto(Supplier supplier) {
        SupplierResponseDto dto = new SupplierResponseDto();
        dto.setSupplierId(supplier.getSupplierId());
        dto.setSupplierName(supplier.getSupplierName());
        dto.setContactPerson(supplier.getContactPerson());
        dto.setPhone(supplier.getPhone());
        dto.setEmail(supplier.getEmail());
        dto.setAddress(supplier.getAddress());
        dto.setIsActive(supplier.getIsActive());
        dto.setCreatedAt(supplier.getCreatedAt());
        return dto;
    }
}