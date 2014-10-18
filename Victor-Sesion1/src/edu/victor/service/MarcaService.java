package edu.victor.service;

import java.util.List;

import edu.victor.jpa.MarcaJPA;

public interface MarcaService {

	public abstract List<MarcaJPA> listaMarca()throws Exception;
	
}
