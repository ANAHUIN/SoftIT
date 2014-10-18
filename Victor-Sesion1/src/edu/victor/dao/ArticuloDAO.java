package edu.victor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.victor.jpa.ArticuloJPA;
import edu.victor.service.ArticuloService;

public class ArticuloDAO implements ArticuloService{
	EntityManagerFactory emf;
	EntityManager em;
	
	public void open(){
		emf= Persistence.createEntityManagerFactory("Victor-Sesion1");
		em= emf.createEntityManager();
	}
	
	public void close(){
		em.close();
		emf.close();
	}
		

	@Override
	public List<ArticuloJPA> listaArticulos() throws Exception {
		List<ArticuloJPA> lista = null;
		try {
			open();
			Query q = em.createQuery("Select a from ArticuloJPA a");
			lista=q.getResultList();
		} catch (Exception e) {
			System.out.println("Error de ArticuloDAO "+ e.getMessage());
		}finally{
			close();
		}
		
	
	return lista;	
	}

	@Override
	public String altaArticulos(ArticuloJPA obja) throws Exception {
		String msg="";
		try {
			open();
			em.getTransaction().begin();
			em.persist(obja);
			em.getTransaction().commit();
			msg="se dio de alta el articulo exitosamente";
		} catch (Exception e) {
			System.out.println("Error de Alta Articulos DAO "+ e.getMessage());
			em.getTransaction().rollback();
		}finally{
			close();
		}
		
		
		return msg;
	}

	@Override
	public String modificarArticulo(ArticuloJPA obja) throws Exception {
		String msg="";
		try {
			open();
			em.getTransaction().begin();
			em.merge(obja);
			em.getTransaction().commit();
			msg="se modifico exitosamente el articulo";
			
		} catch (Exception e) {
			System.out.println("Erro de moficaciarArticulo DAO " + e.getMessage());
			em.getTransaction().rollback();
		}finally{
			close();
		}
		return msg;
	}
	


	@Override
	public ArticuloJPA buscarArticulo(ArticuloJPA obja) throws Exception {
		ArticuloJPA obj= new ArticuloJPA();
		try {
			open();
			obj= em.find(ArticuloJPA.class, obja.getArtcod());
			
		} catch (Exception e) {
		System.out.println("Error Dao buscar Articulo" + e.getMessage());
		}finally{
			close();
		}
		
		
		return obj;
	}
	

}
