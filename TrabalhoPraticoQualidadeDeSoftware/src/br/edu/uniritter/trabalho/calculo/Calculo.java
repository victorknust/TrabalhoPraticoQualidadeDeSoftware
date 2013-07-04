package br.edu.uniritter.trabalho.calculo;

import java.text.DecimalFormat;

public abstract class Calculo {

	public abstract Enum getSituacao();
	public abstract double calcular();
	
	protected double tratarCasasDecimais(double valor) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(1);
		
		 return Double.parseDouble(decimalFormat.format(valor).toString().replace(',', '.'));
	}
}
