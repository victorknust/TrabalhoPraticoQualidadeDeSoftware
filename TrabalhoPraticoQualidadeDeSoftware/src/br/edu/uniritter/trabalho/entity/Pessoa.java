package br.edu.uniritter.trabalho.entity;


public class Pessoa {

	private Sexo sexo;
	private double altura;
	private double peso;
	private int idade;
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public Pessoa setSexo(Sexo sexo) {
		this.sexo = sexo;
		return this;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public Pessoa setAltura(double altura) {
		this.altura = altura;
		return this;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public Pessoa setPeso(double peso) {
		this.peso = peso;
		return this;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public Pessoa setIdade(int idade) {
		this.idade = idade;
		return this;
	}
}
