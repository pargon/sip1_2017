package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ControladorGrupos;

@WebServlet("/AdmGrupo")
public class AdmGrupo extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String destino = "/inicio.jsp";
		
		ControladorGrupos ct = new ControladorGrupos();
		int nroGrupo = Integer.valueOf( req.getParameter("nrogrupo"));
		int lu = Integer.valueOf( req.getParameter("lu"));
		String notaA = (String) req.getParameter("valnotaA");
		String notaB = (String) req.getParameter("valnotaB");
		String notaFin = (String) req.getParameter("valnotafinal");
		int notaFinal = Integer.valueOf(notaFin);
				
		ct.puntuarNotaA(nroGrupo, lu, notaA);
		ct.puntuarNotaB(nroGrupo, lu, notaB);
		ct.puntuarNotaFinal(nroGrupo, notaFinal);
		
		RequestDispatcher rd = req.getRequestDispatcher(destino);
		rd.forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	
}