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
		
		/*Date dateEntrega = null;
		
		try {
			dateEntrega = formatter.parse(fEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<EntregableGrupoDTO> le = ControladorEntregables.getInstancia().lineasTablaDeGrupo(nroGrupo, null, "", "");
		
		
		out.print(
				
				"<table id=\"my-table\" class=\"table table-striped\">"
				+"<thead>"
				+"<th><strong>Iteración</strong></th>"
				+"<th><strong>Etapa</strong></th>"
				+"<th><strong>Entregable</strong></th>"
				+"<th><strong>Fecha carga</strong></th>"
				+"<th><strong>Fecha a entregar</strong></th>"
				+"<th><strong>Estado</strong></th>"
				+"<th><strong>Observaciones</strong></th>"
				+"<th><strong>Fecha Observación</strong></th>"
				+"<th><strong>Archivo</strong></th>"
				+"<th><strong></strong></th>"
				+"<th><strong></strong></th>"
				+"<th><strong></strong></th>"
				+"<th><strong></strong></th>"
				+"<th><strong></strong></th>"
				+"</thead>"
				+"<tbody>"
				
			
			);
		
		for (EntregableGrupoDTO entregableGrupoDTO : le) {
			out.print(
					
						"<tr id=\""+ entregableGrupoDTO.getIdEntregable() +"\">" 
					+	"<td>" + entregableGrupoDTO.getNombreIteracion()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getNombreEtapa()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getNombreEntregable()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getFechaCarga()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getFechaEntrega()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getEstado()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getComentario()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getFechaObs()
					+	"</td>"
					+	"<td>" + entregableGrupoDTO.getRutaArchivo()
					+	"</td>"
					+	"<td>"
					+	"<button type=\"button\" class=\"btn addObs\">Agregar Observacion\n"
					+	"</button>"
					+	"</td>"
					+	"<td>"
					+	"<button type=\"button\" class=\"btn editObs\">Editar Observacion\n"
					+	"</button>"
					+	"</td>"
					+	"<td>"
					+	"<button type=\"button\" class=\"btn setSts\">Estado Entregable\n"
					+	"</button>"
					+	"</td>"
					+	"<td>"
					+	"<button type=\"button\" class=\"btn editFecEnt\">Ver Historial Obs.\n"
					+	"</button>"
					+	"</td>"
					+	"<td>"
					+	"<button type=\"button\" class=\"btn editFecEnt\">Cambiar F.A Entregar\n"
					+	"</button>"
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