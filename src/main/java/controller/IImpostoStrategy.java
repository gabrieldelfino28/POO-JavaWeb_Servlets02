package controller;

import jakarta.servlet.http.HttpServletRequest;

public interface IImpostoStrategy {
	 HttpServletRequest calcImposto(HttpServletRequest request);
}
