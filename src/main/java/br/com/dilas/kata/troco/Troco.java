package br.com.dilas.kata.troco;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class Troco {
	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	private BigDecimal resto;
	private List<BigDecimal> listaNotaMoeda = Lists.newArrayList(
			new BigDecimal("100"),
			new BigDecimal("50"),
			new BigDecimal("10"),
			new BigDecimal("5"),
			new BigDecimal("1"),
			new BigDecimal("0.50"),
			new BigDecimal("0.10"),
			new BigDecimal("0.05"),
			new BigDecimal("0.01"));
	
	public BigDecimal getResto() {
		return resto;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
	public void calcular() {
		resto = valorTotal.subtract(valorPago).abs();
		
		System.out.println("---");
		System.out.println("Resto: " + resto);
		
		BigDecimal valor = new BigDecimal(resto.toString());
		
		System.out.println("Troco: ");
		while (pegarNotaMoeda(valor) != null) {
			System.out.print("R$ " + pegarNotaMoeda(valor) + " ");
			valor = valor.subtract(pegarNotaMoeda(valor));
			System.out.println("");
		}
	}
	
	public BigDecimal pegarNotaMoeda(BigDecimal valor) {
		BigDecimal retorno = null;
		for (BigDecimal notaMoeda : listaNotaMoeda) {
			if (valor.compareTo(notaMoeda) >= 0) { // -1 valor < notaMoeda | 0 valor == notaMoeda | 1 valor > notaMoeda
				retorno = notaMoeda;
				break;
			}
		}
		return retorno;
	}
}
