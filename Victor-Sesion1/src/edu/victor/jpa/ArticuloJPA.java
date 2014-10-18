package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the articulos database table.
 * 
 */
@Entity
@Table(name="articulos")
@NamedQuery(name="ArticuloJPA.findAll", query="SELECT a FROM ArticuloJPA a")
public class ArticuloJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String artcod;

	private String artnom;

	private BigDecimal artpre;

	private int artstk;

	private String artuni;

	//bi-directional many-to-one association to MarcaJPA
	@ManyToOne
	@JoinColumn(name="idmarca")
	private MarcaJPA marca;

	//bi-directional many-to-one association to FacDetaJPA
	@OneToMany(mappedBy="articulo")
	private List<FacDetaJPA> facDetas;

	public ArticuloJPA() {
	}

	public String getArtcod() {
		return this.artcod;
	}

	public void setArtcod(String artcod) {
		this.artcod = artcod;
	}

	public String getArtnom() {
		return this.artnom;
	}

	public void setArtnom(String artnom) {
		this.artnom = artnom;
	}

	public BigDecimal getArtpre() {
		return this.artpre;
	}

	public void setArtpre(BigDecimal artpre) {
		this.artpre = artpre;
	}

	public int getArtstk() {
		return this.artstk;
	}

	public void setArtstk(int artstk) {
		this.artstk = artstk;
	}

	public String getArtuni() {
		return this.artuni;
	}

	public void setArtuni(String artuni) {
		this.artuni = artuni;
	}

	public MarcaJPA getMarca() {
		return this.marca;
	}

	public void setMarca(MarcaJPA marca) {
		this.marca = marca;
	}

	public List<FacDetaJPA> getFacDetas() {
		return this.facDetas;
	}

	public void setFacDetas(List<FacDetaJPA> facDetas) {
		this.facDetas = facDetas;
	}

	public FacDetaJPA addFacDeta(FacDetaJPA facDeta) {
		getFacDetas().add(facDeta);
		facDeta.setArticulo(this);

		return facDeta;
	}

	public FacDetaJPA removeFacDeta(FacDetaJPA facDeta) {
		getFacDetas().remove(facDeta);
		facDeta.setArticulo(null);

		return facDeta;
	}

}