package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.PurchaseOrderRequestDto;
import inventory.management.inventory.management.dto.PurchaseOrderResponseDto;
import inventory.management.inventory.management.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderResponseDto> createPurchaseOrder(@RequestBody PurchaseOrderRequestDto requestDto) {
        PurchaseOrderResponseDto response = purchaseOrderService.createPurchaseOrder(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponseDto> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrderResponseDto response = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderResponseDto>> getAllPurchaseOrders() {
        List<PurchaseOrderResponseDto> response = purchaseOrderService.getAllPurchaseOrders();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponseDto> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrderRequestDto requestDto) {
        PurchaseOrderResponseDto response = purchaseOrderService.updatePurchaseOrder(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }
}