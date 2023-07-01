package com.dss.vet.domain.enums;

public enum TypeAnimal {

	CACHORRO(0),
	GATO(1);
	
	private Integer cod;

	private TypeAnimal(Integer cod) {
		this.cod = cod;
	}
	
	private Integer getCod() {
		return cod;
	}
	
	public static TypeAnimal toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TypeAnimal x : TypeAnimal.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo do Animal invalido");
	}
	
	
}
