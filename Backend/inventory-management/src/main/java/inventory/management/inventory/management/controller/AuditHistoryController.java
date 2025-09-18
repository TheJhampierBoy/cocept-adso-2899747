package inventory.management.inventory.management.controller;

import inventory.management.inventory.management.dto.AuditHistoryRequestDto;
import inventory.management.inventory.management.dto.AuditHistoryResponseDto;
import inventory.management.inventory.management.service.AuditHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit-history")
@RequiredArgsConstructor
public class AuditHistoryController {

    private final AuditHistoryService auditHistoryService;

    @PostMapping
    public ResponseEntity<AuditHistoryResponseDto> createAuditHistory(@RequestBody AuditHistoryRequestDto requestDto) {
        AuditHistoryResponseDto response = auditHistoryService.createAuditHistory(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditHistoryResponseDto> getAuditHistoryById(@PathVariable Long id) {
        AuditHistoryResponseDto response = auditHistoryService.getAuditHistoryById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AuditHistoryResponseDto>> getAllAuditHistories() {
        List<AuditHistoryResponseDto> response = auditHistoryService.getAllAuditHistories();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditHistoryResponseDto> updateAuditHistory(@PathVariable Long id, @RequestBody AuditHistoryRequestDto requestDto) {
        AuditHistoryResponseDto response = auditHistoryService.updateAuditHistory(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditHistory(@PathVariable Long id) {
        auditHistoryService.deleteAuditHistory(id);
        return ResponseEntity.noContent().build();
    }
}