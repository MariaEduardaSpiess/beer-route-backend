package main.brand;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.beer.Beer;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
