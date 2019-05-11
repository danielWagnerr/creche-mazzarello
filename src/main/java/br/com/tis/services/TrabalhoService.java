package br.com.tis.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tis.domain.Atividade;
import br.com.tis.repositories.TrabalhoRepository;

@Service
public class TrabalhoService {

	@Autowired
	private TrabalhoRepository repo;
	
	public Atividade buscar(Integer id) {
		Optional<Atividade> trabalho = repo.findById(id);
		return trabalho.orElse(null);
	}
	
}
