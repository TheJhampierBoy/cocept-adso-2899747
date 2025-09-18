package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.AlertRequestDto;
import inventory.management.inventory.management.dto.AlertResponseDto;
import inventory.management.inventory.management.entity.Alert;
import inventory.management.inventory.management.entity.Product;
import inventory.management.inventory.management.repository.AlertRepository;
import inventory.management.inventory.management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final ProductRepository productRepository;

    @Override
    public AlertResponseDto createAlert(AlertRequestDto requestDto) {
        Alert alert = new Alert();
        alert.setAlertType(Alert.AlertType.valueOf(requestDto.getAlertType()));
        alert.setAlertMessage(requestDto.getAlertMessage());
        alert.setIsResolved(requestDto.getIsResolved());
        alert.setResolvedAt(requestDto.getResolvedAt());
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        alert.setProduct(product);
        Alert saved = alertRepository.save(alert);
        return mapToResponseDto(saved);
    }

    @Override
    public AlertResponseDto getAlertById(Long id) {
        Alert alert = alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alert not found"));
        return mapToResponseDto(alert);
    }

    @Override
    public List<AlertResponseDto> getAllAlerts() {
        return alertRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public AlertResponseDto updateAlert(Long id, AlertRequestDto requestDto) {
        Alert alert = alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setAlertType(Alert.AlertType.valueOf(requestDto.getAlertType()));
        alert.setAlertMessage(requestDto.getAlertMessage());
        alert.setIsResolved(requestDto.getIsResolved());
        alert.setResolvedAt(requestDto.getResolvedAt());
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        alert.setProduct(product);
        Alert updated = alertRepository.save(alert);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }

    private AlertResponseDto mapToResponseDto(Alert alert) {
        AlertResponseDto dto = new AlertResponseDto();
        dto.setAlertId(alert.getAlertId());
        dto.setAlertType(alert.getAlertType().toString());
        dto.setAlertMessage(alert.getAlertMessage());
        dto.setIsResolved(alert.getIsResolved());
        dto.setCreatedAt(alert.getCreatedAt());
        dto.setResolvedAt(alert.getResolvedAt());
        dto.setProductId(alert.getProduct().getProductId());
        return dto;
    }
}