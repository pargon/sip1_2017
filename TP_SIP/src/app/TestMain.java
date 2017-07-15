package app;

import java.util.List;

import negocio.Alumno;
import negocio.Entregable;
import negocio.Grupo;
import dao.HibernateDAO;
import dto.EntregableGrupoDTO;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Controlador ctr = new Controlador();
		
		
		HibernateDAO.getInstancia().persistir(new Grupo(2,"Pachano"));
		
		Grupo grupo = ControladorEntregables.getInstancia().buscarGrupoPorNumero(2);
		if (grupo ==null)
			System.out.println("error grupo vacio");
		else{
			
		
		grupo.getIntegrantes().add(new Alumno(1020123,"Facundo","Arias",null,null));
		grupo.getIntegrantes().add(new Alumno(1212123,"Facundo","Arias",null,null));
		grupo.getIntegrantes().add(new Alumno(1231234,"Facundo","Arias",null,null));
		grupo.getEntregables().add(new Entregable());
		grupo.getEntregables().add(new Entregable());
		grupo.getEntregables().add(new Entregable());
		grupo.getEntregables().add(new Entregable());
		grupo.getEntregables().add(new Entregable());
		HibernateDAO.getInstancia().persistir(grupo);
		System.out.println(grupo.getEstadoTP()); 
		
		}
		
	}

}
