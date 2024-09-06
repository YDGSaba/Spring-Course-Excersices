package ir.freeland.springboot.persistence.repo;

import ir.freeland.springboot.persistence.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
