package com.washics18.ProjetoVendas.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1 , "Pessoa Física"),
	PESSOAJURIDICA(2 , "Pessao Juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod , String descricao) {
		
		this.cod = cod;
		this.descricao = descricao; 
	}
	
	public int getCod() {
		
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) { //vai percorrer os codigos pessoa fisica e juridica. static vai rodar mesmo não sendo instaciado
		
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente codigo : TipoCliente.values()) {
			
			if(codigo.equals(codigo.getCod())) {
				return codigo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
