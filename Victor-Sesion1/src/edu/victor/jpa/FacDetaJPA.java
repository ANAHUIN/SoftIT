package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fac_deta database table.
 * 
 */
@Entity
@Table(name="fac_deta")
@NamedQuery(name="FacDetaJPA.findAll", query="SELECT f FROM FacDetaJPA f")
public class FacDetaJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int facid;

	private int artcant;

	//bi-directional many-to-one association to FacCabeJPA
	@ManyToOne
	@JoinColumn(name="facnum")
	private FacCabeJPA facCabe;

	//bi-directional many-to-one association to ArticuloJPA
	@ManyToOne
	@JoinColumn(name="artcod")
	private ArticuloJPA articulo;

	public FacDetaJPA() {
	}

	public int getFacid() {
		return this.facid;
	}

	public void setFacid(int facid) {
		this.facid = facid;
	}

	public int getArtcant() {
		return this.artcant;
	}

	public void setArtcant(int artcant) {
		this.artcant = artcant;
	}

	public FacCabeJPA getFacCabe() {
		return this.facCabe;
	}

	public void setFacCabe(FacCabeJPA facCabe) {
		this.facCabe = facCabe;
	}

	public ArticuloJPA getArticulo() {
		return this.articulo;
	}

	public void setArticulo(ArticuloJPA articulo) {
		this.articulo = articulo;
	}

}