package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EntregableGrupoDTO;
import dto.GrupoDTO;
import dto.NumGrupoDTO;
import app.ControladorEntregables;
import app.ControladorGrupos;

@WebServlet("/VerEntregables")
public class VerEntregables extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String valor = req.getParameter("action");
		String destino = "VerEstructura.jsp";
		
		List<NumGrupoDTO> grupos = ControladorGrupos.getInstancia().getNrosGrupos();
		req.setAttribute("grupos", grupos);
			
		RequestDispatcher rd = req.getRequestDispatcher(destino);
		rd.forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}	
}