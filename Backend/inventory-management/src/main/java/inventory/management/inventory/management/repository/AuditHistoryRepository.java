package inventory.management.inventory.management.repository;

import inventory.management.inventory.management.entity.AuditHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditHistoryRepository extends JpaRepository<AuditHistory, Long> {
}