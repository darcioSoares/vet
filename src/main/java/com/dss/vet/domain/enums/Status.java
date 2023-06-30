package com.dss.vet.domain.enums;

public enum Status {
	
	ATIVO(0), 
	CONGELADO(1),
	SUSPENSO(2),	
    CANCELADO(3);
	
	private Integer cod;
	
	private Status(Integer cod) {
		this.cod = cod;
	}
	
	public Integer getCod() {
		return cod;
	}

	//metodo para pegar o valor do enum pelo codigo
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;			
		}
		
		for(Status x : Status.values() ) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status invalido");
	}
	
	
	

}
