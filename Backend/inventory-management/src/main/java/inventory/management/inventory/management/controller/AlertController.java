package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.AlertRequestDto;
import inventory.management.inventory.management.dto.AlertResponseDto;
import inventory.management.inventory.management.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    public ResponseEntity<AlertResponseDto> createAlert(@RequestBody AlertRequestDto requestDto) {
        AlertResponseDto response = alertService.createAlert(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertResponseDto> getAlertById(@PathVariable Long id) {
        AlertResponseDto response = alertService.getAlertById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlertResponseDto>> getAllAlerts() {
        List<AlertResponseDto> response = alertService.getAllAlerts();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertResponseDto> updateAlert(@PathVariable Long id, @RequestBody AlertRequestDto requestDto) {
        AlertResponseDto response = alertService.updateAlert(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}