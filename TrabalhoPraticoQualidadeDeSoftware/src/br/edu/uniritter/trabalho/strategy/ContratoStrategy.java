package br.edu.uniritter.trabalho.strategy;

import javax.servlet.http.HttpServletRequest;

import br.edu.uniritter.trabalho.entity.Pessoa;

public interface ContratoStrategy {
	public Pessoa getPessoaInstance(HttpServletRequest request);
}
