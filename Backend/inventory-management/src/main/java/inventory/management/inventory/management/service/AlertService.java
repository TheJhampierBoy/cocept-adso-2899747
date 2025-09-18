package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.AlertRequestDto;
import inventory.management.inventory.management.dto.AlertResponseDto;
import java.util.List;

public interface AlertService {
    AlertResponseDto createAlert(AlertRequestDto requestDto);
    AlertResponseDto getAlertById(Long id);
    List<AlertResponseDto> getAllAlerts();
    AlertResponseDto updateAlert(Long id, AlertRequestDto requestDto);
    void deleteAlert(Long id);
}