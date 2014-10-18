package edu.victor.service;

import java.util.List;

import edu.victor.factory.DAOFactory;
import edu.victor.jpa.NivelJPA;

public class NivelImplementacion implements NivelService{
		DAOFactory factory= DAOFactory.getFactory(1);
		NivelService dao= factory.getNivelService();
	@Override
	public String eliminarNivel(NivelJPA objNJPA) throws Exception {
		
		return dao.eliminarNivel(objNJPA);
	}
	@Override
	public List<NivelJPA> listaNivel() throws Exception {
		// TODO Auto-generated method stub
		return dao.listaNivel();
	}
	@Override
	public String altaNivel(NivelJPA objNJPA) throws Exception {
		// TODO Auto-generated method stub
		return dao.altaNivel(objNJPA);
	}

}
