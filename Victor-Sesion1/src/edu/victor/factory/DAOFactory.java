package edu.victor.factory;

import edu.victor.service.ArticuloService;
import edu.victor.service.MarcaService;
import edu.victor.service.NivelService;
import edu.victor.service.UsuarioService;

public abstract class DAOFactory {
	
	public static final int MYSQL=1;
	public static final int JPA=2;
	
	public abstract UsuarioService getUsuarioService();
	public abstract NivelService getNivelService();
	public abstract ArticuloService getArticuloService();
	public abstract MarcaService getMarcaService();
	
	public static DAOFactory getFactory(int tipoTecnologia){
		
		switch (tipoTecnologia) {
		case 1:
			  return new MysqlDAOFactory();
	
		}
		return null;
	}

}
