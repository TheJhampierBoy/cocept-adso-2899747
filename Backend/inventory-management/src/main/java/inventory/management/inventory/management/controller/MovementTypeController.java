package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.MovementTypeRequestDto;
import inventory.management.inventory.management.dto.MovementTypeResponseDto;
import inventory.management.inventory.management.service.MovementTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movement-types")
@RequiredArgsConstructor
public class MovementTypeController {

    private final MovementTypeService movementTypeService;

    @PostMapping
    public ResponseEntity<MovementTypeResponseDto> createMovementType(@RequestBody MovementTypeRequestDto requestDto) {
        MovementTypeResponseDto response = movementTypeService.createMovementType(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementTypeResponseDto> getMovementTypeById(@PathVariable Long id) {
        MovementTypeResponseDto response = movementTypeService.getMovementTypeById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MovementTypeResponseDto>> getAllMovementTypes() {
        List<MovementTypeResponseDto> response = movementTypeService.getAllMovementTypes();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementTypeResponseDto> updateMovementType(@PathVariable Long id, @RequestBody MovementTypeRequestDto requestDto) {
        MovementTypeResponseDto response = movementTypeService.updateMovementType(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementType(@PathVariable Long id) {
        movementTypeService.deleteMovementType(id);
        return ResponseEntity.noContent().build();
    }
}