package main.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import main.views.Views;
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
@Table(name = "brand")
public class Brand {

	@Id
	@JsonView(Views.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonView(Views.Public.class)
	@Column(name = "description", nullable = false)
	private String description;

	@JsonView(Views.Public.class)
	@Column(name = "latlng", nullable = false)
	private String latlng;

	@JsonView(Views.Public.class)
	@Column(name = "logo_name", nullable = true)
	private String logo_name;

	@Lob
	@JsonView(Views.Internal.class)
	@Column(name = "image", nullable = false)
	private String image;
}