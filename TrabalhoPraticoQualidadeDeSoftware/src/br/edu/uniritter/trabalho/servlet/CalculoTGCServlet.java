package br.edu.uniritter.trabalho.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.uniritter.trabalho.calculo.Calculo;
import br.edu.uniritter.trabalho.calculo.Factory;
import br.edu.uniritter.trabalho.entity.Pessoa;
import br.edu.uniritter.trabalho.strategy.Strategy;

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
			Pessoa pessoa = new Strategy().getPessoaInstance(this, request);
			Calculo calculo = Factory.getCalculoTGCInstance(pessoa);
			calculo.getSituacao();
			
			out.print(new Gson().toJson(calculo));
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
}
