package br.edu.uniritter.trabalho.calculo;

import br.edu.uniritter.trabalho.entity.Pessoa;

public class Factory {

	private Factory() {
	}
	
	public static Calculo getCalculoIMCInstance(Pessoa pessoa) {
		return new CalculoIMC(pessoa);
	}
	
	public static Calculo getCalculoTGCInstance(Pessoa pessoa) {
		return new CalculoTGC(pessoa);
	}
	
	public static Calculo getCalculoPesoIdealInstance(Pessoa pessoa) {
		return new CalculoPesoIdeal(pessoa);
	}
}
