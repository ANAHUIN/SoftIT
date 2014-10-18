package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marcas database table.
 * 
 */
@Entity
@Table(name="marcas")
@NamedQuery(name="MarcaJPA.findAll", query="SELECT m FROM MarcaJPA m")
public class MarcaJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idmarca;

	private String desmarca;

	//bi-directional many-to-one association to ArticuloJPA
	@OneToMany(mappedBy="marca")
	private List<ArticuloJPA> articulos;

	public MarcaJPA() {
	}

	public String getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}

	public String getDesmarca() {
		return this.desmarca;
	}

	public void setDesmarca(String desmarca) {
		this.desmarca = desmarca;
	}

	public List<ArticuloJPA> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<ArticuloJPA> articulos) {
		this.articulos = articulos;
	}

	public ArticuloJPA addArticulo(ArticuloJPA articulo) {
		getArticulos().add(articulo);
		articulo.setMarca(this);

		return articulo;
	}

	public ArticuloJPA removeArticulo(ArticuloJPA articulo) {
		getArticulos().remove(articulo);
		articulo.setMarca(null);

		return articulo;
	}

}