package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EntregableGrupoDTO;
import app.ControladorEntregables;

@WebServlet("/EvolucionTP")
public class EvolucionTP extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String destino = "/VerEstructura.jsp";
		
		
		int nroGrupo = Integer.valueOf( req.getParameter("nrogrupo"));
		String fEntrega = (String) req.getParameter("fentrega");
		String iter = (String) req.getParameter("iter");
		String etapa = (String) req.getParameter("etapa");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateEntrega = null;
		
		try {
			dateEntrega = formatter.parse(fEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ControladorEntregables ct = new ControladorEntregables();
		List<EntregableGrupoDTO> le = ct.lineasTablaDeGrupo(nroGrupo, dateEntrega, iter, etapa);
		req.setAttribute("listevo", le);

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