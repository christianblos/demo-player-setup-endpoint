package com.example.demo.playersetup.groovyshell;

import groovy.lang.Script;

import java.util.concurrent.atomic.AtomicReference;

/**
 * This class provides methods that are available in player setup groovy scripts.
 */
public abstract class PlayerSetupScript extends Script {

	/**
	 * Get or create an AtomicReference object by name.
	 */
	public AtomicReference<?> ref(String name) {
		var references = PlayerSetupProperties.getEntityReferences(this);

		if (!references.containsKey(name)) {
			references.put(name, new AtomicReference<>());
		}

		return references.get(name);
	}

}
