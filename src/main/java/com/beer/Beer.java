package com.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "pesquisador")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public static final String DESC="desc";
	@Column(name = "desc", nullable = false)
	private String desc;
	
	public static final String BRAND="brand";
	@Column(name = "brand", nullable = false)
	private String brand;
}