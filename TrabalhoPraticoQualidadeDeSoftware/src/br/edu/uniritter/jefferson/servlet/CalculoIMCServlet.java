package br.edu.uniritter.jefferson.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.uniritter.jefferson.imc.CalculoIMC;
import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.imc.exception.SituacaoIMCException;

import com.google.gson.Gson;

/**
 * Servlet implementation class CalculoIMGServlet
 */
public class CalculoIMCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			out.print("Faça o Request via POST HTTP method!");
		}
		catch (Exception e) {
			e.printStackTrace(out);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("applicatino/json");
		PrintWriter out = response.getWriter();
		
		try{
			CalculoIMC calculo = this.carregaCalculoIMG(request);
			calculo.getSituacaoIMC();
			
			out.print(new Gson().toJson(calculo));
		}
		catch (SituacaoIMCException e) {
			e.printStackTrace(out);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}

	private CalculoIMC carregaCalculoIMG(HttpServletRequest request) {
		CalculoIMC calculo = new CalculoIMC();
		
		try {
			calculo.setAltura(Double.parseDouble(request.getParameter("txtAltura")));
			calculo.setPeso(Double.parseDouble(request.getParameter("txtPeso")));
			
			if(request.getParameter("slSexo").equalsIgnoreCase("m")) {
				calculo.setSexo(Sexo.Masculino);
			}
			else {
				calculo.setSexo(Sexo.Feminino);
			}
		}
		catch (Exception e) {
			calculo = null;
		}
		
		return calculo;
	}
}
