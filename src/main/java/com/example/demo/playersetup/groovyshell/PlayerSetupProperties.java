package com.example.demo.playersetup.groovyshell;

import groovy.lang.GroovyObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This is a utility class to set or get properties that are used
 * inside the player setup groovy scripts.
 */
public class PlayerSetupProperties {

	/**
	 * The `references` property is a map that contains all references
	 * created inside the groovy script via the ref() function.
	 */
	public static final String PROPERTY_REFERENCES = "references";

	public static void setInitialProperties(GroovyObject object) {
		object.setProperty(PROPERTY_REFERENCES, new HashMap<>());
	}

	@SuppressWarnings("unchecked")
	public static Map<String, AtomicReference<?>> getEntityReferences(GroovyObject object) {
		return (Map<String, AtomicReference<?>>) object.getProperty(PROPERTY_REFERENCES);
	}

}
