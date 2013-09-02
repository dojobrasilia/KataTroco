package br.com.dilas.kata.troco.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.dilas.kata.troco.Troco;

public class TrocoTest {
	private Troco troco;
	
	@Before
	public void criarTroco() {
		troco = new Troco();
	}
	
	@Test
	public void testResto() throws Exception {
		troco.setValorTotal(new BigDecimal("10"));
		troco.setValorPago(new BigDecimal("10"));
		troco.calcular();

		assertEquals(BigDecimal.ZERO, troco.getResto());
	}
	
	@Test
	public void testCalcular() throws Exception {
		troco.setValorTotal(new BigDecimal("110.25"));
		troco.setValorPago(new BigDecimal("10.90"));		
		troco.calcular();

		assertEquals(new BigDecimal("99.35"), troco.getResto());
		
		troco.setValorTotal(new BigDecimal("90.10"));
		troco.setValorPago(new BigDecimal("100.30"));
		troco.calcular();
		
		assertEquals(new BigDecimal("10.20"), troco.getResto());
	}
}
