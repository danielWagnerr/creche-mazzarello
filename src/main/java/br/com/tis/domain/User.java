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
@Table(name = "user")
@Builder
public class User {
	public User() {}
	
    public User(int id,
			@Email(message = "Insira um email válido") @NotEmpty(message = "Insira um email") String email,
			@Length(min = 6, message = "Sua senha deve ter, no mínimo, 6 caracteres") @NotEmpty(message = "Insira uma senha") String password,
			@NotEmpty(message = "Insira o seu nome") String name,
			@NotEmpty(message = "Insira o seu sobrenome") String lastName, int active, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.roles = roles;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    
    @Column(name = "email")
    @Email(message = "Insira um email válido")
    @NotEmpty(message = "Insira um email")
    private String email;
    
    @Column(name = "password")
    @Length(min = 6, message = "Sua senha deve ter, no mínimo, 6 caracteres")
    @NotEmpty(message = "Insira uma senha")
    private String password;
    
    @Column(name = "name")
    @NotEmpty(message = "Insira o seu nome")
    private String name;
    
    @Column(name = "last_name")
    @NotEmpty(message = "Insira o seu sobrenome")
    private String lastName;
    
    @Column(name = "active")
    private int active;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

}