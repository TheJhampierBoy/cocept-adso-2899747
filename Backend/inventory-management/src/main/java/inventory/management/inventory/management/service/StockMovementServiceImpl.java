package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.StockMovementRequestDto;
import inventory.management.inventory.management.dto.StockMovementResponseDto;
import inventory.management.inventory.management.entity.StockMovement;
import inventory.management.inventory.management.entity.Product;
import inventory.management.inventory.management.entity.MovementType;
import inventory.management.inventory.management.entity.User;
import inventory.management.inventory.management.repository.StockMovementRepository;
import inventory.management.inventory.management.repository.ProductRepository;
import inventory.management.inventory.management.repository.MovementTypeRepository;
import inventory.management.inventory.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    private final ProductRepository productRepository;
    private final MovementTypeRepository movementTypeRepository;
    private final UserRepository userRepository;

    @Override
    public StockMovementResponseDto createStockMovement(StockMovementRequestDto requestDto) {
        StockMovement stockMovement = new StockMovement();
        stockMovement.setQuantity(requestDto.getQuantity());
        stockMovement.setReason(requestDto.getReason());
        stockMovement.setReferenceNumber(requestDto.getReferenceNumber());
        stockMovement.setMovementDate(requestDto.getMovementDate());
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        stockMovement.setProduct(product);
        MovementType movementType = movementTypeRepository.findById(requestDto.getMovementTypeId()).orElseThrow(() -> new RuntimeException("MovementType not found"));
        stockMovement.setMovementType(movementType);
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        stockMovement.setUser(user);
        StockMovement saved = stockMovementRepository.save(stockMovement);
        return mapToResponseDto(saved);
    }

    @Override
    public StockMovementResponseDto getStockMovementById(Long id) {
        StockMovement stockMovement = stockMovementRepository.findById(id).orElseThrow(() -> new RuntimeException("StockMovement not found"));
        return mapToResponseDto(stockMovement);
    }

    @Override
    public List<StockMovementResponseDto> getAllStockMovements() {
        return stockMovementRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public StockMovementResponseDto updateStockMovement(Long id, StockMovementRequestDto requestDto) {
        StockMovement stockMovement = stockMovementRepository.findById(id).orElseThrow(() -> new RuntimeException("StockMovement not found"));
        stockMovement.setQuantity(requestDto.getQuantity());
        stockMovement.setReason(requestDto.getReason());
        stockMovement.setReferenceNumber(requestDto.getReferenceNumber());
        stockMovement.setMovementDate(requestDto.getMovementDate());
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        stockMovement.setProduct(product);
        MovementType movementType = movementTypeRepository.findById(requestDto.getMovementTypeId()).orElseThrow(() -> new RuntimeException("MovementType not found"));
        stockMovement.setMovementType(movementType);
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        stockMovement.setUser(user);
        StockMovement updated = stockMovementRepository.save(stockMovement);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteStockMovement(Long id) {
        stockMovementRepository.deleteById(id);
    }

    private StockMovementResponseDto mapToResponseDto(StockMovement stockMovement) {
        StockMovementResponseDto dto = new StockMovementResponseDto();
        dto.setMovementId(stockMovement.getMovementId());
        dto.setQuantity(stockMovement.getQuantity());
        dto.setReason(stockMovement.getReason());
        dto.setReferenceNumber(stockMovement.getReferenceNumber());
        dto.setMovementDate(stockMovement.getMovementDate());
        dto.setProductId(stockMovement.getProduct().getProductId());
        dto.setMovementTypeId(stockMovement.getMovementType().getMovementTypeId());
        dto.setUserId(stockMovement.getUser().getUserId());
        return dto;
    }
}