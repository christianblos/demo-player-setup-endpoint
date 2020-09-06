package com.example.demo.playersetup;

import com.example.demo.domain.Headgear;
import lombok.Getter;

import java.util.UUID;

/**
 * Configures a {@link Headgear} entity for the player setup.
 */
@Getter
public class GivenHeadgear extends GivenEntity<GivenHeadgear, Headgear> {

	private final UUID id = UUID.randomUUID();
	private Headgear.Type type = Headgear.Type.HELMET;
	private int defensePoints;
	private String color = "#6c5353";

	public GivenHeadgear withType(Headgear.Type type) {
		this.type = type;
		return this;
	}

	public GivenHeadgear withDefense(int defensePoints) {
		this.defensePoints = defensePoints;
		return this;
	}

	public GivenHeadgear withColor(String color) {
		this.color = color;
		return this;
	}

}
