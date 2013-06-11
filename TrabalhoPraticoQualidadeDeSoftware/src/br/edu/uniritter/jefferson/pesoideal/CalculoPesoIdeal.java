package br.edu.uniritter.jefferson.pesoideal;

import java.text.DecimalFormat;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.pesoideal.exception.PesoIdealException;

public class CalculoPesoIdeal {
	
	private double altura;
	private Sexo sexo;
	private double pesoIdeial;
	
	public CalculoPesoIdeal() {
		this.pesoIdeial = 0.0;
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

	public double getPesoIdeial() throws PesoIdealException {
		this.calcularPesoIdeial();
		return pesoIdeial;
	}

	private void calcularPesoIdeial() throws PesoIdealException {
		this.validarDadosParaCalcularPesoIdeal();
		
		int k = (this.sexo.equals(Sexo.Masculino) ? 4 : 2);
		double h = this.altura * 100;
		
		this.pesoIdeial = (h - 100) - (h - 150) / k;
	}
	
	private void validarDadosParaCalcularPesoIdeal() throws PesoIdealException {
		if(this.sexo ==  null) {
			throw new PesoIdealException("Campos inválidos ou inezistentes!");
		}
	}
	
	private double tratarCasasDecimais(double valor) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(1);
		
		 return Double.parseDouble(decimalFormat.format(valor).toString().replace(',', '.'));
	}
}
