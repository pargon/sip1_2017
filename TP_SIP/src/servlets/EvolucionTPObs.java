package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.ControladorEntregables;

@WebServlet("/EvolucionTPObs")
public class EvolucionTPObs extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String destino = "/VerEstructura.jsp";
		
		
		int idEntregable = Integer.valueOf( req.getParameter("idEntregable"));
		String Observacion = (String) req.getParameter("obs");
				
		ControladorEntregables.getInstancia().agregarObsEntregable(idEntregable, Observacion);
		
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