package com.viewnext.kidaprojects.apipartida.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.viewnext.kidaprojects.apipartida.dto.EnemigoDTO;

import com.viewnext.kidaprojects.apipartida.dto.MisionDTO;
import com.viewnext.kidaprojects.apipartida.dto.PersonajeDTO;
import com.viewnext.kidaprojects.apipartida.model.Partida;
import com.viewnext.kidaprojects.apipartida.repository.PartidaRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * Implementación de la interfaz {@link PartidaService} que proporciona los servicios de gestión de partidas.
 *
 * <p>Esta clase realiza operaciones relacionadas con las partidas, como agregar misiones, enemigos y personajes,
 * crear y dar de baja partidas, y reiniciar el estado de la aplicación.</p>
 */
@Service
public class PartidaServiceImpl implements PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;
	private WebClient misionWebClient;
	private WebClient enemigoWebClient;
	private WebClient personajeWebClient;

	/**
     * Constructor de la clase PartidaServiceImpl.
     *
     * @param misionWebClient     Cliente web para la gestión de misiones.
     * @param enemigoWebClient    Cliente web para la gestión de enemigos.
     * @param personajeWebClient  Cliente web para la gestión de personajes.
     */
	public PartidaServiceImpl(WebClient misionWebClient, WebClient enemigoWebClient, WebClient personajeWebClient) {
		this.misionWebClient = misionWebClient;
		this.enemigoWebClient = enemigoWebClient;
		this.personajeWebClient = personajeWebClient;
	}

	/**
     * Agrega todas las misiones disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán las misiones.
     */
	@Override
	public void addAllMisiones(long idPartida) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<List<MisionDTO>> respuestaMisiones = misionWebClient.get()
				.uri("/mision")
				.retrieve()
				.toEntityList(MisionDTO.class)
				.block();

		List<MisionDTO> listaMisiones = respuestaMisiones.getBody();
		
		List<Integer> listaIdsMisiones = new ArrayList<>(); 

		for (MisionDTO m : listaMisiones) {

			int idMision = m.getIdMision();
			
			listaIdsMisiones.add(idMision);
		}
		
		partida.setIdsMisiones(listaIdsMisiones);
		
		partidaRepository.save(partida);

	}

	/**
     * Agrega una misión específica a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregará la misión.
     * @param idMision  El ID de la misión que se agregará a la partida.
     */
	@Override
	public void addMision(long idPartida, int idMision) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<MisionDTO> respuestaMision = misionWebClient.get()
				.uri("/mision/{idMision}", idMision)
				.retrieve()
				.toEntity(MisionDTO.class)
				.block();

		MisionDTO mision = respuestaMision.getBody();

		Integer idMisionDTO = mision.getIdMision();

		List<Integer> listaIdsMisiones = new ArrayList<>();

		listaIdsMisiones.add(idMisionDTO);

		partida.setIdsMisiones(listaIdsMisiones);

		partidaRepository.save(partida);

	}

	/**
     * Agrega todos los enemigos disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán los enemigos.
     */
	@Override
	public void addAllEnemigos(long idPartida) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<List<EnemigoDTO>> respuestaEnemigos = enemigoWebClient.get()
				.uri("/enemigo")
				.retrieve()
				.toEntityList(EnemigoDTO.class)
				.block();

		List<EnemigoDTO> listaEnemigos = respuestaEnemigos.getBody();
		
		List<Integer> listaIdsEnemigos = new ArrayList<>(); 

		for (EnemigoDTO e : listaEnemigos) {

			int idEnemigo = e.getIdEnemigo();
			
			listaIdsEnemigos.add(idEnemigo);
		}
		
		partida.setIdsEnemigos(listaIdsEnemigos);
		
		partidaRepository.save(partida);

	}

	/**
     * Agrega un enemigo específico a una partida existente.
     *
     * @param idPartida  El ID de la partida a la que se agregará el enemigo.
     * @param idEnemigo  El ID del enemigo que se agregará a la partida.
     */
	@Override
	public void addEnemigo(long idPartida, int idEnemigo) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<EnemigoDTO> respuestaEnemigo = enemigoWebClient.get()
				.uri("/enemigo/{idEnemigo}", idEnemigo)
				.retrieve()
				.toEntity(EnemigoDTO.class)
				.block();

		EnemigoDTO enemigo = respuestaEnemigo.getBody();

		Integer idEnemigoDTO = enemigo.getIdEnemigo();

		List<Integer> listaIdsEnemigos = new ArrayList<>();

		listaIdsEnemigos.add(idEnemigoDTO);

		partida.setIdsEnemigos(listaIdsEnemigos);

		partidaRepository.save(partida);


	}

	/**
     * Agrega todos los personajes disponibles a una partida existente.
     *
     * @param idPartida El ID de la partida a la que se agregarán los personajes.
     */
	@Override
	public void addAllPersonajes(long idPartida) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<List<PersonajeDTO>> respuestaPersonajes = personajeWebClient.get()
				.uri("/personaje")
				.retrieve()
				.toEntityList(PersonajeDTO.class)
				.block();

		List<PersonajeDTO> listaPersonajes = respuestaPersonajes.getBody();
		
		List<Integer> listaIdsPersonajes = new ArrayList<>(); 

		for (PersonajeDTO p : listaPersonajes) {

			int idPersonaje = p.getIdPersonaje();
			
			listaIdsPersonajes.add(idPersonaje);
		}
		
		partida.setIdsPersonajes(listaIdsPersonajes);
		
		partidaRepository.save(partida);

	}

	

	/**
     * Agrega un personaje específico a una partida existente.
     *
     * @param idPartida    El ID de la partida a la que se agregará el personaje.
     * @param idPersonaje  El ID del personaje que se agregará a la partida.
     */
	@Override
	public void addpersonaje(long idPartida, int idPersonaje) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();
		
		

		ResponseEntity<PersonajeDTO> respuestaPersonaje = personajeWebClient.get()
				.uri("/personaje/{idPersonaje}", idPersonaje)
				.retrieve()
				.toEntity(PersonajeDTO.class)
				.block();

		PersonajeDTO personaje = respuestaPersonaje.getBody();

		Integer idPersonajeDTO = personaje.getIdPersonaje();

		List<Integer> listaIdsPersonajes = new ArrayList<>();

		listaIdsPersonajes.add(idPersonajeDTO);

		partida.setIdsPersonajes(listaIdsPersonajes);

		partidaRepository.save(partida);

	}

	/**
     * Crea una nueva partida con la información proporcionada.
     *
     * @param partida La partida que se creará.
     * @return La partida creada.
     */
	@Override
	public Partida crearPartida(Partida partida) {

		return partidaRepository.save(partida);
	}

	/**
     * Da de baja una partida existente.
     *
     * @param idPartida El ID de la partida que se dará de baja.
     * @return La partida que se dio de baja.
     */
	@Override
	public Partida darDeBajaPartida(long idPartida) {
		Optional<Partida> optionalPartida = partidaRepository.findById(idPartida);

		if (optionalPartida.isEmpty()) {
			throw new EntityNotFoundException();
		}

		Partida partida = optionalPartida.get();

		partida.setActiva(false);

		return partida;
	}

	/**
     * Reinicia el estado de la aplicación, eliminando todas las partidas y datos relacionados.
     *
     * @return Una respuesta que indica el resultado de la operación.
     */
	@Override
	public ResponseEntity<?> reiniciarTodo() {
		String mensajeFinal = "";

		ResponseEntity<String> responseMision = misionWebClient.post()
				.uri("/mision/reinicio")
				.retrieve()
				.toEntity(String.class)
				.block();

		mensajeFinal += responseMision.getBody() + "\n";

		ResponseEntity<String> responseEnemigo = enemigoWebClient.post()
				.uri("/enemigo/reinicio")
				.retrieve()
				.toEntity(String.class)
				.block();

		mensajeFinal += responseEnemigo.getBody() + "\n";

		ResponseEntity<String> responsePersonaje = personajeWebClient.post()
				.uri("/personaje/reinicio")
				.retrieve()
				.toEntity(String.class)
				.block();

		mensajeFinal += responsePersonaje.getBody() + "\n";

		return ResponseEntity.ok(mensajeFinal);

	}

	/**
     * Obtiene una lista de todas las partidas disponibles.
     *
     * @return Una lista de todas las partidas.
     */
	@Override
	public List<Partida> showAll() {
		
		return partidaRepository.findAll();
	}

}
