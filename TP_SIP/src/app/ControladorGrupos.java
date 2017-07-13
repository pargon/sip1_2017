package app;

import java.util.ArrayList;
import java.util.List;

import negocio.Grupo;
import dao.HibernateDAO;
import dto.GrupoDTO;

public class ControladorGrupos {
	
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
	
}
