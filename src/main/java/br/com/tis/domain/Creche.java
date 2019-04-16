package br.com.tis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Creche")
@Table(name = "creche")
public class Creche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String historia;
	private String email;
	private String telefone;
	private String endereco;

	@OneToMany(mappedBy = "creche", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Trabalho> trabalhos = new ArrayList<Trabalho>();

	public Creche() {

	}

	public Creche(String nome, String endereco, String telefone) {
		super();
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}
	
	public void addTrabalho(Trabalho trabalho) {
		trabalhos.add(trabalho);
		trabalho.setCreche(this);
	}
	
	public void removeTrabalho(Trabalho trabalho) {
		trabalhos.remove(trabalho);
		trabalho.setCreche(null);
	}

	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Integer getId() {
		return id;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
