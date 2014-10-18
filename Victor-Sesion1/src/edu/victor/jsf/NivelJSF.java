package edu.victor.jsf;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import edu.victor.jpa.NivelJPA;
import edu.victor.service.NivelImplementacion;

public class NivelJSF {
	private String idnivel;
	private String niveldes;
	
	private NivelImplementacion niveli = new NivelImplementacion();
	
	private DataModel<NivelJPA> nivelesmodel;
	
	private ArrayList<SelectItem> nivelSelectItems;
	


	public void eliminarNivel(ActionEvent e){
		NivelJPA objn= new NivelJPA();
		try {
			objn.setIdnivel(e.getComponent().getAttributes().get("nidnivel").toString());
			
			niveli.eliminarNivel(objn);
			
		} catch (Exception e2) {
			System.out.println("Error de eliminación en Implementacion " + e2.getMessage()); 
		}
		
	}
	
	public void altaNivel(ActionEvent e){
		NivelJPA objn = new NivelJPA();
		try {
			objn.setIdnivel(getIdnivel());
			objn.setNiveldes(getNiveldes());
			if(objn!=null)
			niveli.altaNivel(objn);
		} catch (Exception e2) {
			System.out.println("Error de implementacion Alta nivel "+ e2.getMessage());
		}
	}
	
	
	
	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public String getNiveldes() {
		return niveldes;
	}

	public void setNiveldes(String niveldes) {
		this.niveldes = niveldes;
	}

	
	public DataModel<NivelJPA> getNivelesmodel() throws Exception {
		
		nivelesmodel = new ListDataModel<NivelJPA>(niveli.listaNivel());
		
		return nivelesmodel;
	}

	public void setNivelesmodel(DataModel<NivelJPA> nivelesmodel) {
		this.nivelesmodel = nivelesmodel;
	}
	
		
	
	public ArrayList<SelectItem> getNivelSelectItems() throws Exception {
		
		nivelSelectItems = new ArrayList<SelectItem>();
		for(NivelJPA objn:niveli.listaNivel())
			nivelSelectItems.add(new SelectItem(objn.getIdnivel(),objn.getNiveldes()));
			
		
		return nivelSelectItems;
	}

	public void setNivelSelectItems(ArrayList<SelectItem> nivelSelectItems) {
		this.nivelSelectItems = nivelSelectItems;
	}


}
