package main.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import main.views.Views;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.brand.Brand;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "beer")
public class Beer {

	@Id
	@JsonView(Views.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonView(Views.Public.class)
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonView(Views.Internal.class)
	@JoinColumn(name = "brandId", nullable = false)
	private Brand brand;
	
	@Lob
	@JsonView(Views.Public.class)
	@Column(name = "image", nullable = false)
	private String image;
}