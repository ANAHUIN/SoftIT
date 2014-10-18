package edu.victor.jsf;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import edu.victor.jpa.NivelJPA;
import edu.victor.jpa.UsuarioJPA;
import edu.victor.service.UsuarioImplementacion;

public class UsuarioJSF {
	private String usernom;
	private String userpwd;
	private String nombre;
	private String correo;
	private String idnivel;
	
	private String mensaje;
	private int estado;
		
	private UsuarioImplementacion usuarioi= new UsuarioImplementacion();
	
	private DataModel<UsuarioJPA> usuariosmodel;
	
	
	public String validar() throws Exception{
			String inicio= "ERROR";
			UsuarioJPA obj= new UsuarioJPA();
		try {
				obj.setUsernom(getUsernom());
				obj=usuarioi.buscarUsuario(obj);
				if(obj.getUsernom().equals(getUsernom())&& obj.getUserpwd().equals(getUserpwd()))
					inicio="SUCCESS";
			
			} catch (Exception e) {
			System.out.println("Error de implementacion" +e.getMessage());
			}
				
		return inicio;
	}
	
	
	public void altaUsuario(ActionEvent e)throws Exception{
			String mensaje;
	
		try {
			UsuarioJPA obj = new UsuarioJPA();
			obj.setUsernom(getUsernom());
			obj.setUserpwd(getUserpwd());
			obj.setNombre(getNombre());
			obj.setCorreo(getCorreo());
			NivelJPA objn= new NivelJPA();
			objn.setIdnivel(getIdnivel());
			obj.setNivel(objn);
		  if(getEstado()==1)
		    mensaje=usuarioi.modificarUsuario(obj);
		  else
			mensaje=usuarioi.altaUsuario(obj);
		} catch (Exception e2) {
			System.out.println("Error en la implementacion de alta usuario" + e2.getMessage());
		}
		
		
	}
	
	public void eliminarUsuario(ActionEvent e)throws Exception{
		
			UsuarioJPA obj = new UsuarioJPA();
		try {
			obj.setUsernom(e.getComponent().getAttributes().get("unom").toString());
			
			usuarioi.eliminarUsuario(obj);
			
		} catch (Exception e2) {
			System.out.println("Error en la implementacion de eliminar" + e2.getMessage());
		}
	
		
	}
	
	
	public void buscar(ActionEvent e)throws Exception{
			UsuarioJPA obj= new UsuarioJPA();
		try {
			obj.setUsernom(e.getComponent().getAttributes().get("unom").toString());
			obj=usuarioi.buscarUsuario(obj);
			if(obj!=null){
				setUsernom(obj.getUsernom());
				setUserpwd(obj.getUserpwd());
				setNombre(obj.getNombre());
				setCorreo(obj.getCorreo());
				setIdnivel(obj.getNivel().getIdnivel());
				setEstado(1);
			}
		} catch (Exception e2) {
			System.out.println("Error de Implementaciones" +e2.getMessage());
		}
		
	}
	
	/*
	public void modificarUsuario(ActionEvent e) throws Exception{
		UsuarioJPA obj= new UsuarioJPA();
		try {					
			obj.setUsernom(getUsernom());
			obj.setUserpwd(getUserpwd());
			obj.setNombre(getNombre());
			obj.setCorreo(getCorreo());
			obj.setIdnivel(getIdnivel());
			mensaje=usuarioi.modificarUsuario(obj);		
			
		} catch (Exception e2) {
			System.out.println("Error de Implementacione11s" +e2.getMessage());
		}
	}
	*/
	
	public String getUsernom() {
		return usernom;
	}
	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public DataModel<UsuarioJPA> getUsuariosmodel() throws Exception {
		
		usuariosmodel=new ListDataModel<UsuarioJPA>(usuarioi.listaUsuario());
		
		return usuariosmodel;
	}


	public void setUsuariosmodel(DataModel<UsuarioJPA> usuariosmodel) {
		this.usuariosmodel = usuariosmodel;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
