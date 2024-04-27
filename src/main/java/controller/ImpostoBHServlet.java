package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beloHorizonte")
public class ImpostoBHServlet extends HttpServlet implements IImpostoStrategy {
	private static final long serialVersionUID = 1L;

    public ImpostoBHServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saida = "";
		try {
			calcImposto(request);
			saida = "Calculo bem-sucedido!";
			request.setAttribute("saida", saida);
		} catch (Exception e) {
			saida = e.getMessage();
			request.setAttribute("saida", saida);
		}
		RequestDispatcher rd = request.getRequestDispatcher("bh.jsp");
		rd.forward(request, response);
	}

	@Override
	public HttpServletRequest calcImposto(HttpServletRequest request) throws ArithmeticException{
		double areaTotal = Double.parseDouble(request.getParameter("areaTotal")) * 7;
		int numComodo = Integer.parseInt(request.getParameter("numComodo")) * 4;
		double impostoTotal = areaTotal + numComodo;
		request.setAttribute("impostoTotal", String.format("%.2f", impostoTotal));
		return request;
	}

}
