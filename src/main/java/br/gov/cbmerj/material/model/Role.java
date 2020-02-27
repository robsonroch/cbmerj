package br.gov.cbmerj.material.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.gov.cbmerj.material.enums.AcessSubordinateRecord;

@Entity
public class Role {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (unique=true)    
	private String descricao;
	@Enumerated(EnumType.STRING)
	private AcessSubordinateRecord acessoRegistroSubordinados;
	
}
