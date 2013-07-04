package br.edu.uniritter.trabalho.calculo;

import br.edu.uniritter.trabalho.calculo.enums.SituacaoIMC;
import br.edu.uniritter.trabalho.calculo.exceptions.SituacaoIMCException;
import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.entity.Sexo;

class CalculoIMC extends Calculo {
	
	protected Pessoa pessoa;
	private double imc;
	private SituacaoIMC situacaoIMG;
	
	public CalculoIMC(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public double getImc() {
		return imc;
	}
	
	@Override
	public Enum getSituacao() {
		try {
			this.calcular();
			
			if(this.pessoa.getSexo() == null) {
				throw new SituacaoIMCException("O valor do sexo nao foi denido!");
			}
			
			this.situacaoIMG = this.pessoa.getSexo() == Sexo.Masculino ? this.getSituacaoIMCMasculino() : this.getSituacaiIMCFeminino();
			return this.situacaoIMG;
		}
		catch(SituacaoIMCException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public double calcular() {
		try {
			this.validarDadosParaCalculoDoIMC();
		}
		catch (SituacaoIMCException e) {
			e.printStackTrace();
			return 0.0;
		}
		
		this.imc = this.pessoa.getPeso() / Math.pow(this.pessoa.getAltura(), 2);
//		System.out.println("IMC = " + this.imc);
		
		return this.imc;
	}

	protected void validarDadosParaCalculoDoIMC() throws SituacaoIMCException {
		if(this.pessoa.getAltura() <= 0.0) {
			throw new SituacaoIMCException("Informacao de altura incorreto ou inexistente!");
		}
		
		if(this.pessoa.getPeso() <= 0.0) {
			throw new SituacaoIMCException("Informacao de peso incorreto ou inexistente!");
		}
	}

	protected SituacaoIMC getSituacaoIMCMasculino() {
		SituacaoIMC situacao = null;
		
		if(imc < 20.7) {
			situacao = SituacaoIMC.AbaixoDoPeso;
		} else if(imc >= 20.7 && imc <= 26.4) {
			situacao = SituacaoIMC.Ideal;
		} else {
			situacao = SituacaoIMC.Obeso;
		}
		
		return situacao;
	}
	
	protected SituacaoIMC getSituacaiIMCFeminino() {
		SituacaoIMC situacao = null;
		
		if(imc < 19.1) {
			situacao = SituacaoIMC.AbaixoDoPeso;
		} else if(imc >= 19.1 && imc <= 25.8) {
			situacao = SituacaoIMC.Ideal;
		} else {
			situacao = SituacaoIMC.Obeso;
		}
		
		return situacao;
	}
}
