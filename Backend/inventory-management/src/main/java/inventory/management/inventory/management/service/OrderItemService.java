package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.OrderItemRequestDto;
import inventory.management.inventory.management.dto.OrderItemResponseDto;
import java.util.List;

public interface OrderItemService {
    OrderItemResponseDto createOrderItem(OrderItemRequestDto requestDto);
    OrderItemResponseDto getOrderItemById(Long id);
    List<OrderItemResponseDto> getAllOrderItems();
    OrderItemResponseDto updateOrderItem(Long id, OrderItemRequestDto requestDto);
    void deleteOrderItem(Long id);
}