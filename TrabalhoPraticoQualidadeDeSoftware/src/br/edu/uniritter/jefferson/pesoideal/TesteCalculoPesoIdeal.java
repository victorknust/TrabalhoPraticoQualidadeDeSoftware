package br.edu.uniritter.jefferson.pesoideal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.pesoideal.exception.PesoIdealException;

public class TesteCalculoPesoIdeal {

	private CalculoPesoIdeal calculoPesoIdeal;
	
	@Before
	public void init() {
		this.calculoPesoIdeal = new CalculoPesoIdeal();
	}
	
	@Test
	public void testePesoIdeal() throws PesoIdealException {
		this.calculoPesoIdeal.setSexo(Sexo.Masculino);
		this.calculoPesoIdeal.setAltura(1.7);
		
		Assert.assertEquals(65.0, this.calculoPesoIdeal.getPesoIdeial(), 0.1);
	}
	
	@Test(expected = PesoIdealException.class)
	public void testeException() throws PesoIdealException {
		this.calculoPesoIdeal.setAltura(1.7);
		
		this.calculoPesoIdeal.getPesoIdeial();
	}
}
