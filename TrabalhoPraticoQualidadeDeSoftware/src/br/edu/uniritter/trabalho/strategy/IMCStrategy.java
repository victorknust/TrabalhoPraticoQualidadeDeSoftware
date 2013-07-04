package br.edu.uniritter.trabalho.strategy;

import javax.servlet.http.HttpServletRequest;

import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.entity.Sexo;

class IMCStrategy implements ContratoStrategy {

	@Override
	public Pessoa getPessoaInstance(HttpServletRequest request) {
		return new Pessoa()
			.setAltura(Double.parseDouble(request.getParameter("txtAltura")))
			.setPeso(Double.parseDouble(request.getParameter("txtPeso")))
			.setSexo(request.getParameter("slSexo").equalsIgnoreCase("m") ? Sexo.Masculino : Sexo.Feminino);
	}	
}
