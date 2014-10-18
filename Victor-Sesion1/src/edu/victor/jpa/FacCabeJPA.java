package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fac_cabe database table.
 * 
 */
@Entity
@Table(name="fac_cabe")
@NamedQuery(name="FacCabeJPA.findAll", query="SELECT f FROM FacCabeJPA f")
public class FacCabeJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String facnum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date facfec;

	private String facigv;

	//bi-directional many-to-one association to ClienteJPA
	@ManyToOne
	@JoinColumn(name="clicod")
	private ClienteJPA cliente;

	//bi-directional many-to-one association to VendedorJPA
	@ManyToOne
	@JoinColumn(name="vencod")
	private VendedorJPA vendedor;

	//bi-directional many-to-one association to FacDetaJPA
	@OneToMany(mappedBy="facCabe")
	private List<FacDetaJPA> facDetas;

	public FacCabeJPA() {
	}

	public String getFacnum() {
		return this.facnum;
	}

	public void setFacnum(String facnum) {
		this.facnum = facnum;
	}

	public Date getFacfec() {
		return this.facfec;
	}

	public void setFacfec(Date facfec) {
		this.facfec = facfec;
	}

	public String getFacigv() {
		return this.facigv;
	}

	public void setFacigv(String facigv) {
		this.facigv = facigv;
	}

	public ClienteJPA getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteJPA cliente) {
		this.cliente = cliente;
	}

	public VendedorJPA getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(VendedorJPA vendedor) {
		this.vendedor = vendedor;
	}

	public List<FacDetaJPA> getFacDetas() {
		return this.facDetas;
	}

	public void setFacDetas(List<FacDetaJPA> facDetas) {
		this.facDetas = facDetas;
	}

	public FacDetaJPA addFacDeta(FacDetaJPA facDeta) {
		getFacDetas().add(facDeta);
		facDeta.setFacCabe(this);

		return facDeta;
	}

	public FacDetaJPA removeFacDeta(FacDetaJPA facDeta) {
		getFacDetas().remove(facDeta);
		facDeta.setFacCabe(null);

		return facDeta;
	}

}