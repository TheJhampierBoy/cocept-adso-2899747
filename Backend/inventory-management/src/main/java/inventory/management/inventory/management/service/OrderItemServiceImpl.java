package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.OrderItemRequestDto;
import inventory.management.inventory.management.dto.OrderItemResponseDto;
import inventory.management.inventory.management.entity.OrderItem;
import inventory.management.inventory.management.entity.PurchaseOrder;
import inventory.management.inventory.management.entity.Product;
import inventory.management.inventory.management.repository.OrderItemRepository;
import inventory.management.inventory.management.repository.PurchaseOrderRepository;
import inventory.management.inventory.management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderItemResponseDto createOrderItem(OrderItemRequestDto requestDto) {
        OrderItem orderItem = new OrderItem();
        PurchaseOrder order = purchaseOrderRepository.findById(requestDto.getOrderId()).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        orderItem.setOrder(order);
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        orderItem.setProduct(product);
        orderItem.setQuantityOrdered(requestDto.getQuantityOrdered());
        orderItem.setQuantityReceived(requestDto.getQuantityReceived());
        orderItem.setUnitPrice(requestDto.getUnitPrice());
        orderItem.setTotalPrice(requestDto.getTotalPrice());
        orderItem.setReceivedDate(requestDto.getReceivedDate());
        orderItem.setStatus(OrderItem.Status.valueOf(requestDto.getStatus()));
        OrderItem saved = orderItemRepository.save(orderItem);
        return mapToResponseDto(saved);
    }

    @Override
    public OrderItemResponseDto getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return mapToResponseDto(orderItem);
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public OrderItemResponseDto updateOrderItem(Long id, OrderItemRequestDto requestDto) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderItem not found"));
        PurchaseOrder order = purchaseOrderRepository.findById(requestDto.getOrderId()).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        orderItem.setOrder(order);
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        orderItem.setProduct(product);
        orderItem.setQuantityOrdered(requestDto.getQuantityOrdered());
        orderItem.setQuantityReceived(requestDto.getQuantityReceived());
        orderItem.setUnitPrice(requestDto.getUnitPrice());
        orderItem.setTotalPrice(requestDto.getTotalPrice());
        orderItem.setReceivedDate(requestDto.getReceivedDate());
        orderItem.setStatus(OrderItem.Status.valueOf(requestDto.getStatus()));
        OrderItem updated = orderItemRepository.save(orderItem);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    private OrderItemResponseDto mapToResponseDto(OrderItem orderItem) {
        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setItemId(orderItem.getItemId());
        dto.setOrderId(orderItem.getOrder().getOrderId());
        dto.setProductId(orderItem.getProduct().getProductId());
        dto.setQuantityOrdered(orderItem.getQuantityOrdered());
        dto.setQuantityReceived(orderItem.getQuantityReceived());
        dto.setUnitPrice(orderItem.getUnitPrice());
        dto.setTotalPrice(orderItem.getTotalPrice());
        dto.setReceivedDate(orderItem.getReceivedDate());
        dto.setStatus(orderItem.getStatus().toString());
        return dto;
    }
}