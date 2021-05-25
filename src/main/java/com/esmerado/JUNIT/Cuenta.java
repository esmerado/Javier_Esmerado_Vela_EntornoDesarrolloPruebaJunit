package com.esmerado.JUNIT;

import java.math.BigDecimal;

import exceptions.DineroInsuficiente;

/**
 * Javier Esmerado Vela
 * 
 * @author esmer
 *
 */
public class Cuenta {
	// Atributos
	private String persona;
	private BigDecimal saldo;

	public Cuenta(String persona, BigDecimal saldo) {
		this.persona = persona;
		this.saldo = saldo;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public void debito(BigDecimal cantidad) {
		BigDecimal nuevoSaldo = this.saldo.subtract(cantidad);
		if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new DineroInsuficiente("Dinero Insuficiente");
		}
		this.saldo = nuevoSaldo;
	}
	
	public void credito(BigDecimal cantidad) {
		this.saldo = this.saldo.add(cantidad);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}
	
	

}
