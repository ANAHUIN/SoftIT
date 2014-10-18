package edu.victor.service;

import java.util.List;

import edu.victor.dao.ArticuloDAO;
import edu.victor.factory.DAOFactory;
import edu.victor.jpa.ArticuloJPA;

public class ArticuloImplementacion implements ArticuloService {
	DAOFactory factory = DAOFactory.getFactory(1);
	ArticuloService dao= factory.getArticuloService();
	@Override
	public List<ArticuloJPA> listaArticulos() throws Exception {
		// TODO Auto-generated method stub
	return dao.listaArticulos();
	}
	@Override
	public String altaArticulos(ArticuloJPA obja) throws Exception {
		
	return	dao.altaArticulos(obja);
	}
	@Override
	public String modificarArticulo(ArticuloJPA obja) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificarArticulo(obja);
	}
	@Override
	public ArticuloJPA buscarArticulo(ArticuloJPA obja) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarArticulo(obja);
	}

}
