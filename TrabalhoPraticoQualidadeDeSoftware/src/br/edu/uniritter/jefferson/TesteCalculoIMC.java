package br.edu.uniritter.jefferson;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TesteCalculoIMC {

	private CalculoIMC calculoIMC;
	
	@Before
	public void declaracaoCalculoIMG() {
		this.calculoIMC = new CalculoIMC();
	}
	
	@Test
	public void testaValorCalculadoDoCalculoIMG(){
		this.calculoIMC.setAltura(1.7);
		this.calculoIMC.setPeso(75.5);
		this.calculoIMC.setSexo(Sexo.Masculino);
		
//		Assert.assertEquals();
	}

}
