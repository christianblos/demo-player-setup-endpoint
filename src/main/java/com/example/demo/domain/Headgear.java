package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * The headgear entity that can be assigned to a {@link Player}
 */
@RequiredArgsConstructor
@Getter
public class Headgear implements Entity {

	private final UUID id;
	private final Type type;
	private final int defensePoints;
	private final String color;

	public enum Type {
		HELMET,
	}

}
