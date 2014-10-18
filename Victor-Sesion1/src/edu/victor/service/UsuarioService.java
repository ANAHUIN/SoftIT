package edu.victor.service;

import java.util.List;

import edu.victor.jpa.UsuarioJPA;

public interface UsuarioService {
	
	public abstract UsuarioJPA buscarUsuario(UsuarioJPA objusu) throws Exception;
	public abstract String altaUsuario(UsuarioJPA objusu) throws Exception;
	public abstract String eliminarUsuario(UsuarioJPA objusu)throws Exception;
	public abstract List<UsuarioJPA> listaUsuario()throws Exception;
	public abstract String modificarUsuario(UsuarioJPA objusu)throws Exception;
	

}
