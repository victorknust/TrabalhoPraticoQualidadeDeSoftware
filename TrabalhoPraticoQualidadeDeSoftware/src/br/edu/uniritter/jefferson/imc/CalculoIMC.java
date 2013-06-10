package br.edu.uniritter.jefferson.imc;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.imc.enums.SituacaoIMC;
import br.edu.uniritter.jefferson.imc.exception.SituacaoIMCException;

public class CalculoIMC {
	
	private double peso;
	private double altura;
	private Sexo sexo;
	private double imc;
	
	public CalculoIMC() {
		this.peso = 0.0;
		this.altura = 0.0;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public double getImc() {
		return imc;
	}
	
	public SituacaoIMC getSituacaoIMC() throws SituacaoIMCException {
		this.calcularIMC();
		
		if(this.sexo == null) {
			throw new SituacaoIMCException("O valor do sexo nao foi denido!");
		}
		
		return this.sexo == Sexo.Masculino ? this.getSituacaoIMCMasculino() : this.getSituacaiIMCFeminino();
	}
	
	private void calcularIMC() throws SituacaoIMCException {
		this.validarDadosParaCalculoDoIMC();
		
		this.imc = this.peso / Math.pow(this.altura, 2);
	}

	private void validarDadosParaCalculoDoIMC() throws SituacaoIMCException {
		if(this.altura <= 0.0) {
			throw new SituacaoIMCException("Informacao de altura incorreto ou inexistente!");
		}
		
		if(this.peso <= 0.0) {
			throw new SituacaoIMCException("Informacao de peso incorreto ou inexistente!");
		}
	}

	private SituacaoIMC getSituacaoIMCMasculino() {
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
	
	private SituacaoIMC getSituacaiIMCFeminino() {
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
