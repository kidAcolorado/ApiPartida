package com.viewnext.kidaprojects.apipartida.restcontroller;



import java.util.List;


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
    
    /**
     * Reinicia todas las misiones y datos relacionados en la aplicación.
     *
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PostMapping(value = "partida/reinicio")
    public ResponseEntity<?> reiniciarMisiones(){
        ResponseEntity<?> response = service.reiniciarTodo();
        
        return ResponseEntity.ok().body(response.getBody());
    }
    
    /**
     * Crea una nueva partida con la información proporcionada.
     *
     * @param partida La partida que se creará.
     * @return La partida creada.
     */
    @PostMapping(value = "partida", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partida> createPartida(@RequestBody Partida partida){
        
        Partida partidaCreada = service.crearPartida(partida);
        
        return ResponseEntity.ok(partidaCreada); 
    }
    
    /**
     * Agrega todas las misiones disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán las misiones.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/misiones/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAllMisiones(@PathVariable("idPartida") long idPartida){
        service.addAllMisiones(idPartida);
        return ResponseEntity.ok("Misiones añadidas");
    }
    
    /**
     * Agrega todos los enemigos disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán los enemigos.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/enemigos/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAllEnemigos(@PathVariable("idPartida") long idPartida){
        service.addAllEnemigos(idPartida);
        return ResponseEntity.ok("Enemigos añadidos");
    }
    
    /**
     * Agrega todos los personajes disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán los personajes.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/personajes/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAllPersonajes(@PathVariable("idPartida") long idPartida){
        service.addAllPersonajes(idPartida);
        return ResponseEntity.ok("Personajes añadidos");
    }
    
    /**
     * Agrega una misión específica a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregará la misión.
     * @param idMision  El ID de la misión que se agregará a la partida.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/mision/{idPartida}/{idMision}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMisionById(@PathVariable("idPartida") long idPartida,
            @PathVariable("idMision") int idMision){
        service.addMision(idPartida, idMision);
        return ResponseEntity.ok("Mision añadida");
    }
    
    /**
     * Agrega un personaje específico a una partida existente.
     *
     * @param idPartida    El ID de la partida a la que se agregará el personaje.
     * @param idPersonaje  El ID del personaje que se agregará a la partida.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/personaje/{idPartida}/{idPersonaje}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPersonajeById(@PathVariable("idPartida") long idPartida,
            @PathVariable("idPersonaje") int idPersonaje){
        service.addMision(idPartida, idPersonaje);
        return ResponseEntity.ok("Personaje añadido");
    }
    
    /**
     * Agrega un enemigo específico a una partida existente.
     *
     * @param idPartida    El ID de la partida a la que se agregará el enemigo.
     * @param idEnemigo    El ID del enemigo que se agregará a la partida.
     * @return Una respuesta que indica el resultado de la operación.
     */
    @PutMapping(value = "partida/enemigo/{idPartida}/{idEnemigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addEnemigoById(@PathVariable("idPartida") long idPartida,
            @PathVariable("idEnemigo") int idEnemigo){
        service.addMision(idPartida, idEnemigo);
        return ResponseEntity.ok("Enemigo añadido");
    }
    
    /**
     * Obtiene una lista de todas las partidas existentes.
     *
     * @return Una respuesta que contiene la lista de partidas.
     */
    @GetMapping(value = "partida", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mostrarPartidas(){
        List<Partida> listaPartidas = service.showAll();
        
        return ResponseEntity.ok(listaPartidas);
    }
    
    /**
     * Da de baja una partida existente.
     *
     * @param idPartida El ID de la partida que se dará de baja.
     * @return La partida que se dio de baja.
     */
    @DeleteMapping(value = "partida/{idPartida}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> darDeBajaPartida(@PathVariable("idPartida") long idPartida){
        Partida partidaInactiva = service.darDeBajaPartida(idPartida);
        return ResponseEntity.ok(partidaInactiva);
    }
}
