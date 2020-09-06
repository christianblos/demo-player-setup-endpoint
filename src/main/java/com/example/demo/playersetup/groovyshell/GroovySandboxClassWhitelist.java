package com.example.demo.playersetup.groovyshell;

import com.example.demo.domain.Headgear;
import com.example.demo.domain.Player;
import com.example.demo.domain.Weapon;
import com.example.demo.playersetup.GivenHeadgear;
import com.example.demo.playersetup.GivenPlayer;
import com.example.demo.playersetup.GivenWeapon;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains a whitelist of classes that are allowed to be used in the groovy script.
 */
public class GroovySandboxClassWhitelist {

	/**
	 * Mapping of "Class name" -> "Alias".
	 * If an alias is defined, the class will be imported automatically in groovy scripts
	 * (See {@link GroovySandboxImportCustomizer}).
	 */
	@Getter
	private static final Map<String, String> whitelist = new HashMap<>();

	// Filling the whitelist is done in a static block as this must happen only once during app start.
	// This demo just contains a hard coded list. In real projects it makes sense to
	// use a class scanner like io.github.classgraph:classgraph.
	static {
		addWithAlias(GivenPlayer.class);
		addWithAlias(GivenWeapon.class);
		addWithAlias(GivenHeadgear.class);

		addWithAlias(Player.class);
		addWithAlias(Weapon.class);
		addWithAlias(Weapon.Type.class);
		addWithAlias(Headgear.class);
		addWithAlias(Headgear.Type.class);
	}

	private static void addWithAlias(Class<?> clazz) {
		whitelist.put(clazz.getName(), clazz.getSimpleName());
	}

}
