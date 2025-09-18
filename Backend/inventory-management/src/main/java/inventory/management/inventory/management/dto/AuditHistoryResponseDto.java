package inventory.management.inventory.management.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditHistoryResponseDto {
    private Long auditId;
    private String tableName;
    private Long recordId;
    private String actionType;
    private String oldValues;
    private String newValues;
    private LocalDateTime actionTimestamp;
    private Long userId;
}