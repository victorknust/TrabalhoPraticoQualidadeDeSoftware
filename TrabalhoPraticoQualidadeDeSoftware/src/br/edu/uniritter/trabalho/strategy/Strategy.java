package br.edu.uniritter.trabalho.strategy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.servlet.CalculoIMCServlet;
import br.edu.uniritter.trabalho.servlet.CalculoPesoIdealServlet;
import br.edu.uniritter.trabalho.servlet.CalculoTGCServlet;

public class Strategy {

	public Pessoa getPessoaInstance(HttpServlet servlet, HttpServletRequest request) throws Exception {
		if(servlet.getClass().equals(CalculoIMCServlet.class)) {
			return new IMCStrategy().getPessoaInstance(request);
		}
		else if(servlet.getClass().equals(CalculoTGCServlet.class)) {
			return new TGCStrategy().getPessoaInstance(request);
		}
		else if(servlet.getClass().equals(CalculoPesoIdealServlet.class)) {
			return new PesoIdealStrategy().getPessoaInstance(request);
		}
		else {
			throw new Exception("Servlet inválido!");
		}
	}
}
