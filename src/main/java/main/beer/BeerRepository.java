package main.beer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {
	List<Beer> findByBrandIdEquals(Long brandId);
}
