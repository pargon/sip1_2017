package app;

import java.util.ArrayList;
import java.util.List;

import dao.HibernateDAO;

public class CtrGrupos {
	
	@SuppressWarnings("unchecked")
	public List<Integer> getGrupos() {
		// TODO Auto-generated method stub
		String sql = "select g.nroGrupo from Grupo g";
		return (List<Integer>) HibernateDAO.getInstancia().getList(sql);
		//List<Integer>lg = new ArrayList<Integer>();
		
			
	}
	
}
