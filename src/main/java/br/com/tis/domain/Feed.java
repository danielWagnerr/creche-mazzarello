package br.com.tis.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "feed_post")
public class Feed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "feed_seq", sequenceName = "feed_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feed_seq")
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Autor é uma informação obrigatória.")
	private String autor;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Título é uma informação obrigatória.")
	private String titulo;
	
	@Column(nullable = false, length = 2000)
	@NotBlank(message = "Texto é uma informação obrigatória.")
	private String texto;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;
}