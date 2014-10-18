package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@Table(name="vendedor")
@NamedQuery(name="VendedorJPA.findAll", query="SELECT v FROM VendedorJPA v")
public class VendedorJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int vencod;

	@Temporal(TemporalType.TIMESTAMP)
	private Date venfig;

	private String vennom;

	//bi-directional many-to-one association to FacCabeJPA
	@OneToMany(mappedBy="vendedor")
	private List<FacCabeJPA> facCabes;

	public VendedorJPA() {
	}

	public int getVencod() {
		return this.vencod;
	}

	public void setVencod(int vencod) {
		this.vencod = vencod;
	}

	public Date getVenfig() {
		return this.venfig;
	}

	public void setVenfig(Date venfig) {
		this.venfig = venfig;
	}

	public String getVennom() {
		return this.vennom;
	}

	public void setVennom(String vennom) {
		this.vennom = vennom;
	}

	public List<FacCabeJPA> getFacCabes() {
		return this.facCabes;
	}

	public void setFacCabes(List<FacCabeJPA> facCabes) {
		this.facCabes = facCabes;
	}

	public FacCabeJPA addFacCabe(FacCabeJPA facCabe) {
		getFacCabes().add(facCabe);
		facCabe.setVendedor(this);

		return facCabe;
	}

	public FacCabeJPA removeFacCabe(FacCabeJPA facCabe) {
		getFacCabes().remove(facCabe);
		facCabe.setVendedor(null);

		return facCabe;
	}

}