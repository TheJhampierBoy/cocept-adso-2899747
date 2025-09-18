package inventory.management.inventory.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_history")
public class AuditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    @Column(name = "table_name", nullable = false, length = 100)
    private String tableName;

    @Column(name = "record_id", nullable = false)
    private Long recordId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false)
    private ActionType actionType;

    @Column(name = "old_values", columnDefinition = "JSON")
    private String oldValues;

    @Column(name = "new_values", columnDefinition = "JSON")
    private String newValues;

    @Column(name = "action_timestamp")
    private LocalDateTime actionTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public enum ActionType {
        INSERT, UPDATE, DELETE
    }
}