package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.HibernateDAO;
import negocio.Alumno;
import negocio.Docente;
import negocio.EntregableEstructura;
import negocio.Etapa;
import negocio.Grupo;
import negocio.Iteracion;

public class Controlador {

	private List<Grupo> grupos;
	private List<Alumno> alumnos;
	private List<Iteracion> iteraciones;
	private List<Docente> docentes;
	
	public Controlador() {
		alumnos = new ArrayList<Alumno>();
		iteraciones = new ArrayList<Iteracion>();
		docentes = new ArrayList<Docente>();
		
		testClases();
	}

	private void testClases() {

		testDocentes();
		testAlumnos();
		testIteraciones();
		testGrupos();
		
		testListaEstructura();
	}

	private void testListaEstructura() {

		System.out.println("Iter 1");
		listarIter(1);
		System.out.println("Iter 2");
		listarIter(2);
		System.out.println("Iter 3");
		listarIter(3);
	}

	private void listarIter(int i) {
		String sql = "select iter.nombre, eta.nombre, ent.nombre  from Iteracion iter join iter.etapas eta join eta.entregablesEstruc ent where iter.id =:iditer  ";
		String prm = "iditer";
		Integer iditer = i;
		
		List<Object[]> lista = (List<Object[]>) HibernateDAO.getInstancia().getList2(sql, prm, iditer);
		for (Object[] o : lista)
			System.out.println("\t[" + o[0] + " - " +o[1]+ " - " +o[2]+"]");
				

		
	}

	private void testGrupos() {
		// TODO Auto-generated method stub
		Grupo gru;
		
		gru = new Grupo();
		gru.setEstadoTP("Trabajando");
		gru.setIntegrantes(alumnos);
		gru.setNroGrupo(12);
		gru.setTituloTP("tp nuevo");
		HibernateDAO.getInstancia().persistir(gru);
		
	}

	private void testAlumnos() {
		Alumno alu;
		
		alu = new Alumno();		
		alu.setApellido("Juarez");
		alu.setNombre("Roman");
		alu.setLu(1234233);
		
		alumnos.add(alu);
		HibernateDAO.getInstancia().persistir(alu);
		
		alu = new Alumno();		
		alu.setApellido("Sanchez");
		alu.setNombre("Armando");
		alu.setLu(3233423);
		
		alumnos.add(alu);
		HibernateDAO.getInstancia().persistir(alu);
		
		alu = new Alumno();		
		alu.setApellido("Gomez");
		alu.setNombre("Aldo");
		alu.setLu(238723);
		
		alumnos.add(alu);
		HibernateDAO.getInstancia().persistir(alu);
	}

	private void testDocentes() {
		Docente doc;
		
		doc = new Docente();
		doc.setApellido("Rojo");
		doc.setNombre("Silvana");
		doc.setLegajo(12982);
		
		docentes.add(doc);		
		HibernateDAO.getInstancia().persistir(doc);
		
		doc = new Docente();
		doc.setApellido("Sardi");
		doc.setNombre("Florencia");
		doc.setLegajo(13982);
		
		docentes.add(doc);
		HibernateDAO.getInstancia().persistir(doc);
	}
	
	private void testIteraciones() {
		// TODO Auto-generated method stub
		
		testIter("iter 1", 1);
		testIter("iter 2", 2);
		testIter("iter 3", 3);
	}

	private void testIter(String string, int i) {
		// TODO Auto-generated method stub
		
		Iteracion iter ;
		
		iter = new Iteracion();
		iter.setNombre(string);
		iter.setNroOrden(i);
		HibernateDAO.getInstancia().persistir(iter);		
		
		List<Etapa> listEta = new ArrayList<Etapa>();
		Etapa eta;
		
		eta = testEtapa("eta 1", 1);
		eta.setIteracion(iter);
		listEta.add(eta);
		
		eta = testEtapa("eta 2", 2);
		eta.setIteracion(iter);
		listEta.add(eta);

		eta = testEtapa("eta 3", 3);
		eta.setIteracion(iter);
		listEta.add(eta);

		iter.setEtapas(listEta);
		
		iteraciones.add(iter);
		// otra vez se guarda con los cambios
		HibernateDAO.getInstancia().persistir(iter);		
	}

	private Etapa testEtapa(String string, int i) {
		Etapa eta;
		
		eta = new Etapa();
		eta.setNombre(string);
		eta.setNroOrden(i);
		HibernateDAO.getInstancia().persistir(eta);		

		List<EntregableEstructura> listEnt = new ArrayList<EntregableEstructura>();
		
		EntregableEstructura ent;

		ent = new EntregableEstructura();
		ent.setFechaEntrega(new Date());
		ent.setNombre("entregable A");
		ent.setNroOrden(1);
		HibernateDAO.getInstancia().persistir(ent);		
		ent.setEtapa(eta);
		listEnt.add(ent);
		
		ent = new EntregableEstructura();
		ent.setFechaEntrega(new Date());
		ent.setNombre("entregable B");
		ent.setNroOrden(2);
		HibernateDAO.getInstancia().persistir(ent);		
		ent.setEtapa(eta);
		listEnt.add(ent);
		
		ent = new EntregableEstructura();
		ent.setFechaEntrega(new Date());
		ent.setNombre("entregable C");
		ent.setNroOrden(3);
		HibernateDAO.getInstancia().persistir(ent);		
		ent.setEtapa(eta);
		listEnt.add(ent);

		eta.setEntregablesEstruc(listEnt);
		// se guarda nuevamente con los cambios
		HibernateDAO.getInstancia().persistir(eta);		

		return eta;
	}
	
	public List<Grupo> getGrupos(){
		List<Grupo> grupos = HibernateDAO.GetInstancia().getList("from grupo");
		return grupos;
	}
	
	public List<Entregable> getEntregablesPorIteracion(int iteracion, int nGrupo){
		List<Entregable> entregables = HibernateDAO.GetInstancia().getList(
				"from entregable e where e.entregableestructura.etapa.iteracion.nroOrden = " + iteracion +
				" and entregable.grupo.nroGrupo = " + nGrupo);
		return entregables;
	}
}
