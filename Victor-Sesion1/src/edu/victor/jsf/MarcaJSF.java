package edu.victor.jsf;

import java.util.ArrayList;

import javax.faces.model.SelectItem;




import edu.victor.jpa.MarcaJPA;
import edu.victor.service.MarcaImplementacion;

public class MarcaJSF {
	
	private String idmarca;
	private String desmarca;

	private MarcaImplementacion marcai= new MarcaImplementacion();
	
	
	private ArrayList<SelectItem> marcaSelectItems;
	

	
	
	public String getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}
	public String getDesmarca() {
		return desmarca;
	}
	public void setDesmarca(String desmarca) {
		this.desmarca = desmarca;
	}


	public ArrayList<SelectItem> getMarcaSelectItems() throws Exception {
		
		marcaSelectItems = new ArrayList<SelectItem>();
		for(MarcaJPA objm:marcai.listaMarca())
			marcaSelectItems.add(new SelectItem(objm.getIdmarca(),objm.getDesmarca()));
			
		return marcaSelectItems;
	}


	public void setMarcaSelectItems(ArrayList<SelectItem> marcaSelectItems) {
		this.marcaSelectItems = marcaSelectItems;
	}


	

}
