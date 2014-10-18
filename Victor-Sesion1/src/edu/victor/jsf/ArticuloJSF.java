package edu.victor.jsf;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import edu.victor.jpa.ArticuloJPA;
import edu.victor.jpa.MarcaJPA;
import edu.victor.service.ArticuloImplementacion;

public class ArticuloJSF {
	
	private String artcod;
	private String artnom;
	private BigDecimal artpre;
	private int artstk;
	private String artuni;
	private String idmarca;
	private int artcantidad;
	
	private ArticuloImplementacion articuloi= new ArticuloImplementacion();
	
	private DataModel<ArticuloJPA> articulosmodel;
	
	
	public void altaArticulo(ActionEvent e){
		try {
			ArticuloJPA obj = new ArticuloJPA();
			obj.setArtcod(getArtcod());
			obj.setArtnom(getArtnom());
			obj.setArtpre(getArtpre());
			obj.setArtstk(getArtstk());
			obj.setArtuni(getArtuni());
			MarcaJPA objm = new MarcaJPA();
			objm.setIdmarca(getIdmarca());
			obj.setMarca(objm);
			articuloi.altaArticulos(obj);
			
		} catch (Exception e2) {
			System.out.println("Error de implementacion Alta Articulo"+ e2.getMessage());
		}
		
		
	}
	
	public void ventaArticulo(ActionEvent e){
		ArticuloJPA obj = new ArticuloJPA();
		try {
		//	setArtcantidad(getArtcantidad());
			obj.setArtcod(e.getComponent().getAttributes().get("codigo").toString());
			obj=buscar(obj);
			//Integer uno= new Integer(e.getComponent().getAttributes().get("cantidad").toString());
			obj.setArtstk(obj.getArtstk()- getArtcantidad());
			articuloi.modificarArticulo(obj);
		} catch (Exception e2) {
			System.out.println("Error de ArticuloJSF " +e2.getMessage());
		}
	}
	
	public ArticuloJPA buscar(ArticuloJPA obja){
		ArticuloJPA obj = new ArticuloJPA();
		try {
			obj=articuloi.buscarArticulo(obja);
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return obj;
	}


	public String getArtcod() {
		return artcod;
	}

	public void setArtcod(String artcod) {
		this.artcod = artcod;
	}

	public String getArtnom() {
		return artnom;
	}

	public void setArtnom(String artnom) {
		this.artnom = artnom;
	}

	public BigDecimal getArtpre() {
		return artpre;
	}

	public void setArtpre(BigDecimal artpre) {
		this.artpre = artpre;
	}

	public int getArtstk() {
		return artstk;
	}

	public void setArtstk(int artstk) {
		this.artstk = artstk;
	}

	public String getArtuni() {
		return artuni;
	}

	public void setArtuni(String artuni) {
		this.artuni = artuni;
	}

	public String getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}

	public DataModel<ArticuloJPA> getArticulosmodel() throws Exception {
		
		articulosmodel = new ListDataModel<ArticuloJPA>(articuloi.listaArticulos());
		
		return articulosmodel;
	}

	public void setArticulosmodel(DataModel<ArticuloJPA> articulosmodel) {
		this.articulosmodel = articulosmodel;
	}

	public int getArtcantidad() {
		return artcantidad;
	}

	public void setArtcantidad(int artcantidad) {
		this.artcantidad = artcantidad;
	}

}
