package com.esmerado.JUNIT;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.DineroInsuficiente;

/**
 * Clase Test.
 * 
 * @author esmer
 *
 */
public class CuentaTest {

	/**
	 * Probamos el nombre de nuestra cuenta.
	 */
	@Test
	void testNombreCuenta() {

		Cuenta cuenta = new Cuenta("Javier", new BigDecimal("99.99"));

		final String ESPERADO = "Javier";

		String real = cuenta.getPersona();
		assertNotNull(real);
		assertEquals(ESPERADO, real);

	}

	/**
	 * Probamos el salod de la cuenta.
	 */
	@Test
	void testSaldoCuenta() {
		Cuenta cuenta = new Cuenta("Nadia", new BigDecimal("99.99"));

		final Double ESPERADO = 99.99;
		assertNotNull(cuenta.getSaldo());
		assertEquals(ESPERADO, cuenta.getSaldo().doubleValue());

	}

	@Test
	void testReferenciaCuenta() {
		Cuenta cuenta = new Cuenta("Pedro Picapiedra", new BigDecimal("899.99"));
		Cuenta cuenta2 = new Cuenta("Pedro Picapiedra", new BigDecimal("899.99"));

		// assertNotEquals(cuenta2, cuenta);
		assertEquals(cuenta2, cuenta);

	}

	@Test
	void testDebitoCuenta() {
		Cuenta cuenta = new Cuenta("Pedro Picapiedra", new BigDecimal("1000.99"));
		cuenta.debito(new BigDecimal("100"));

		assertNotNull(cuenta.getSaldo());
		assertEquals(900, cuenta.getSaldo().intValue());
		assertEquals("900.99", cuenta.getSaldo().toPlainString());
	}
	
	@Test
	void testCreditoCuenta() {
		Cuenta cuenta = new Cuenta("Pedro Picapiedra", new BigDecimal("899.99"));
		cuenta.credito(new BigDecimal("100"));

		assertNotNull(cuenta.getSaldo());
		assertEquals(999, cuenta.getSaldo().intValue());
		assertEquals("999.99", cuenta.getSaldo().toPlainString());
	}

	@Test
	void dineroInsuficienteExceptionCuenta() {
		Cuenta cuenta = new Cuenta("Javier", new BigDecimal("1000.99"));
		
		Exception ex = assertThrows(DineroInsuficiente.class, ()-> {
			cuenta.debito(new BigDecimal(1200));
		});
		
		final String real = ex.getMessage();
		final String esperado = "Dinero Insuficiente";
		assertEquals(esperado, real);
	}
	
	@Test
	void transferirDineroCuentas() {
		Cuenta cuenta1 = new Cuenta("Javier", new BigDecimal("2500"));
		Cuenta cuenta2 = new Cuenta("Nadia", new BigDecimal("1500"));
		
		Banco banco = new Banco();
		banco.setNombre("Banco Español");
		banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
		
		assertEquals("1000", cuenta2.getSaldo().toPlainString());
		assertEquals("3000", cuenta1.getSaldo().toPlainString());
		
	}
	
}
