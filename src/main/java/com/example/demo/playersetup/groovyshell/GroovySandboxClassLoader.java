package com.example.demo.playersetup.groovyshell;

/**
 * This class loader is used by the groovy shell which restricts the classes
 * that are allowed to be used in the player setup groovy scripts.
 */
public class GroovySandboxClassLoader extends ClassLoader {

	public GroovySandboxClassLoader(ClassLoader parent) {
		super(parent);
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		if (name.startsWith("java.")
			|| name.startsWith("groovy.")
			|| name.startsWith("org.codehaus.groovy.")
			|| name.equals(PlayerSetupScript.class.getName())
			|| GroovySandboxClassWhitelist.getWhitelist().containsKey(name)) {
			return super.loadClass(name, resolve);
		}
		return null;
	}

}