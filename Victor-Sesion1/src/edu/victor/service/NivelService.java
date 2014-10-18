package edu.victor.service;

import java.util.List;

import edu.victor.jpa.NivelJPA;

public interface NivelService {
	
	public abstract String eliminarNivel(NivelJPA objNJPA )throws Exception;
	public abstract List<NivelJPA> listaNivel()throws Exception;
	public abstract String altaNivel(NivelJPA objNJPA )throws Exception;

}
