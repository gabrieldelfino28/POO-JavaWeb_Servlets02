package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ImpostoSaoPaulo
 */

@WebServlet("/saoPaulo")
public class ImpostoSPServlet extends HttpServlet implements IImpostoStrategy {
	private static final long serialVersionUID = 1L;

	public ImpostoSPServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saida = "";
		try {
			calcImposto(request);
			saida = "Calculo bem-sucedido!";
			request.setAttribute("saida", saida);
		} catch (Exception e) {
			saida = e.getMessage();
			request.setAttribute("saida", saida);
		}
		RequestDispatcher rd = request.getRequestDispatcher("sp.jsp");
		rd.forward(request, response);
	}

	@Override
	public HttpServletRequest calcImposto(HttpServletRequest request) throws ArithmeticException {
		double areaTotal = Double.parseDouble(request.getParameter("areaTotal")) * 10;
		int numQuartos = Integer.parseInt(request.getParameter("numQuartos")) * 2;
		double impostoTotal = areaTotal + numQuartos;
		request.setAttribute("impostoTotal", String.format("%.2f", impostoTotal));
		return request;
	}
}
