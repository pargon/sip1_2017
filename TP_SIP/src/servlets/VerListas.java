package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerListas")
public class VerListas extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
/*		
		String valor = req.getParameter("action");
		String destino = "inicio.jsp";
		BD bd = new BD();		
		bd.LookUPServ();
		

		switch(valor ){
		case "VerCli":{
			
			List<ClienteVO> lc = bd.ListarClientes();
			req.setAttribute("listcli", lc);
			destino = "VerClientes.jsp";
			break;}
		
		case "VerVeh":{
			destino = "VerVehiculos.jsp";
			break;}
		
		case "VerRep":{
			
			destino = "VerRepuestos.jsp";
			break;}
	
		case "NvaRepa":{
			
			List<ClienteVO> lc = bd.ListarClientes();
			req.setAttribute("listcli", lc);
			
			List<VehiculoVO> lv = bd.ListarVehiculos();
			req.setAttribute("listveh", lv);

			destino = "NuevaRepa.jsp";
			break;}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(destino);
		rd.forward(req, resp);
*/		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

	
}
