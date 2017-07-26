package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ControladorEntregables;
import app.ControladorGrupos;
import dto.GrupoDTO;
import dto.NumGrupoDTO;

@WebServlet("/VerGrupos")
public class VerGrupos extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String valor = req.getParameter("action");
		String destino = "index.jsp";
		
		List<GrupoDTO> lgt = ControladorGrupos.getInstancia().getGrupos();
		req.setAttribute("listgrupo", lgt);
		destino = "VerGrupos.jsp";
		
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