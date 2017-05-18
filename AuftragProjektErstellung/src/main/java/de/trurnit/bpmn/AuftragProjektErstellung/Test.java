package de.trurnit.bpmn.AuftragProjektErstellung;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an empty service implementation illustrating how to use a plain Java
 * class as a BPMN 2.0 Service Task delegate.
 */

public class Test implements JavaDelegate {
	
	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String konfig_pfad = (String) execution.getVariable("konfig_pfad");
		LOGGER.info("XXXXXXXXX die Konfiguration liegt dort: " + konfig_pfad);

	}

}
