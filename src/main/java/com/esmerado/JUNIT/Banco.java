package com.esmerado.JUNIT;

import java.math.BigDecimal;

public class Banco {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void transferir(Cuenta origen, Cuenta destino, BigDecimal cant) {
		origen.debito(cant);
		destino.credito(cant);
	}
	
}
