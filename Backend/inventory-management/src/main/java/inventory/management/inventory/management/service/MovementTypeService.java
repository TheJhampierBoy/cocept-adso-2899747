package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.MovementTypeRequestDto;
import inventory.management.inventory.management.dto.MovementTypeResponseDto;
import java.util.List;

public interface MovementTypeService {
    MovementTypeResponseDto createMovementType(MovementTypeRequestDto requestDto);
    MovementTypeResponseDto getMovementTypeById(Long id);
    List<MovementTypeResponseDto> getAllMovementTypes();
    MovementTypeResponseDto updateMovementType(Long id, MovementTypeRequestDto requestDto);
    void deleteMovementType(Long id);
}