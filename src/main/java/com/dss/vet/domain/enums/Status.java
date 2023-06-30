package com.dss.vet.domain.enums;

public enum Status {
	
	ATIVO(1), 
	CONGELADO(2),
	SUSPENSO(3),	
    CANCELADO(4);
	
	private Integer cod;
	
	private Status(Integer cod) {
		this.cod = cod;
	}
	

	public Integer getCod() {
		return cod;
	}

	
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
