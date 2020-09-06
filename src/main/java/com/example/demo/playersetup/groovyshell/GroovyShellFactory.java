package com.example.demo.playersetup.groovyshell;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.springframework.stereotype.Component;

/**
 * Creates a groovy shell object that can execute groovy scripts.
 */
@Component
public class GroovyShellFactory {

	private final GroovySandboxClassLoader sandboxClassLoader;

	private final CompilerConfiguration compilerConfig;

	public GroovyShellFactory() {
		sandboxClassLoader = new GroovySandboxClassLoader(getClass().getClassLoader());

		compilerConfig = new CompilerConfiguration();
		compilerConfig.addCompilationCustomizers(new GroovySandboxImportCustomizer());
		compilerConfig.setScriptBaseClass(PlayerSetupScript.class.getName());
	}

	public GroovyShell createSandboxShell() {
		var shell = new GroovyShell(sandboxClassLoader, compilerConfig);
		PlayerSetupProperties.setInitialProperties(shell);
		return shell;
	}

}
