package br.edu.uniritter.jefferson.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.pesoideal.CalculoPesoIdeal;
import br.edu.uniritter.jefferson.pesoideal.exception.PesoIdealException;

import com.google.gson.Gson;

/**
 * Servlet implementation class CalculoIMGServlet
 */
public class CalculoPesoIdealServlet extends HttpServlet {
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
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		try{
			CalculoPesoIdeal calculo = this.carregaCalculoPesoIdeal(request);
			calculo.getPesoIdeial();
			
			out.print(new Gson().toJson(calculo));
		}
		catch (PesoIdealException e) {
			e.printStackTrace(out);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	private CalculoPesoIdeal carregaCalculoPesoIdeal(HttpServletRequest request) {
		CalculoPesoIdeal calculo = new CalculoPesoIdeal();
		
		try {
			calculo.setAltura(Double.parseDouble(request.getParameter("txtAltura")));
			
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
