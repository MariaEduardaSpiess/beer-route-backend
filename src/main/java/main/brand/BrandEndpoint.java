package main.brand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;
import main.views.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandEndpoint {
	
	@Resource
	private EntityManager em;
	
	private BrandRepository repository;

	public BrandEndpoint(BrandRepository repository) {
		this.repository = repository;
	}

	@JsonView(Views.Public.class)
	@GetMapping(path = "/brands")
	public ResponseEntity<List<Object>> findAll() {
		return ResponseEntity.ok(StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList()));
	}
	
	@PostMapping(path = "/brand")
	public ResponseEntity<Brand> cadastrar(@Valid @RequestBody Brand brand) {
		return ResponseEntity.ok(repository.save(brand));
	}
	
	@PutMapping(path = "/brand")
	public ResponseEntity<Brand> atualizar(@Valid @RequestBody Brand brand) {
		return ResponseEntity.ok(repository.save(brand));
	}
}
