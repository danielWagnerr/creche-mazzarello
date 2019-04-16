package br.com.tis;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tis.domain.Creche;
import br.com.tis.domain.Trabalho;
import br.com.tis.repositories.CrecheRepository;

@SpringBootApplication
public class CrecheMazzarelloApplication implements CommandLineRunner {

	@Autowired
	private CrecheRepository crecheRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrecheMazzarelloApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Creche creche = new Creche("Creche Madre Mazzarello", "Rua Teste", "31 99999 9999");
		creche.addTrabalho(new Trabalho("Creche", "Segunda a Sexta", "Não aceitamos crianças"));
		creche.addTrabalho(new Trabalho("Idosos", "Domingo", "Não aceitamos idosos"));
		creche.addTrabalho(new Trabalho("Caridade", "Sabado", "Não aceitamos caridade"));
		
		crecheRepository.saveAll(Arrays.asList(creche));
		
		
		
	}

}
