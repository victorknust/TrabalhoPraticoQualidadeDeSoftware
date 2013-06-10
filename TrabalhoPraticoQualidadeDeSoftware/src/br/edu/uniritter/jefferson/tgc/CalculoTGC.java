package br.edu.uniritter.jefferson.tgc;

import br.edu.uniritter.jefferson.imc.CalculoIMC;
import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.imc.exception.SituacaoIMCException;
import br.edu.uniritter.jefferson.tgc.enums.SituacaoTGC;
import br.edu.uniritter.jefferson.tgc.exception.TGCException;

public class CalculoTGC extends CalculoIMC {

	private int idade;
	private double tgc;
	
	public CalculoTGC() {
		this.idade = 0;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double getTgc() throws SituacaoIMCException {
		this.calcularIMC();
		return tgc;
	}

	public void setTgc(double tgc) {
		this.tgc = tgc;
	}

	public SituacaoTGC getSituacaoTGC() throws TGCException{
		this.calcularTGC();
		SituacaoTGC situacao = null;
		double[] indices = super.getSexo().equals(Sexo.Masculino) ? this.getSituacaoTGCMasculino() : this.getSituacaoTGCFeminino();
		
		double ideal = indices[0];
		double aceitavel = indices[1];
		
		if(this.tgc < ideal) {
			situacao = SituacaoTGC.AbaixoDoIdeal;
		} else if(this.tgc == ideal) {
			situacao = SituacaoTGC.Ideal;
		} else if(this.tgc > ideal && this.tgc < aceitavel) {
			situacao = SituacaoTGC.EntreAceitavelIdeal;
		} else if(this.tgc == aceitavel) {
			situacao = SituacaoTGC.Aceitavel;
		} else {
			situacao = SituacaoTGC.AcimaDoAceitavel;
		}
		
		return situacao;
	}

	private double[] getSituacaoTGCFeminino() {
		double ideal = 0.0;
		double aceitavel = 0.0;
		
		if(this.idade < 30) {
			ideal = 16.0;
			aceitavel = 18.0;
		} else if(this.idade >= 30 && this.idade < 40) {
			ideal = 18.0;
			aceitavel = 20.0;
		} else if(this.idade >= 40 && this.idade < 50) {
			ideal = 18.5;
			aceitavel = 23.5;
		} else if(this.idade > 50 && this.idade < 60) {
			ideal = 21.5;
			aceitavel = 26.5;
		} else {
			ideal = 22.5;
			aceitavel = 27.5;
		}
		
		return new double[]{ideal, aceitavel};
	}

	private double[] getSituacaoTGCMasculino() {
		double ideal = 0.0;
		double aceitavel = 0.0;
		
		if(this.idade < 30) {
			ideal = 9.0;
			aceitavel = 13.0;
		} else if(this.idade >= 30 && this.idade < 40) {
			ideal = 12.5;
			aceitavel = 16.5;
		} else if(this.idade >= 40 && this.idade < 50) {
			ideal = 15.0;
			aceitavel = 19.0;
		} else {
			ideal = 16.5;
			aceitavel = 20.5;
		}
		
		return new double[]{ideal, aceitavel};
	}

	protected void calcularTGC() throws TGCException {
		this.validarDadosParaCalculoTGC();
		
		try {
			super.calcularIMC();
			double imc = super.getImc();
			int sexo = super.getSexo() == Sexo.Masculino ? 1 : 0;
			
			this.tgc = (1.2 * imc) - (10.8 * sexo) + (0.23 * this.idade) - 5.4;
			System.out.println("TGC = " + this.tgc);
			
		} catch(SituacaoIMCException e) {
			throw new TGCException("Falha no calculo do TGC!", e);
		}
	}

	protected void validarDadosParaCalculoTGC() throws TGCException {
		try {
			super.validarDadosParaCalculoDoIMC();
		} catch(SituacaoIMCException e) {
			throw new TGCException("Falha na validacao dos dados para o calculo do TGC!", e);
		}
		
		if(this.idade <= 0) {
			throw new TGCException("Falha na validacao dos dados para o calculo do TGC, informacao de idade invalida ou inexistente!");
		}
		
	}
}
