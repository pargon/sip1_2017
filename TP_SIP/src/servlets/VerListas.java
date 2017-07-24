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
import app.ControladorEntregables;
import app.ControladorGrupos;

@WebServlet("/VerListas")
public class VerListas extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String valor = req.getParameter("action");
		String destino = "inicio.jsp";
		
		
		
		switch(valor ){
		case "VerGrupos":{

			List<GrupoDTO> lgt = ControladorGrupos.getInstancia().getGrupos();
			req.setAttribute("listgrupo", lgt);
			destino = "VerGrupos.jsp";
			break;}
		
		case "VerEstruc":{
			
			List<GrupoDTO> grupos = ControladorGrupos.getInstancia().getGrupos();
			req.setAttribute("grupos", grupos);
			destino = "VerEstructura.jsp";
			
			break;}		
		}
		
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