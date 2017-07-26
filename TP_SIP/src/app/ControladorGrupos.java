package app;

import java.util.ArrayList;
import java.util.List;

import negocio.Grupo;
import dao.HibernateDAO;
import dto.GrupoDTO;
import dto.NumGrupoDTO;

public class ControladorGrupos {
	
	private static ControladorGrupos instancia;
	
	public ControladorGrupos(){}
	
	public static ControladorGrupos getInstancia(){
		if(instancia== null)
			instancia = new ControladorGrupos();
		return instancia;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<GrupoDTO> getGrupos() {
		
		String sql = "from Grupo";
		List<Grupo> lg = (List<Grupo>) HibernateDAO.getInstancia().getList(sql);
		List<GrupoDTO> lgd = new ArrayList<GrupoDTO>();
		
		for(Grupo i:lg){
			GrupoDTO gt = i.toDTO();
			lgd.add(gt);			
		}
		return lgd;
	}

	public void puntuarNotaA(int nroGrupo, int lu, String notaA) {
		
		// recupera objeto grupo desde la base
		Grupo g = ControladorEntregables.getInstancia().buscarGrupoPorNumero(nroGrupo);
		
		// setea la nota A al alumno 
		g.setNotaA(lu, notaA);
		
		// guarda en la base el objeto cambiado
		HibernateDAO.getInstancia().persistir(g);		
	}

	public void puntuarNotaB(int nroGrupo, int lu, String notaB) {
		// recupera objeto grupo desde la base
		Grupo g = ControladorEntregables.getInstancia().buscarGrupoPorNumero(nroGrupo);
		
		// setea la nota A al alumno 
		g.setNotaB(lu, notaB);
		
		// guarda en la base el objeto cambiado
		HibernateDAO.getInstancia().persistir(g);				
	}

	public void puntuarNotaFinal(int nroGrupo, int notaFinal) {
		// recupera objeto grupo desde la base
		Grupo g = ControladorEntregables.getInstancia().buscarGrupoPorNumero(nroGrupo);
		
		// setea la nota A al alumno 
		g.setNotaDocFinal(notaFinal);
		
		// guarda en la base el objeto cambiado
		HibernateDAO.getInstancia().persistir(g);						
	}
	
	@SuppressWarnings("unchecked")
	public List<NumGrupoDTO> getNrosGrupos() {
		
		// obtiene tupa de objetos
		String sql = "select g.id, g.nroGrupo from Grupo g order by g.nroGrupo";
		List<Object[]> lng = (List<Object[]>) HibernateDAO.getInstancia().getList(sql);
		
		// arma lista de dto
		List<NumGrupoDTO> nrosGrupos = new ArrayList<NumGrupoDTO>();
		for (Object[] o: lng){
			int id = (int) o[0];
			int nroGrupo = (int) o[1];
			
			NumGrupoDTO ngt = new NumGrupoDTO(nroGrupo, id) ;
			
			nrosGrupos.add(ngt);						
		}
		return nrosGrupos;
	}
}
