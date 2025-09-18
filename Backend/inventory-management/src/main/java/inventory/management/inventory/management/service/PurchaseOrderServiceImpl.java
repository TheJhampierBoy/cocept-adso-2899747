package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.PurchaseOrderRequestDto;
import inventory.management.inventory.management.dto.PurchaseOrderResponseDto;
import inventory.management.inventory.management.entity.PurchaseOrder;
import inventory.management.inventory.management.entity.Supplier;
import inventory.management.inventory.management.entity.User;
import inventory.management.inventory.management.repository.PurchaseOrderRepository;
import inventory.management.inventory.management.repository.SupplierRepository;
import inventory.management.inventory.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    @Override
    public PurchaseOrderResponseDto createPurchaseOrder(PurchaseOrderRequestDto requestDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderNumber(requestDto.getOrderNumber());
        Supplier supplier = supplierRepository.findById(requestDto.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        purchaseOrder.setSupplier(supplier);
        purchaseOrder.setOrderDate(requestDto.getOrderDate());
        purchaseOrder.setExpectedDeliveryDate(requestDto.getExpectedDeliveryDate());
        purchaseOrder.setTotalAmount(requestDto.getTotalAmount());
        purchaseOrder.setStatus(PurchaseOrder.Status.valueOf(requestDto.getStatus()));
        purchaseOrder.setNotes(requestDto.getNotes());
        User createdBy = userRepository.findById(requestDto.getCreatedBy()).orElseThrow(() -> new RuntimeException("User not found"));
        purchaseOrder.setCreatedBy(createdBy);
        PurchaseOrder saved = purchaseOrderRepository.save(purchaseOrder);
        return mapToResponseDto(saved);
    }

    @Override
    public PurchaseOrderResponseDto getPurchaseOrderById(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        return mapToResponseDto(purchaseOrder);
    }

    @Override
    public List<PurchaseOrderResponseDto> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderResponseDto updatePurchaseOrder(Long id, PurchaseOrderRequestDto requestDto) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        purchaseOrder.setOrderNumber(requestDto.getOrderNumber());
        Supplier supplier = supplierRepository.findById(requestDto.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        purchaseOrder.setSupplier(supplier);
        purchaseOrder.setOrderDate(requestDto.getOrderDate());
        purchaseOrder.setExpectedDeliveryDate(requestDto.getExpectedDeliveryDate());
        purchaseOrder.setTotalAmount(requestDto.getTotalAmount());
        purchaseOrder.setStatus(PurchaseOrder.Status.valueOf(requestDto.getStatus()));
        purchaseOrder.setNotes(requestDto.getNotes());
        User createdBy = userRepository.findById(requestDto.getCreatedBy()).orElseThrow(() -> new RuntimeException("User not found"));
        purchaseOrder.setCreatedBy(createdBy);
        PurchaseOrder updated = purchaseOrderRepository.save(purchaseOrder);
        return mapToResponseDto(updated);
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

    private PurchaseOrderResponseDto mapToResponseDto(PurchaseOrder purchaseOrder) {
        PurchaseOrderResponseDto dto = new PurchaseOrderResponseDto();
        dto.setOrderId(purchaseOrder.getOrderId());
        dto.setOrderNumber(purchaseOrder.getOrderNumber());
        dto.setSupplierId(purchaseOrder.getSupplier().getSupplierId());
        dto.setOrderDate(purchaseOrder.getOrderDate());
        dto.setExpectedDeliveryDate(purchaseOrder.getExpectedDeliveryDate());
        dto.setTotalAmount(purchaseOrder.getTotalAmount());
        dto.setStatus(purchaseOrder.getStatus().toString());
        dto.setNotes(purchaseOrder.getNotes());
        dto.setCreatedBy(purchaseOrder.getCreatedBy().getUserId());
        dto.setCreatedAt(purchaseOrder.getCreatedAt());
        dto.setUpdatedAt(purchaseOrder.getUpdatedAt());
        return dto;
    }
}