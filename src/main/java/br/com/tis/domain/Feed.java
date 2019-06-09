package br.com.tis.domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "feed")
@Builder
public class Feed {
	public Feed() {}
	
    public Feed(int id,
			@NotEmpty(message = "Insira o título") String titulo,
			@NotEmpty(message = "Insira o texto") String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feed_id")
    private long id;
    
    @Column(name = "titulo")
    @NotEmpty(message = "Insira o título")
    private String titulo;
    
    @Column(name = "texto", length=1073741824)
    @NotEmpty(message = "Insira o texto")
    private String texto;

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getId() {
		return id;
	}
}