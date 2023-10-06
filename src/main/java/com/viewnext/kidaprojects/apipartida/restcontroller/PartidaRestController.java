package com.viewnext.kidaprojects.apipartida.restcontroller;



import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.apipartida.model.Partida;
import com.viewnext.kidaprojects.apipartida.service.PartidaService;

@RestController
public class PartidaRestController {

	@Autowired
	private PartidaService service;
	
	@PostMapping(value = "partida/reinicio")
	public ResponseEntity<?> reiniciarMisiones(){
		ResponseEntity<?> response = service.reiniciarTodo();
		
		return ResponseEntity.ok().body(response.getBody());
	}
	
	@PostMapping(value = "partida", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partida> createPartida(@RequestBody Partida partida){
		
		Partida partidaCreada = service.crearPartida(partida);
		
		return ResponseEntity.ok(partidaCreada); 
	}
	
	@PutMapping(value = "partida/misiones/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAllMisiones(@PathVariable("idPartida") long idPartida){
		service.addAllMisiones(idPartida);
		return ResponseEntity.ok("Misiones añadidas");
	}
	
	@PutMapping(value = "partida/enemigos/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAllEnemigos(@PathVariable("idPartida") long idPartida){
		service.addAllEnemigos(idPartida);
		return ResponseEntity.ok("Enemigos añadidos");
	}
	
	@PutMapping(value = "partida/personajes/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAllPersonajes(@PathVariable("idPartida") long idPartida){
		service.addAllPersonajes(idPartida);
		return ResponseEntity.ok("Personajes añadidos");
	}
	
	@PutMapping(value = "partida/mision/{idPartida}/{idMision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMisionById(@PathVariable("idPartida") long idPartida,
			@PathVariable("idMision") int idMision){
		service.addMision(idPartida, idMision);
		return ResponseEntity.ok("Mision añadida");
	}
	
	@PutMapping(value = "partida/personaje/{idPartida}/{idPersonaje}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPersonajeById(@PathVariable("idPartida") long idPartida,
			@PathVariable("idPersonaje") int idPersonaje){
		service.addMision(idPartida, idPersonaje);
		return ResponseEntity.ok("Personaje añadido");
	}
	
	@PutMapping(value = "partida/enemigo/{idPartida}/{idEnemigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEnemigoById(@PathVariable("idPartida") long idPartida,
			@PathVariable("idEnemigo") int idEnemigo){
		service.addMision(idPartida, idEnemigo);
		return ResponseEntity.ok("Enemigo añadido");
	}
	
	
	@GetMapping(value = "partida", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarPartidas(){
		List<Partida> listaPartidas = service.showAll();
		
		return ResponseEntity.ok(listaPartidas);
	}
	
	@DeleteMapping(value = "partida/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> darDeBajaPartida(@PathVariable("idPartida") long idPartida){
		Partida partidaInactiva = service.darDeBajaPartida(idPartida);
		return ResponseEntity.ok(partidaInactiva);
		
	}
	
	
}
