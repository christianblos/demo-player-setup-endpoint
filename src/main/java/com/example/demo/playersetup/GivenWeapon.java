package com.example.demo.playersetup;

import com.example.demo.domain.Weapon;
import lombok.Getter;

import java.util.UUID;

/**
 * Configures a {@link Weapon} entity for the player setup.
 */
@Getter
public class GivenWeapon extends GivenEntity<GivenWeapon, Weapon> {

	private final UUID id = UUID.randomUUID();
	private Weapon.Type type = Weapon.Type.SWORD;
	private int attackPoints;
	private String color = "#6c5353";

	public GivenWeapon withType(Weapon.Type type) {
		this.type = type;
		return this;
	}

	public GivenWeapon withAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
		return this;
	}

	public GivenWeapon withColor(String color) {
		this.color = color;
		return this;
	}

}
