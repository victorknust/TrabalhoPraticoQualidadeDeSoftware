package br.edu.uniritter.jefferson.tgc;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.tgc.enums.SituacaoTGC;
import br.edu.uniritter.jefferson.tgc.exception.TGCException;


public class TesteCalculoTGC {

	private CalculoTGC calculoTGC;
	
	@Before
	public void init(){
		this.calculoTGC = new CalculoTGC();
	}
	
	@Test(expected = TGCException.class)
	public void testaCalculoTGCException() throws TGCException {
		this.calculoTGC.setPeso(75.5);
		this.calculoTGC.setAltura(1.7);
		this.calculoTGC.setSexo(Sexo.Masculino);
		
		this.calculoTGC.getSituacaoTGC();
	}
	
	@Test
	public void testaCalculoTGCAbaixoDoIdeal() throws TGCException {
		this.calculoTGC.setPeso(62);
		this.calculoTGC.setAltura(1.9);
		this.calculoTGC.setSexo(Sexo.Masculino);
		this.calculoTGC.setIdade(44);
		
		Assert.assertEquals(SituacaoTGC.AbaixoDoIdeal, this.calculoTGC.getSituacaoTGC());
	}
	
//	@Test
//	public void testaCalculoTGCIdeal() throws TGCException {
//		this.calculoTGC.setPeso(75.5);
//		this.calculoTGC.setAltura(1.7);
//		this.calculoTGC.setSexo(Sexo.Masculino);
//		
//		Assert.assertEquals(SituacaoTGC.AbaixoDoIdeal, this.calculoTGC.getSituacaoTGC());
//	}
//	
//	@Test
//	public void testaCalculoTGCEntreIdealAceitavel() throws TGCException {
//		this.calculoTGC.setPeso(75.5);
//		this.calculoTGC.setAltura(1.7);
//		this.calculoTGC.setSexo(Sexo.Masculino);
//		
//		Assert.assertEquals(SituacaoTGC.AbaixoDoIdeal, this.calculoTGC.getSituacaoTGC());
//	}
//	
//	@Test
//	public void testaCalculoTGCAceitavel() throws TGCException {
//		this.calculoTGC.setPeso(75.5);
//		this.calculoTGC.setAltura(1.7);
//		this.calculoTGC.setSexo(Sexo.Masculino);
//		
//		Assert.assertEquals(SituacaoTGC.AbaixoDoIdeal, this.calculoTGC.getSituacaoTGC());
//	}
//	
//	@Test
//	public void testaCalculoTGCAcimaAceitavel() throws TGCException {
//		this.calculoTGC.setPeso(75.5);
//		this.calculoTGC.setAltura(1.7);
//		this.calculoTGC.setSexo(Sexo.Masculino);
//		
//		Assert.assertEquals(SituacaoTGC.AbaixoDoIdeal, this.calculoTGC.getSituacaoTGC());
//	}

}
