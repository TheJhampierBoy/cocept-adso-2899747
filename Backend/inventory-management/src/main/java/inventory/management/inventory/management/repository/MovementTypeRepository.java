package inventory.management.inventory.management.repository;

import inventory.management.inventory.management.entity.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType, Long> {
}