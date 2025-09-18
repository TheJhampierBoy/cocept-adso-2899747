package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.StockMovementRequestDto;
import inventory.management.inventory.management.dto.StockMovementResponseDto;
import inventory.management.inventory.management.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
@RequiredArgsConstructor
public class StockMovementController {

    private final StockMovementService stockMovementService;

    @PostMapping
    public ResponseEntity<StockMovementResponseDto> createStockMovement(@RequestBody StockMovementRequestDto requestDto) {
        StockMovementResponseDto response = stockMovementService.createStockMovement(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovementResponseDto> getStockMovementById(@PathVariable Long id) {
        StockMovementResponseDto response = stockMovementService.getStockMovementById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StockMovementResponseDto>> getAllStockMovements() {
        List<StockMovementResponseDto> response = stockMovementService.getAllStockMovements();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMovementResponseDto> updateStockMovement(@PathVariable Long id, @RequestBody StockMovementRequestDto requestDto) {
        StockMovementResponseDto response = stockMovementService.updateStockMovement(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.noContent().build();
    }
}