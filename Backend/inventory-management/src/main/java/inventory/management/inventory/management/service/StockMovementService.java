package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.StockMovementRequestDto;
import inventory.management.inventory.management.dto.StockMovementResponseDto;
import java.util.List;

public interface StockMovementService {
    StockMovementResponseDto createStockMovement(StockMovementRequestDto requestDto);
    StockMovementResponseDto getStockMovementById(Long id);
    List<StockMovementResponseDto> getAllStockMovements();
    StockMovementResponseDto updateStockMovement(Long id, StockMovementRequestDto requestDto);
    void deleteStockMovement(Long id);
}