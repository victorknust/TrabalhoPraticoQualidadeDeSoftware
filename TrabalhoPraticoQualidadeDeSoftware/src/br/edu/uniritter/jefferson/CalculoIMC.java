package br.edu.uniritter.jefferson;

public class CalculoIMC {
	
	private double peso;
	private double altura;
	private Sexo sexo;
	private double imc;
	
	public CalculoIMC() {
		// TODO
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

	public void setImc(double imc) {
		this.imc = imc;
	}
}
