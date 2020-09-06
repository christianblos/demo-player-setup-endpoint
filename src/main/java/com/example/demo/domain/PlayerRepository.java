package com.example.demo.domain;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Stores the {@link Player} entity in memory.
 * In a real project we would use a database here.
 */
@Component
public class PlayerRepository {

	private Player currentPlayer;

	public void save(Player player) {
		currentPlayer = player;
	}

	public Player getCurrentPlayer() {
		if (currentPlayer == null) {
			var player = new Player(UUID.randomUUID(), "Hero");
			player.setLevel(1);
			return player;
		}
		return currentPlayer;
	}

}
