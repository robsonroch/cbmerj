package br.gov.cbmerj.material.enums;

public enum AcessSubordinateRecord {
	
	NoThing("Sem permissão"),
	Read("Somente leitura"),
	Create("Criação"),
	Update("Atualização"),
	Delete("Remoção"),
	All("Todas permissões");
	
	private final String descricao;

	private AcessSubordinateRecord(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
