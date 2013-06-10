package br.edu.uniritter.jefferson.imc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.imc.enums.SituacaoIMC;
import br.edu.uniritter.jefferson.imc.exception.SituacaoIMCException;

public class TesteCalculoIMC {

	private CalculoIMC calculoIMC;
	
	@Before
	public void declaracaoCalculoIMG() {
		this.calculoIMC = new CalculoIMC();
	}
	
	@Test
	public void testaCalculoIMGIdeal() throws SituacaoIMCException{
		this.calculoIMC.setAltura(1.7);
		this.calculoIMC.setPeso(75.5);
		this.calculoIMC.setSexo(Sexo.Masculino);
		
		Assert.assertEquals(SituacaoIMC.Ideal, this.calculoIMC.getSituacaoIMC());
	}

	@Test
	public void testaCalculoIMGObeso() throws SituacaoIMCException{
		this.calculoIMC.setAltura(1.3);
		this.calculoIMC.setPeso(79.3);
		this.calculoIMC.setSexo(Sexo.Masculino);
		
		Assert.assertEquals(SituacaoIMC.Obeso, this.calculoIMC.getSituacaoIMC());
	}
	
	@Test
	public void testaCalculoIMGAbaixoDoPeso() throws SituacaoIMCException{
		this.calculoIMC.setAltura(1.82);
		this.calculoIMC.setPeso(67.1);
		this.calculoIMC.setSexo(Sexo.Masculino);
		
		Assert.assertEquals(SituacaoIMC.AbaixoDoPeso, this.calculoIMC.getSituacaoIMC());
	}
	
	@Test(expected = SituacaoIMCException.class)
	public void testaCalculoIMGException() throws SituacaoIMCException{
		this.calculoIMC.setAltura(2.1);
		this.calculoIMC.setSexo(Sexo.Masculino);
		this.calculoIMC.getSituacaoIMC();
	}
}
