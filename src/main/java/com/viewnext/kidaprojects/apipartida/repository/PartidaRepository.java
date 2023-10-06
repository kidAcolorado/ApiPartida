package com.viewnext.kidaprojects.apipartida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.kidaprojects.apipartida.model.Partida;

/**
 * Interfaz que define un repositorio de datos para la entidad {@link Partida}.
 *
 * <p>Esta interfaz extiende la interfaz {@link JpaRepository} y proporciona métodos
 * adicionales para realizar operaciones de acceso a datos relacionadas con la entidad Partida.</p>
 *
 * @see Partida
 * @see JpaRepository
 */
public interface PartidaRepository extends JpaRepository<Partida, Long> {

	
}
