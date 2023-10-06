package com.viewnext.kidaprojects.apipartida.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

/**
 * Clase que representa una partida en la aplicación.
 *
 * <p>Esta clase almacena información sobre las partidas, incluyendo su nombre, descripción,
 * misiones, enemigos, personajes y estado de activación.</p>
 *
 * @Entity
 */
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ElementCollection
    @CollectionTable(name = "partida_misiones", joinColumns = @JoinColumn(name = "partida_id"))
    @Column(name = "mision_id")
    private List<Integer> idsMisiones;

    @ElementCollection
    @CollectionTable(name = "partida_enemigos", joinColumns = @JoinColumn(name = "partida_id"))
    @Column(name = "enemigo_id")
    private List<Integer> idsEnemigos;

    @ElementCollection
    @CollectionTable(name = "partida_personajes", joinColumns = @JoinColumn(name = "partida_id"))
    @Column(name = "personaje_id")
    private List<Integer> idsPersonajes;
    
    
    private boolean activa;


    public Partida(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idsMisiones = new ArrayList<>();
        this.idsEnemigos = new ArrayList<>();
        this.idsPersonajes = new ArrayList<>();
        this.activa = true;
    }
    
    public Partida() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Integer> getIdsMisiones() {
		return idsMisiones;
	}

	public void setIdsMisiones(List<Integer> idsMisiones) {
		this.idsMisiones = idsMisiones;
	}

	public List<Integer> getIdsEnemigos() {
		return idsEnemigos;
	}

	public void setIdsEnemigos(List<Integer> idsEnemigos) {
		this.idsEnemigos = idsEnemigos;
	}

	public List<Integer> getIdsPersonajes() {
		return idsPersonajes;
	}

	public void setIdsPersonajes(List<Integer> idsPersonajes) {
		this.idsPersonajes = idsPersonajes;
	}
	
	

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idsMisiones="
				+ idsMisiones + ", idsEnemigos=" + idsEnemigos + ", idsPersonajes=" + idsPersonajes + "]";
	}
    
    
    
}
