package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.SupplierRequestDto;
import inventory.management.inventory.management.dto.SupplierResponseDto;
import inventory.management.inventory.management.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDto> createSupplier(@RequestBody SupplierRequestDto requestDto) {
        SupplierResponseDto response = supplierService.createSupplier(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(@PathVariable Long id) {
        SupplierResponseDto response = supplierService.getSupplierById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {
        List<SupplierResponseDto> response = supplierService.getAllSuppliers();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequestDto requestDto) {
        SupplierResponseDto response = supplierService.updateSupplier(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}