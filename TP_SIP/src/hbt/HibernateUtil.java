package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import negocio.*;



public class HibernateUtil
{
	private static final SessionFactory sessionFactory;

	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Alumno.class);
			config.addAnnotatedClass(Archivo.class);
			config.addAnnotatedClass(Docente.class);
			config.addAnnotatedClass(DocumentoFinal.class);
			config.addAnnotatedClass(Entregable.class);
			config.addAnnotatedClass(EntregableEstructura.class);
			config.addAnnotatedClass(Etapa.class);
			config.addAnnotatedClass(Grupo.class);
			config.addAnnotatedClass(Iteracion.class);
			config.addAnnotatedClass(ObservacionEntregable.class);
			config.addAnnotatedClass(ObservacionFinal.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
