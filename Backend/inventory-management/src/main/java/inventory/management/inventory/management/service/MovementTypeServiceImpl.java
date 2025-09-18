package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.MovementTypeRequestDto;
import inventory.management.inventory.management.dto.MovementTypeResponseDto;
import inventory.management.inventory.management.entity.MovementType;
import inventory.management.inventory.management.repository.MovementTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovementTypeServiceImpl implements MovementTypeService {

    private final MovementTypeRepository movementTypeRepository;

    @Override
    public MovementTypeResponseDto createMovementType(MovementTypeRequestDto requestDto) {
        MovementType movementType = new MovementType();
        movementType.setTypeName(requestDto.getTypeName());
        movementType.setDescription(requestDto.getDescription());
        MovementType saved = movementTypeRepository.save(movementType);
        return mapToResponseDto(saved);
    }

    @Override
    public MovementTypeResponseDto getMovementTypeById(Long id) {
        MovementType movementType = movementTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("MovementType not found"));
        return mapToResponseDto(movementType);
    }

    @Override
    public List<MovementTypeResponseDto> getAllMovementTypes() {
        return movementTypeRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public MovementTypeResponseDto updateMovementType(Long id, MovementTypeRequestDto requestDto) {
        MovementType movementType = movementTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("MovementType not found"));
        movementType.setTypeName(requestDto.getTypeName());
        movementType.setDescription(requestDto.getDescription());
        MovementType updated = movementTypeRepository.save(movementType);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteMovementType(Long id) {
        movementTypeRepository.deleteById(id);
    }

    private MovementTypeResponseDto mapToResponseDto(MovementType movementType) {
        MovementTypeResponseDto dto = new MovementTypeResponseDto();
        dto.setMovementTypeId(movementType.getMovementTypeId());
        dto.setTypeName(movementType.getTypeName());
        dto.setDescription(movementType.getDescription());
        dto.setCreatedAt(movementType.getCreatedAt());
        return dto;
    }
}