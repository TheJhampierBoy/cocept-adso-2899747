package inventory.management.inventory.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movement_types")
public class MovementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_type_id")
    private Long movementTypeId;

    @Column(name = "type_name", nullable = false, length = 50)
    private String typeName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}