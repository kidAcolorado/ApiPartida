package com.viewnext.kidaprojects.apipartida.dto;

import java.util.Objects;



public class EnemigoDTO {
	
	private int idEnemigo;
	private String nombre;
	private String descripcion;
	private int nivel;
	private int recompensa;
	private int fuerza;
	private int defensa;
	private int vidaOriginal;
	private int vidaActual;
	private boolean vencido;
	private boolean activo;

	
	public EnemigoDTO() {
		super();
		
	}

	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
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

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVidaOriginal() {
		return vidaOriginal;
	}

	public void setVidaOriginal(int vidaOriginal) {
		this.vidaOriginal = vidaOriginal;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vida) {
		this.vidaActual = vida;
	}

	public boolean isVencido() {
		return vencido;
	}

	public void setVencido(boolean vencido) {
		this.vencido = vencido;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEnemigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnemigoDTO other = (EnemigoDTO) obj;
		return idEnemigo == other.idEnemigo;
	}

	@Override
	public String toString() {
		return "Enemigo [idEnemigo=" + idEnemigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", recompensa=" + recompensa + ", fuerza=" + fuerza + ", defensa=" + defensa
				+ ", vidaOriginal=" + vidaOriginal + ", vidaActual=" + vidaActual + ", vencido=" + vencido + ", activo="
				+ activo + "]";
	}

	

}
