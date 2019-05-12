package br.com.tis;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tis.domain.Creche;
import br.com.tis.domain.Endereco;
import br.com.tis.domain.Atividade;
import br.com.tis.repositories.CrecheRepository;

@SpringBootApplication
public class CrecheMazzarelloApplication implements CommandLineRunner {

	@Autowired
	private CrecheRepository crecheRepository;
	
	private Endereco endereco;
	
	public static void main(String[] args) {
		SpringApplication.run(CrecheMazzarelloApplication.class, args);
	}

	public void run(String... args) throws Exception {
		/*endereco = new Endereco("Santa Cruz", "Rua Ana Paula", 117, 0, 31150660);
		Creche creche = new Creche("Creche Madre Mazzarello", "31 99999 9999", endereco);
		creche.addAtividade(new Atividade("Creche", "Segunda a Sexta", "Atividade com crianças..."));
		creche.addAtividade(new Atividade("Idosos", "Domingo", "Atividade com idosos..."));
		creche.addAtividade(new Atividade("Caridade", "Sabado", "Caridades..."));
		
		creche.setEndereco(endereco);
		endereco.setCreche(creche);
		
		crecheRepository.saveAll(Arrays.asList(creche));*/
		}
}
