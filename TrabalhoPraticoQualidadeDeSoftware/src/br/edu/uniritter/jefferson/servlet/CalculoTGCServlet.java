package br.edu.uniritter.jefferson.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.uniritter.jefferson.imc.enums.Sexo;
import br.edu.uniritter.jefferson.tgc.CalculoTGC;
import br.edu.uniritter.jefferson.tgc.exception.TGCException;

import com.google.gson.Gson;

/**
 * Servlet implementation class CalculoIMGServlet
 */
public class CalculoTGCServlet extends HttpServlet {
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
			CalculoTGC calculo = this.carregaCalculoTGC(request);
			calculo.getSituacaoTGC();
			
			out.print(new Gson().toJson(calculo));
		}
		catch (TGCException e) {
			e.printStackTrace(out);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	private CalculoTGC carregaCalculoTGC(HttpServletRequest request) {
		CalculoTGC calculo = new CalculoTGC();
		
		try {
			calculo.setAltura(Double.parseDouble(request.getParameter("txtAltura")));
			calculo.setPeso(Double.parseDouble(request.getParameter("txtPeso")));
			calculo.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
			
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
