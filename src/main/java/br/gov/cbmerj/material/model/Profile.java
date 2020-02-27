package br.gov.cbmerj.material.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id", insertable=false, updatable = false)
	private Role papeis;
	
	@ManyToMany
    @JoinTable(name="profile_feature", joinColumns=
    {@JoinColumn(name="profile_id")}, inverseJoinColumns=
      {@JoinColumn(name="feature_id")})
	private Set<Feature> funcionalidades;

}
