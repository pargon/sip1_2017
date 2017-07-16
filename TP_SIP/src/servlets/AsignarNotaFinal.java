package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ControladorGrupos;

@WebServlet("/AsignarNotaFinal")
public class AsignarNotaFinal extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int nroGrupo = Integer.valueOf( req.getParameter("nroGrupo"));
		int valueNota=Integer.parseInt(req.getParameter("valueNota"));
		ControladorGrupos.getInstancia().puntuarNotaFinal(nroGrupo, valueNota);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	
}