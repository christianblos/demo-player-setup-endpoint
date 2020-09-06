package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * The weapon entity that can be assigned to a {@link Player}
 */
@RequiredArgsConstructor
@Getter
public class Weapon implements Entity {

	private final UUID id;
	private final Type type;
	private final int attackPoints;
	private final String color;

	public enum Type {
		SWORD,
		AXE,
	}

}
