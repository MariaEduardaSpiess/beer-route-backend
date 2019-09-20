package com.beer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerEndpoint {
	
	@Resource
	private EntityManager em;
	
	private BeerRepository repository;

	public BeerEndpoint(BeerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(path = "/beers")
	public ResponseEntity<List<Object>> findAll() {
		return ResponseEntity.ok(StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList()));
	}
	
	@PostMapping(path = "/beer")
	public ResponseEntity<Beer> cadastrar(@Valid @RequestBody Beer beer) {
		return ResponseEntity.ok(repository.save(beer));
	}
	
	@PutMapping(path = "/beer")
	public ResponseEntity<Beer> atualizar(@Valid @RequestBody Beer beer) {
		return ResponseEntity.ok(repository.save(beer));
	}
}
