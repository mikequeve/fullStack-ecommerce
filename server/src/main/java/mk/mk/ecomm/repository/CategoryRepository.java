package mk.mk.ecomm.repository;

import mk.mk.ecomm.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
