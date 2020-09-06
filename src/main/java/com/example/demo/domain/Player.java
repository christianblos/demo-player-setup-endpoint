package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

/**
 * The player entity which contains the stats and equipment of the player.
 */
@Getter
@Setter
public class Player implements Entity {

	private UUID id;
	private String name;
	private int level;
	private Weapon weapon;
	private Headgear headgear;

	public Player(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public Optional<Weapon> getWeapon() {
		return Optional.ofNullable(weapon);
	}

	public Optional<Headgear> getHeadgear() {
		return Optional.ofNullable(headgear);
	}

	public int getAttackPoints() {
		return getWeapon()
			.map(Weapon::getAttackPoints)
			.orElse(0);
	}

	public int getDefensePoints() {
		return getHeadgear()
			.map(Headgear::getDefensePoints)
			.orElse(0);
	}
}
