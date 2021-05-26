package com.washics18.ProjetoVendas.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1 , "Pendete"),
	QUITADO(2 , "Quitado"),
	CANCELADO(3 , "Cancelado");
	
	private int cod;
	private String descricao;
	
   private EstadoPagamento(int cod , String descricao) {
		
		this.cod = cod;
		this.descricao = descricao; 
	}
	
	public int getCod() {
		
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) { //vai percorrer os codigos pessoa fisica e juridica. static vai rodar mesmo não sendo instaciado
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento codigo : EstadoPagamento.values()) {
			
			if(cod.equals(codigo.getCod())) {
				return codigo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}


}
