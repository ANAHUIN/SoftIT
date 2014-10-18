package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="ClienteJPA.findAll", query="SELECT c FROM ClienteJPA c")
public class ClienteJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String clicod;

	private String clicor;

	private BigDecimal clicre;

	private String clidir;

	private String clinom;

	private String clitel;

	//bi-directional many-to-one association to FacCabeJPA
	@OneToMany(mappedBy="cliente")
	private List<FacCabeJPA> facCabes;

	public ClienteJPA() {
	}

	public String getClicod() {
		return this.clicod;
	}

	public void setClicod(String clicod) {
		this.clicod = clicod;
	}

	public String getClicor() {
		return this.clicor;
	}

	public void setClicor(String clicor) {
		this.clicor = clicor;
	}

	public BigDecimal getClicre() {
		return this.clicre;
	}

	public void setClicre(BigDecimal clicre) {
		this.clicre = clicre;
	}

	public String getClidir() {
		return this.clidir;
	}

	public void setClidir(String clidir) {
		this.clidir = clidir;
	}

	public String getClinom() {
		return this.clinom;
	}

	public void setClinom(String clinom) {
		this.clinom = clinom;
	}

	public String getClitel() {
		return this.clitel;
	}

	public void setClitel(String clitel) {
		this.clitel = clitel;
	}

	public List<FacCabeJPA> getFacCabes() {
		return this.facCabes;
	}

	public void setFacCabes(List<FacCabeJPA> facCabes) {
		this.facCabes = facCabes;
	}

	public FacCabeJPA addFacCabe(FacCabeJPA facCabe) {
		getFacCabes().add(facCabe);
		facCabe.setCliente(this);

		return facCabe;
	}

	public FacCabeJPA removeFacCabe(FacCabeJPA facCabe) {
		getFacCabes().remove(facCabe);
		facCabe.setCliente(null);

		return facCabe;
	}

}