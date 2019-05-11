package br.com.tis.services;

import org.springframework.stereotype.Service;

import br.com.tis.domain.Usuario;

@Service
public interface UsuarioService {
	void save(Usuario usuario);
	
	Usuario findByUsername(String username);
}
