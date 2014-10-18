package edu.victor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sun.font.CreatedFontTracker;
import edu.victor.jpa.UsuarioJPA;
import edu.victor.service.UsuarioService;
import edu.victor.util.Conexion;

public class UsuarioDAO implements UsuarioService{

	EntityManagerFactory emf;
	EntityManager em;
	
	public void Open(){
		emf=Persistence.createEntityManagerFactory("Victor-Sesion1");
		em=emf.createEntityManager();
	}
	
	public void Close(){
		em.close();
		emf.close();
	
	}
	
	public UsuarioJPA buscarUsuario(UsuarioJPA objusu) throws Exception {
		UsuarioJPA obj=null;
		
		Open();
		try {
			obj=em.find(UsuarioJPA.class,objusu.getUsernom());
				
		} catch (Exception e) {
			System.out.println("Error DAO buscarUsuario " + e.getMessage());
		}finally{
			Close();
		}
		return obj;
	}

	@Override
	public String altaUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";
		
		try {
			Open();
			em.getTransaction().begin();
			em.persist(objusu);
			em.getTransaction().commit();
			msg="Se grabo exitosamente";
		} catch (Exception e) {
			System.out.println("Error DAO altaUsuario " + e.getMessage());
			em.getTransaction().rollback();
		}finally{
			Close();
		}
		return  msg;
	}

	@Override
	public String eliminarUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";
		try {
			Open();
			UsuarioJPA obj= new UsuarioJPA();
			obj=em.find(UsuarioJPA.class,objusu.getUsernom());
			if(obj!=null){
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			msg="si";
			}
			
		} catch (Exception e) {
			System.out.println("Error UsuarioDAO " + e.getMessage());
			em.getTransaction().rollback();
		}finally{
			Close();
		}
		return  msg;
	}

	@Override
	public List<UsuarioJPA> listaUsuario() throws Exception {
		 List<UsuarioJPA> lista=null;
			Open();
		 try {
		
			Query q=em.createQuery("SELECT u FROM UsuarioJPA u");
			lista=q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO"+e.getMessage());
		}finally{
			Close();
		}
		return lista;
	}

	@Override
	public String modificarUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";		
		try {
			Open();
			em.getTransaction().begin();
			em.merge(objusu);
			em.getTransaction().commit();
			msg="Se grabo exitosamente";
		} catch (Exception e) {
			System.out.println("Error UsuarioDAO " + e.getMessage());
			em.getTransaction().rollback();
		}finally{
			Close();
		}
		return  msg;
	}

	
	
}
