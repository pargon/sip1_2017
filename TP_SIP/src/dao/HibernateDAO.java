package dao;

import java.util.List;

import hbt.HibernateUtil;
import negocio.Grupo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


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

	public List<?> getList(String sql){
		Session s = getSesion();
		return s.createQuery(sql).list();
	}

	public void persistir(Object c) {
		Session session = null;
        Transaction tx = null;
        try {
        	session = sf.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(c);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (!tx.wasCommitted()) {
                tx.rollback();
            }
            session.flush();
            session.close();
        }
	}

	public Grupo buscarGrupoPorNumero(int nroGrupo) {
		Session session = null;
        Transaction tx = null;
        Grupo grupo = null;
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            grupo = (Grupo) session.createQuery("from Grupo where nroGrupo = :nro")
                    .setInteger("nro", nroGrupo).uniqueResult();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (!tx.wasCommitted()) {
                tx.rollback();
            }
            session.flush();
            session.close();
        }
        return grupo;
	}
	
}
