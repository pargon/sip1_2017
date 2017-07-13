package dao;

import java.util.List;

import hbt.HibernateUtil;
import negocio.Grupo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateDAO {

	private Session ses;
	private static SessionFactory sf;
	private static HibernateDAO instancia = null;
	
	public HibernateDAO (){
		if(sf == null)
			sf = HibernateUtil.getSessionFactory();
	}
	
	public static HibernateDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateDAO();
		} 
		return instancia;
	}
	
	private Session getSesion(){
		if(ses == null)
			ses = sf.openSession();
		return ses;
	}
	
	public List<?> getList2(String sql, String prm, Object obj){
		Session s = getSesion();
		return s.createQuery(sql).setParameter(prm, obj).list();
		
	}

	public Object getUnique(String sql, String prm, Object obj){
		Session s = getSesion();
		return s.createQuery(sql).setParameter(prm, obj).uniqueResult();
		
	}
	
	public List<?> getList(String sql){
		Session s = getSesion();
		return s.createQuery(sql).list();
	}

	public void persistir(Object c) {
		Session s = getSesion();
		s.beginTransaction();
		s.saveOrUpdate(c);
		s.getTransaction().commit();
	}
	
	
	public Grupo buscarGrupoPorNumero(int nroGrupo) {
		
        
        String sql = "from Grupo where nroGrupo = :nro";
        String prm = "nro";
        Integer obj = Integer.valueOf(nroGrupo);
        Grupo g = (Grupo) getUnique(sql, prm, obj);
        return g;
	}
	
}
