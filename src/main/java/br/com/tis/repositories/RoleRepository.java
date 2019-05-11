package br.com.tis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tis.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
