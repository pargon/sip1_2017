package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ControladorEntregables;
import dto.EntregableGrupoDTO;

@WebServlet("/EvolucionTP")
public class EvolucionTP extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out;
		
		out = resp.getWriter();
		int nroGrupo = Integer.parseInt( req.getParameter("nroGrupo"));
		String fEntrega = (String) req.getParameter("fentrega");
		String iter = (String) req.getParameter("iter");
		String etapa = (String) req.getParameter("etapa");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		/*Date dateEntrega = null;
		
		try {
			dateEntrega = formatter.parse(fEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<EntregableGrupoDTO> le = ControladorEntregables.getInstancia().lineasTablaDeGrupo(nroGrupo, null, "", "");
		
		out.print(
				
				"<table>"
				+ "<thead>"
				+ "<th>Nro Grupo</th>"
				+ "</thead>"
				+ "<tbody>"
				
			
			);
		
		for (EntregableGrupoDTO entregableGrupoDTO : le) {
			out.print(
					
						"<tr>"
					+	"<td>" + entregableGrupoDTO.getNombreEntregable()
					+	"</td>"
					+	"</tr>"
					
					
					);
		}
		
		out.print(
				
				"</tbody>"
			+	"</table>"
			
			);
		
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	
}