package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.AuditHistoryRequestDto;
import inventory.management.inventory.management.dto.AuditHistoryResponseDto;
import java.util.List;

public interface AuditHistoryService {
    AuditHistoryResponseDto createAuditHistory(AuditHistoryRequestDto requestDto);
    AuditHistoryResponseDto getAuditHistoryById(Long id);
    List<AuditHistoryResponseDto> getAllAuditHistories();
    AuditHistoryResponseDto updateAuditHistory(Long id, AuditHistoryRequestDto requestDto);
    void deleteAuditHistory(Long id);
}