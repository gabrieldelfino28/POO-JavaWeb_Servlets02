package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ImpostoPAServlet
 */

@WebServlet("/portoAlegre")
public class ImpostoPAServlet extends HttpServlet implements IImpostoStrategy {
	private static final long serialVersionUID = 1L;

	public ImpostoPAServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("pa.jsp");
		rd.forward(request, response);
	}

	@Override
	public HttpServletRequest calcImposto(HttpServletRequest request) throws ArithmeticException {
		String cmd = request.getParameter("radioGaragem");
		double areaTotal = 0;
		double areaGaragem = 0;
		if (cmd.equals("No")) {
			areaTotal = Double.parseDouble(request.getParameter("areaTotal")) * 8;
		} else {
			areaTotal = Double.parseDouble(request.getParameter("areaTotal")) * 7.5;
			areaGaragem = Double.parseDouble(request.getParameter("areaGaragem")) * 2.5;
		}
		double impostoTotal = areaTotal + areaGaragem;
		request.setAttribute("impostoTotal", String.format("%.2f", impostoTotal));
		return request;
	}

}
