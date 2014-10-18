package edu.victor.service;

import java.util.List;

import edu.victor.jpa.ArticuloJPA;

public interface ArticuloService {

	public abstract List<ArticuloJPA> listaArticulos()throws Exception; 
	public abstract String altaArticulos(ArticuloJPA obja)throws	Exception;
	public abstract String modificarArticulo(ArticuloJPA obja)throws Exception;
	public abstract ArticuloJPA buscarArticulo(ArticuloJPA obja)throws Exception;
}
