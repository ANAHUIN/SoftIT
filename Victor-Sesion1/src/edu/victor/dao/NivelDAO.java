package edu.victor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.victor.jpa.NivelJPA;
import edu.victor.service.NivelService;

public class NivelDAO implements NivelService {
		EntityManagerFactory emf;
		EntityManager em;
		
		public void open(){
			emf=Persistence.createEntityManagerFactory("Victor-Sesion1");
			em=emf.createEntityManager();
		}
		
		public void close(){
			em.close();
			emf.close();
		}
		
	@Override
	public String eliminarNivel(NivelJPA objNJPA) throws Exception {
		String mensaje="";
		try {
			NivelJPA obj= new NivelJPA();
			open();
			obj=em.find(NivelJPA.class,objNJPA.getIdnivel());
			if(obj!=null){
				em.getTransaction().begin();
				em.remove(obj);
				em.getTransaction().commit();
				mensaje="se elimino exitosamente";
			}
		} catch (Exception e) {
			System.out.println("Error de Eliminacion NivelDAO "+ e.getMessage());
			em.getTransaction().rollback();
		}finally{
			close();
		}
		
		return mensaje;
	}

	@Override
	public List<NivelJPA> listaNivel() throws Exception {
		List<NivelJPA> lista=null;
		try {
			open();
			Query q=em.createQuery("select n from NivelJPA n");
			lista=q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Error de lista NivelDAO " + e.getMessage());
		}finally{
			close();
		}
		
		return lista;
	}

	@Override
	public String altaNivel(NivelJPA objNJPA) throws Exception {
		String msg="";
		try {
			NivelJPA obj= new NivelJPA();
			open();
			obj.setIdnivel(objNJPA.getIdnivel());
			obj.setNiveldes(objNJPA.getNiveldes());
			if(obj!=null){
				em.getTransaction().begin();
				em.persist(obj);
				em.getTransaction().commit();
				msg="se grabo exitosamentes";
			}	
			
		} catch (Exception e) {
			System.out.println("Error de Alta Nivel DAO " + e.getMessage());
		}finally{
			close();
		}
		return msg;
	}

}
