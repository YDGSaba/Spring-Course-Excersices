package ir.freeland.springboot.persistence.repo;

import ir.freeland.springboot.persistence.model.CorruptedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorruptedItemRepository extends JpaRepository<CorruptedItem, Long> {
}
