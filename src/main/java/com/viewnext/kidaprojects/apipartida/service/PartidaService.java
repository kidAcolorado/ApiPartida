package com.viewnext.kidaprojects.apipartida.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.viewnext.kidaprojects.apipartida.model.Partida;

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
