package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.ControladorEntregables;
import dto.EntregableGrupoDTO;
import dto.ObsEntregableDTO;

@WebServlet("/EvolucionTPObsEntregable")
public class EvolucionTPObsEntregable extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out;
		out = resp.getWriter();

		int idEntregable = Integer.valueOf(req.getParameter("idEntregable"));

		List<ObsEntregableDTO> loe = ControladorEntregables.getInstancia().listarObsDeEntregable(idEntregable);

		out.print(

				"<table id=\"my-tableObs\" class=\"table table-striped table-responsive\">" + "<thead>"
						+ "<th><strong>Comentario</strong></th>" + "<th><strong>Fecha</strong></th></thead><tbody>"

		);

		for (ObsEntregableDTO obs : loe) {
			out.print(

					"<tr>" + "<td>" + obs.getComentario() + "</td>" + "<td>" + obs.getFecha() + "</td>" + "<td>" + "										</td>"
							+ "</tr>"

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