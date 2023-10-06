package com.viewnext.kidaprojects.apipartida.dto;

import java.util.Objects;

public class PersonajeDTO {

	private int idPersonaje;
	private String nombre;
	private int fuerzaOriginal;
	private int fuerzaActual;
	private int defensaOriginal;
	private int defensaActual;
	private int nivel;
	private int vidaOriginal;
	private int vidaTotal;
	private int vidaActual;
	private int experiencia;
	private boolean activo;
	
	public PersonajeDTO() {
		super();
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerzaOriginal() {
		return fuerzaOriginal;
	}

	public void setFuerzaOriginal(int fuerzaOriginal) {
		this.fuerzaOriginal = fuerzaOriginal;
	}

	public int getFuerzaActual() {
		return fuerzaActual;
	}

	public void setFuerzaActual(int fuerzaActual) {
		this.fuerzaActual = fuerzaActual;
	}

	public int getDefensaOriginal() {
		return defensaOriginal;
	}

	public void setDefensaOriginal(int defensaOriginal) {
		this.defensaOriginal = defensaOriginal;
	}

	public int getDefensaActual() {
		return defensaActual;
	}

	public void setDefensaActual(int defensaActual) {
		this.defensaActual = defensaActual;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getVidaOriginal() {
		return vidaOriginal;
	}

	public void setVidaOriginal(int vidaOriginal) {
		this.vidaOriginal = vidaOriginal;
	}

	public int getVidaTotal() {
		return vidaTotal;
	}

	public void setVidaTotal(int vidaTotal) {
		this.vidaTotal = vidaTotal;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersonaje);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonajeDTO other = (PersonajeDTO) obj;
		return idPersonaje == other.idPersonaje;
	}

	@Override
	public String toString() {
		return "PersonajeDTO [idPersonaje=" + idPersonaje + ", nombre=" + nombre + ", fuerzaOriginal=" + fuerzaOriginal
				+ ", fuerzaActual=" + fuerzaActual + ", defensaOriginal=" + defensaOriginal + ", defensaActual="
				+ defensaActual + ", nivel=" + nivel + ", vidaOriginal=" + vidaOriginal + ", vidaTotal=" + vidaTotal
				+ ", vidaActual=" + vidaActual + ", experiencia=" + experiencia + ", activo=" + activo + "]";
	}
	
	
	
}
