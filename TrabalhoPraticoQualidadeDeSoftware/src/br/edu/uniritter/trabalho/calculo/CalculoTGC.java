package br.edu.uniritter.trabalho.calculo;

import java.text.DecimalFormat;

import br.edu.uniritter.trabalho.calculo.enums.SituacaoTGC;
import br.edu.uniritter.trabalho.calculo.exceptions.SituacaoIMCException;
import br.edu.uniritter.trabalho.calculo.exceptions.TGCException;
import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.entity.Sexo;

class CalculoTGC extends CalculoIMC {

	private double tgc;
	private SituacaoTGC situacaoTGC;
	
	public CalculoTGC(Pessoa pessoa) {
		super(pessoa);
	}
	
	public double getTgc() throws SituacaoIMCException {
		this.calcular();
		return tgc;
	}

	public void setTgc(double tgc) {
		this.tgc = tgc;
	}

	@Override
	public Enum getSituacao() {
		try{ 
			this.calcular();
			SituacaoTGC situacao = null;
			double[] indices = super.pessoa.getSexo().equals(Sexo.Masculino) ? this.getSituacaoTGCMasculino() : this.getSituacaoTGCFeminino();
			
			DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setMaximumFractionDigits(1);
			
			double ideal = super.tratarCasasDecimais(indices[0]);
			double aceitavel = super.tratarCasasDecimais(indices[1]);
			
			if(this.tgc < ideal) {
				situacao = SituacaoTGC.AbaixoDoIdeal;
			}
			else if(this.tgc == ideal) {
				situacao = SituacaoTGC.Ideal;
			}
			else if(this.tgc > ideal && this.tgc < aceitavel) {
				situacao = SituacaoTGC.EntreAceitavelIdeal;
			}
			else if(this.tgc == aceitavel) {
				situacao = SituacaoTGC.Aceitavel;
			}
			else {
				situacao = SituacaoTGC.AcimaDoAceitavel;
			}
			
			this.situacaoTGC = situacao;
			return this.situacaoTGC;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private double[] getSituacaoTGCFeminino() {
		double ideal = 0.0;
		double aceitavel = 0.0;
		
		if(super.pessoa.getIdade() < 30) {
			ideal = 16.0;
			aceitavel = 18.0;
		} else if(super.pessoa.getIdade() >= 30 && super.pessoa.getIdade() < 40) {
			ideal = 18.0;
			aceitavel = 20.0;
		} else if(super.pessoa.getIdade() >= 40 && super.pessoa.getIdade() < 50) {
			ideal = 18.5;
			aceitavel = 23.5;
		} else if(super.pessoa.getIdade() > 50 && super.pessoa.getIdade() < 60) {
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
		
		if(super.pessoa.getIdade() < 30) {
			ideal = 9.0;
			aceitavel = 13.0;
		} else if(super.pessoa.getIdade() >= 30 && super.pessoa.getIdade() < 40) {
			ideal = 12.5;
			aceitavel = 16.5;
		} else if(super.pessoa.getIdade() >= 40 && super.pessoa.getIdade() < 50) {
			ideal = 15.0;
			aceitavel = 19.0;
		} else {
			ideal = 16.5;
			aceitavel = 20.5;
		}
		
		return new double[]{ideal, aceitavel};
	}

	@Override
	public double calcular() {
		try {
			this.validarDadosParaCalculoTGC();
		
			super.calcular();
			double imc = super.getImc();
			int sexo = super.pessoa.getSexo() == Sexo.Masculino ? 1 : 0;
			
			this.tgc = (1.2 * imc) - (10.8 * sexo) + (0.23 * super.pessoa.getIdade()) - 5.4;
			this.tgc = super.tratarCasasDecimais(this.tgc);
			
			System.out.println("TGC = " + this.tgc);
			
		} catch(TGCException e) {
			e.printStackTrace();
			return 0.0;
		}
		
		return this.tgc;
	}

	protected void validarDadosParaCalculoTGC() throws TGCException {
		try {
			super.validarDadosParaCalculoDoIMC();
		} catch(SituacaoIMCException e) {
			throw new TGCException("Falha na validacao dos dados para o calculo do TGC!", e);
		}
		
		if(super.pessoa.getIdade() <= 0) {
			throw new TGCException("Falha na validacao dos dados para o calculo do TGC, informacao de idade invalida ou inexistente!");
		}
		
	}
}
