package edu.victor.factory;

import edu.victor.dao.ArticuloDAO;
import edu.victor.dao.MarcaDAO;
import edu.victor.dao.NivelDAO;
import edu.victor.dao.UsuarioDAO;
import edu.victor.service.ArticuloService;
import edu.victor.service.MarcaService;
import edu.victor.service.NivelService;
import edu.victor.service.UsuarioService;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public UsuarioService getUsuarioService() {
		// TODO Auto-generated method stub
		return new UsuarioDAO();
	}

	@Override
	public NivelService getNivelService() {
		// TODO Auto-generated method stub
		return new NivelDAO();
	}

	@Override
	public ArticuloService getArticuloService() {
		// TODO Auto-generated method stub
		return new ArticuloDAO();
	}

	@Override
	public MarcaService getMarcaService() {
		// TODO Auto-generated method stub
		return new MarcaDAO();
	}
	
	

}
