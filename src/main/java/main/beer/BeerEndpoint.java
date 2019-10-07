package main.beer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.brand.Brand;
import main.brand.BrandRepository;


@RestController
public class BeerEndpoint {
	
	@Resource
	private EntityManager em;
	
	private BeerRepository repository;
	private BrandRepository brandRepo;

	public BeerEndpoint(BeerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(path = "/beers/{brandId}")
	public ResponseEntity<List<Object>> findByBrandIdEquals(@PathVariable Long brandId) {
		return ResponseEntity.ok(StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList()));
	}
	
	@PostMapping(path = "/beer/{brandId}")
	public ResponseEntity<Beer> cadastrar(@PathVariable Long brandId, @Valid @RequestBody Beer beer) {
		Optional<Brand> brand = brandRepo.findById(brandId);
		beer.setBrand(brand.get());
		return ResponseEntity.ok(repository.save(beer));
	}
	
	@PutMapping(path = "/beer/{brandId}")
	public ResponseEntity<Beer> atualizar(@PathVariable Long brandId, @Valid @RequestBody Beer beer) {
		Optional<Brand> brand = brandRepo.findById(brandId);
		beer.setBrand(brand.get());
		return ResponseEntity.ok(repository.save(beer));
	}
}
