package br.edu.uniritter.trabalho.calculo;

import br.edu.uniritter.trabalho.calculo.exceptions.PesoIdealException;
import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.entity.Sexo;

class CalculoPesoIdeal extends Calculo {
	
	protected Pessoa pessoa;
	private double pesoIdeal;
	
	public CalculoPesoIdeal(Pessoa pessoa) {
		this.pesoIdeal = 0.0;
		this.pessoa = pessoa;
	}
	
	public double getPesoIdeial() throws PesoIdealException {
		this.calcular();
		return this.pesoIdeal;
	}

	@Override
	public double calcular() {
		try {
			this.validarDadosParaCalcularPesoIdeal();
			
			int k = (this.pessoa.getSexo().equals(Sexo.Masculino) ? 4 : 2);
			double h = this.pessoa.getAltura() * 100;
			
			this.pesoIdeal = (h - 100) - (h - 150) / k;
			return this.pesoIdeal;
		}
		catch(PesoIdealException e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	private void validarDadosParaCalcularPesoIdeal() throws PesoIdealException {
		if(this.pessoa.getSexo() ==  null) {
			throw new PesoIdealException("Campos inválidos ou inezistentes!");
		}
	}

	@Override
	public Enum getSituacao() {
		return null;
	}
}
