package com.example.demo.playersetup;

import com.example.demo.domain.Player;
import lombok.Getter;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * Configures a {@link Player} entity for the player setup.
 */
@Getter
public class GivenPlayer extends GivenEntity<GivenPlayer, Player> {

	private final UUID id = UUID.randomUUID();
	private String name = "Hero";
	private int level = 1;
	private GivenWeapon weapon;
	private GivenHeadgear headgear;

	public GivenPlayer withName(String name) {
		this.name = name;
		return this;
	}

	public GivenPlayer withLevel(int level) {
		this.level = level;
		return this;
	}

	public GivenPlayer withWeapon(Consumer<GivenWeapon> weaponConsumer) {
		var weapon = new GivenWeapon();
		weaponConsumer.accept(weapon);
		this.weapon = weapon;
		return this;
	}

	public GivenPlayer withHeadgear(Consumer<GivenHeadgear> headgearConsumer) {
		var headgear = new GivenHeadgear();
		headgearConsumer.accept(headgear);
		this.headgear = headgear;
		return this;
	}

}
