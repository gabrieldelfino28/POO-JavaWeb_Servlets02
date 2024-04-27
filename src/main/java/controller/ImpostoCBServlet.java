package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ImpostoCBServlet
 */
@WebServlet("/curitiba")
public class ImpostoCBServlet extends HttpServlet implements IImpostoStrategy {
	private static final long serialVersionUID = 1L;

	public ImpostoCBServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		RequestDispatcher rd = request.getRequestDispatcher("cb.jsp");
		rd.forward(request, response);
	}

	@Override
	public HttpServletRequest calcImposto(HttpServletRequest request) throws ArithmeticException {
		double areaTotal = Double.parseDouble(request.getParameter("areaTotal")) * 5;
		int idadeMovel = Integer.parseInt(request.getParameter("idadeMovel"));
		double impostoTotal = 0;

		if (idadeMovel > 50) {
			impostoTotal = areaTotal + (idadeMovel * 3);
		} else if (idadeMovel < 20) {
			impostoTotal = areaTotal + (idadeMovel * 5);
		} else if (idadeMovel > 20 && idadeMovel < 50) {
			impostoTotal = areaTotal + (idadeMovel * 2.5);
		}
		request.setAttribute("impostoTotal", String.format("%.2f", impostoTotal));
		return request;
	}

}
