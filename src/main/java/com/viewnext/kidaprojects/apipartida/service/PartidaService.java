package com.viewnext.kidaprojects.apipartida.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.viewnext.kidaprojects.apipartida.model.Partida;

/**
 * Interfaz que define los servicios disponibles para la gestión de partidas.
 *
 * <p>Esta interfaz proporciona métodos para realizar operaciones relacionadas con las partidas,
 * como añadir misiones, enemigos, personajes, crear y dar de baja partidas, y reiniciar el estado de la aplicación.</p>
 */
public interface PartidaService {

	void addAllMisiones(long idPartida);
	
	List<Partida> showAll();

	void addMision(long idPartida, int idMision);

	void addAllEnemigos(long idPartida);

	void addEnemigo(long idPartida, int idEnemigo);

	void addAllPersonajes(long idPartida);

	void addpersonaje(long idPartida, int idPersonaje);

	Partida crearPartida(Partida partida);
			
	Partida darDeBajaPartida(long idPartida);

	ResponseEntity<?> reiniciarTodo();
}
