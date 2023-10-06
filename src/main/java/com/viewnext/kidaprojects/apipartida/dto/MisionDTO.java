package com.viewnext.kidaprojects.apipartida.dto;

import java.util.Objects;

public class MisionDTO {

	private int idMision;
	private String nombre;
	private String descripcion;
	private int nivel;
	private int recompensa;
	private boolean superada;
	private boolean activa;
	
	
	public MisionDTO() {
		super();
	}


	public int getIdMision() {
		return idMision;
	}


	public void setIdMision(int idMision) {
		this.idMision = idMision;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getRecompensa() {
		return recompensa;
	}


	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}


	public boolean isSuperada() {
		return superada;
	}


	public void setSuperada(boolean superada) {
		this.superada = superada;
	}


	public boolean isActiva() {
		return activa;
	}


	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idMision);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisionDTO other = (MisionDTO) obj;
		return idMision == other.idMision;
	}


	@Override
	public String toString() {
		return "MisionDTO [idMision=" + idMision + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", recompensa=" + recompensa + ", superada=" + superada + ", activa=" + activa + "]";
	}
	
	
}
