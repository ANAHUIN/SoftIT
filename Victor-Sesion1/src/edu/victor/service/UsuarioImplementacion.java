package edu.victor.service;

import java.util.List;

import edu.victor.factory.DAOFactory;
import edu.victor.jpa.UsuarioJPA;

public class UsuarioImplementacion implements UsuarioService{
 
		DAOFactory factory=DAOFactory.getFactory(1);
		UsuarioService dao=factory.getUsuarioService();
	
	
	@Override
	public UsuarioJPA buscarUsuario(UsuarioJPA objusu) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarUsuario(objusu);
	}


	@Override
	public String altaUsuario(UsuarioJPA objusu) throws Exception {
		return dao.altaUsuario(objusu);
		
	}


	@Override
	public String eliminarUsuario(UsuarioJPA objusu) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminarUsuario(objusu);
	}


	@Override
	public List<UsuarioJPA> listaUsuario() throws Exception {
		// TODO Auto-generated method stub
		return dao.listaUsuario();
	}


	@Override
	public String modificarUsuario(UsuarioJPA objusu) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificarUsuario(objusu);
	}

}
