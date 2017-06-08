package de.trurnit.bpmn.AuftragProjektErstellung;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class KonfigParser implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String konfig_pfad = (String) execution.getVariable("konfig_pfad");

		if (konfig_pfad.length() > 5) {
			execution.setVariable("konfig_check", "passed");
		} else {
			execution.setVariable("konfig_check", "failed");

		}
		String konfig_check = (String) execution.getVariable("konfig_check");

		LOGGER.info("KonfigParser ausgeführt: konfig_pfad " + konfig_pfad + " konfig_check " + konfig_check);
		LOGGER.info("history check2" );
	}

}
