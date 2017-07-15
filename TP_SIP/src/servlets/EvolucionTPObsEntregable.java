package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ObsEntregableDTO;
import app.ControladorEntregables;

@WebServlet("/EvolucionTPObsEntregable")
public class EvolucionTPObsEntregable extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String destino = "/VerEstructura.jsp";
		
		
		int idEntregable = Integer.valueOf( req.getParameter("idEntregable"));
				
		List<ObsEntregableDTO> loe = ControladorEntregables.getInstancia().listarObsDeEntregable(idEntregable);
		
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