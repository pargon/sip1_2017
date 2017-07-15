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

@WebServlet("/AsignarNota")
public class AsignarNota extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int nroGrupo = Integer.valueOf( req.getParameter("nroGrupo"));
		int lu = Integer.valueOf( req.getParameter("lu"));
		String tipoNota =req.getParameter("tipoNota");
		String valueNota=req.getParameter("valueNota");
		
		switch(tipoNota)
		{
		case "notaA":
				 ControladorGrupos.getInstancia().puntuarNotaA(nroGrupo, lu, valueNota);
				 break;
		case "notaB":
			 ControladorGrupos.getInstancia().puntuarNotaB(nroGrupo, lu,valueNota );
			 break;
//		case "notaFinal":
//			 ControladorGrupos.getInstancia().puntuarNotaFinal(nroGrupo, Integer.parseInt(req.getParameter("valueNota")));
//			 break;
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	
}