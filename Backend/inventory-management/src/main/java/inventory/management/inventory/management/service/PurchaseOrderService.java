package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.PurchaseOrderRequestDto;
import inventory.management.inventory.management.dto.PurchaseOrderResponseDto;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderResponseDto createPurchaseOrder(PurchaseOrderRequestDto requestDto);
    PurchaseOrderResponseDto getPurchaseOrderById(Long id);
    List<PurchaseOrderResponseDto> getAllPurchaseOrders();
    PurchaseOrderResponseDto updatePurchaseOrder(Long id, PurchaseOrderRequestDto requestDto);
    void deletePurchaseOrder(Long id);
}