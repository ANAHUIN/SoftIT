package edu.victor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.Query;

import edu.victor.jpa.MarcaJPA;
import edu.victor.service.MarcaService;

public class MarcaDAO implements MarcaService {
	
	 private EntityManagerFactory emf; 
	 private EntityManager em;
	 
	 public void open(){
		 emf=Persistence.createEntityManagerFactory("Victor-Sesion1");
		 em=emf.createEntityManager();
	 }
	 public void close(){
		 em.close();
		 emf.close();
	 }
	 
	 
	@Override
	public List<MarcaJPA> listaMarca() throws Exception {
		List<MarcaJPA> lista= null;
		try {
			open();
			Query q= em.createQuery("Select m from MarcaJPA m");
			lista=q.getResultList();
		} catch (Exception e) {
			System.out.println("Error de Dao listaMarca "+ e.getMessage());
		}finally{
			close();
		}
		
		return lista;
	}
	


}
