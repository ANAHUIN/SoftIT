package edu.victor.service;

import java.util.List;

import edu.victor.factory.DAOFactory;
import edu.victor.jpa.MarcaJPA;

public class MarcaImplementacion implements MarcaService{

	DAOFactory factory = DAOFactory.getFactory(1);
	MarcaService dao= factory.getMarcaService();
	
	@Override
	public List<MarcaJPA> listaMarca() throws Exception {
		// TODO Auto-generated method stub
		return dao.listaMarca();
	}

}
