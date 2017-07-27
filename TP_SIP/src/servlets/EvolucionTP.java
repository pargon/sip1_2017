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
public class EvolucionTP extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out;

		out = resp.getWriter();
		int nroGrupo = Integer.parseInt(req.getParameter("nroGrupo"));


		List<EntregableGrupoDTO> le = ControladorEntregables.getInstancia().lineasTablaDeGrupo(nroGrupo, "", "", "");
		
		out.print(

				"<table id=\"my-table\" class=\"table table-striped table-responsive\">" + "<thead>"
						+ "<th><strong>Iteración</strong></th>" + "<th><strong>Etapa</strong></th>"
						+ "<th><strong>Entregable</strong></th>" + "<th><strong>Fecha carga</strong></th>"
						+ "<th><strong>Fecha a entregar</strong></th>" + "<th><strong>Estado</strong></th>"
						+ "<th><strong>Observaciones</strong></th>" + "<th><strong>Fecha Observación</strong></th>"
						+ "<th><strong>Archivo</strong></th>" + "<th><strong></strong></th>"
						+ "</thead>" + "<tbody>"

		);

		for (EntregableGrupoDTO entregableGrupoDTO : le) {
			out.print(

					"<tr id=\"" + entregableGrupoDTO.getIdEntregable() + "\">" + "<td>"
							+ entregableGrupoDTO.getNombreIteracion() + "</td>" + "<td>"
							+ entregableGrupoDTO.getNombreEtapa() + "</td>" + "<td>"
							+ entregableGrupoDTO.getNombreEntregable() + "</td>" + "<td>"
							+ entregableGrupoDTO.getFechaCarga() + "</td>" + "<td>"
							+ entregableGrupoDTO.getFechaEntrega() + "</td>" + "<td>" + entregableGrupoDTO.getEstado()
							+ "</td>" + "<td>" + entregableGrupoDTO.getComentario() + "</td>" + "<td>"
							+ entregableGrupoDTO.getFechaObs() + "</td>" + "<td><a href=" + "\"#\"" + ">"
							+ entregableGrupoDTO.getNombreArchivo() + "</a></td>" + "<td>"
							+ "<td class=\"text-center\">\n"
							+ "											<div class=\"dropdown\">\n"
							+ "												<button class=\"btn btn-info dropdown-toggle\" type=\"button\"\n"
							+ "													data-toggle=\"dropdown\">\n"
							+ "													Acciones <span class=\"caret\"></span>\n"
							+ "												</button>\n"
							+ "												<ul class=\"dropdown-menu\">\n"
							+ "													<li><a class=\"addObs\">Agregar\n"
							+ "															Observacion</a></li>\n"
							+ "													<li><a class=\"editObs\">Editar\n"
							+ "															Observacion</a></li>\n"
							+ "													<li><a class=\"setSts\">Editar Estado del\n"
							+ "															Entregable</a></li>\n"
							+ "													<li><a class=\"verHistorialObs\">Ver Historial\n"
							+ "															De Observaciones</a></li>\n"
							+ "													<li><a class=\"setFechaEntrega\">Cambiar Fecha de Entrega</a></li>\n"
							+ "												</ul>\n"
							+ "											</div>\n"
							+ "										</td>" + "</tr>"

			);
		}

		out.print(

				"</tbody>" + "</table>"

		);

		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}