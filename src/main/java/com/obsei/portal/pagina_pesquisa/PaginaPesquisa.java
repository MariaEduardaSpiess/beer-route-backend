package com.obsei.portal.pagina_pesquisa;

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
@Table(name = "pagina_pesquisa")
public class PaginaPesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public static final String HEADLINE="headline";
	@Column(name = "headline", nullable = false)
	private String headline;
	
	public static final String DESCRICAO="descricao";
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	public static final String LOGO="logo";
	@Column(name = "logo", nullable = false)
	private String logo;


}
