package br.com.tis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tis.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
