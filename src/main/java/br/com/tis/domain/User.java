package br.com.tis.domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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

}