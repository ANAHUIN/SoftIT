package edu.victor.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@Table(name="nivel")
@NamedQuery(name="NivelJPA.findAll", query="SELECT n FROM NivelJPA n")
public class NivelJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idnivel;

	private String niveldes;

	//bi-directional many-to-one association to UsuarioJPA
	@OneToMany(mappedBy="nivel")
	private List<UsuarioJPA> usuarios;

	public NivelJPA() {
	}

	public String getIdnivel() {
		return this.idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public String getNiveldes() {
		return this.niveldes;
	}

	public void setNiveldes(String niveldes) {
		this.niveldes = niveldes;
	}

	public List<UsuarioJPA> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioJPA> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioJPA addUsuario(UsuarioJPA usuario) {
		getUsuarios().add(usuario);
		usuario.setNivel(this);

		return usuario;
	}

	public UsuarioJPA removeUsuario(UsuarioJPA usuario) {
		getUsuarios().remove(usuario);
		usuario.setNivel(null);

		return usuario;
	}

}