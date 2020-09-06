package com.example.demo.app.controller;

import com.example.demo.domain.Entity;
import com.example.demo.domain.Player;
import com.example.demo.domain.PlayerRepository;
import com.example.demo.playersetup.GivenPlayer;
import com.example.demo.playersetup.PlayerSetup;
import com.example.demo.playersetup.groovyshell.GroovyShellFactory;
import com.example.demo.playersetup.groovyshell.PlayerSetupProperties;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerSetupController {

	private final PlayerRepository playerRepository;

	private final GroovyShellFactory groovyShellFactory;

	private final PlayerSetup playerSetup;

	private final ObjectMapper objectMapper = new ResponseObjectMapper();

	/**
	 * Accepts a groovy script as the request body to set up the player.
	 * E.g.
	 *
	 * <pre>
	 * player
	 *     .withName("Hero")
	 *     .withLevel(2)
	 *     .withWeapon(weapon -> weapon
	 *         .withType(Weapon.Type.SWORD)
	 *         .withAttackPoints(10)
	 *     )
	 * </pre>
	 */
	@PostMapping(value = "/setup-player", produces = MediaType.APPLICATION_JSON_VALUE)
	public String setUpPlayer(@RequestBody String request) throws JsonProcessingException {
		Player player = playerRepository.getCurrentPlayer();

		// Create sandboxed groovy shell
		var groovyShell = groovyShellFactory.createSandboxShell();

		// Set player property that can be configured inside the groovy script
		var givenPlayer = new GivenPlayer();
		givenPlayer.setEntity(player);
		groovyShell.setProperty("player", givenPlayer);

		// Run requested groovy script which configures the givenPlayer object
		groovyShell.evaluate(request);

		// Use givenPlayer object to set up the player
		playerSetup.setUp(givenPlayer);

		// Return entities that were referenced in the groovy script
		var references = PlayerSetupProperties.getEntityReferences(groovyShell);
		return objectMapper.writeValueAsString(references);
	}

	/**
	 * Custom object mapper that is used in order to only serialize specific fields for the response
	 */
	private static class ResponseObjectMapper extends ObjectMapper {

		public ResponseObjectMapper() {
			setFilterProvider(new SimpleFilterProvider()
				.addFilter(OnlyIdsMixIn.FILTER_ID, SimpleBeanPropertyFilter.filterOutAllExcept("id")));

			addMixIn(Entity.class, OnlyIdsMixIn.class);
		}

	}

	@JsonFilter(OnlyIdsMixIn.FILTER_ID)
	private static class OnlyIdsMixIn {

		private static final String FILTER_ID = "onlyIds";

	}
}
