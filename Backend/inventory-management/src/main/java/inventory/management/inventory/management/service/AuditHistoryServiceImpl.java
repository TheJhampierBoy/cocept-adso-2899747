package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.AuditHistoryRequestDto;
import inventory.management.inventory.management.dto.AuditHistoryResponseDto;
import inventory.management.inventory.management.entity.AuditHistory;
import inventory.management.inventory.management.entity.User;
import inventory.management.inventory.management.repository.AuditHistoryRepository;
import inventory.management.inventory.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditHistoryServiceImpl implements AuditHistoryService {

    private final AuditHistoryRepository auditHistoryRepository;
    private final UserRepository userRepository;

    @Override
    public AuditHistoryResponseDto createAuditHistory(AuditHistoryRequestDto requestDto) {
        AuditHistory auditHistory = new AuditHistory();
        auditHistory.setTableName(requestDto.getTableName());
        auditHistory.setRecordId(requestDto.getRecordId());
        auditHistory.setActionType(AuditHistory.ActionType.valueOf(requestDto.getActionType()));
        auditHistory.setOldValues(requestDto.getOldValues());
        auditHistory.setNewValues(requestDto.getNewValues());
        auditHistory.setActionTimestamp(requestDto.getActionTimestamp());
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        auditHistory.setUser(user);
        AuditHistory saved = auditHistoryRepository.save(auditHistory);
        return mapToResponseDto(saved);
    }

    @Override
    public AuditHistoryResponseDto getAuditHistoryById(Long id) {
        AuditHistory auditHistory = auditHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("AuditHistory not found"));
        return mapToResponseDto(auditHistory);
    }

    @Override
    public List<AuditHistoryResponseDto> getAllAuditHistories() {
        return auditHistoryRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public AuditHistoryResponseDto updateAuditHistory(Long id, AuditHistoryRequestDto requestDto) {
        AuditHistory auditHistory = auditHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("AuditHistory not found"));
        auditHistory.setTableName(requestDto.getTableName());
        auditHistory.setRecordId(requestDto.getRecordId());
        auditHistory.setActionType(AuditHistory.ActionType.valueOf(requestDto.getActionType()));
        auditHistory.setOldValues(requestDto.getOldValues());
        auditHistory.setNewValues(requestDto.getNewValues());
        auditHistory.setActionTimestamp(requestDto.getActionTimestamp());
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        auditHistory.setUser(user);
        AuditHistory updated = auditHistoryRepository.save(auditHistory);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteAuditHistory(Long id) {
        auditHistoryRepository.deleteById(id);
    }

    private AuditHistoryResponseDto mapToResponseDto(AuditHistory auditHistory) {
        AuditHistoryResponseDto dto = new AuditHistoryResponseDto();
        dto.setAuditId(auditHistory.getAuditId());
        dto.setTableName(auditHistory.getTableName());
        dto.setRecordId(auditHistory.getRecordId());
        dto.setActionType(auditHistory.getActionType().toString());
        dto.setOldValues(auditHistory.getOldValues());
        dto.setNewValues(auditHistory.getNewValues());
        dto.setActionTimestamp(auditHistory.getActionTimestamp());
        dto.setUserId(auditHistory.getUser().getUserId());
        return dto;
    }
}