package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.OrderItemRequestDto;
import inventory.management.inventory.management.dto.OrderItemResponseDto;
import inventory.management.inventory.management.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemResponseDto> createOrderItem(@RequestBody OrderItemRequestDto requestDto) {
        OrderItemResponseDto response = orderItemService.createOrderItem(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDto> getOrderItemById(@PathVariable Long id) {
        OrderItemResponseDto response = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDto>> getAllOrderItems() {
        List<OrderItemResponseDto> response = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponseDto> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemRequestDto requestDto) {
        OrderItemResponseDto response = orderItemService.updateOrderItem(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}