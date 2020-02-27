package br.gov.cbmerj.material.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.gov.cbmerj.material.validation.annotation.UserHierarchyCircleValidator;

@Entity
@UserHierarchyCircleValidator(message = "Hierarquia circular no usuário")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Length (min=10, max=255)  
    @Column (unique=true)    
	private String nome;
	private String email;
	private String senha;
	private Integer nivelHirarquivo;
	
	@ManyToMany
    @JoinTable(name="user_role", joinColumns=
    {@JoinColumn(name="id")}, inverseJoinColumns=
      {@JoinColumn(name="id")})
	private Role papel;	

	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="chefe")
    private User chefe;

    @OneToMany(mappedBy="chefe", cascade={CascadeType.MERGE})
    @JsonIgnoreProperties("chefe")
    private Set<User> subordinates = new HashSet<User>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null && !nome.equals(other.nome))
				return false;
		} else if (!id.equals(other.id) && !nome.equals(other.nome))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User getChefe() {
		return chefe;
	}

	public void setChefe(User chefe) {
		this.chefe = chefe;
	}

	public Integer getNivelHirarquivo() {
		return nivelHirarquivo;
	}

	public void setNivelHirarquivo(Integer nivelHirarquivo) {
		this.nivelHirarquivo = nivelHirarquivo;
	}

	public Set<User> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<User> subordinates) {
		this.subordinates = subordinates;
	}
	
}
