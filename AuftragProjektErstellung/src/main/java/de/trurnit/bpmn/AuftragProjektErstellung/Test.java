package de.trurnit.bpmn.AuftragProjektErstellung;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.SpinList;
import org.camunda.spin.json.SpinJsonNode;
import static org.camunda.spin.Spin.*;

/**
 * This is an empty service implementation illustrating how to use a plain Java
 * class as a BPMN 2.0 Service Task delegate.
 */

public class Test implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// String konfig_pfad = (String) execution.getVariable("konfig_pfad");

		/*LOGGER.info("Testklasse vor einlesen von JSON; hardgecoded");

		FileInputStream fis = new FileInputStream(System.getProperty("user.home") + "/Desktop/" + "beispiel.json"

		);
		InputStreamReader reader = new InputStreamReader(fis, "utf-8");
		SpinJsonNode json_eingelesen = JSON(reader);

		SpinJsonNode ersterNode = json_eingelesen.prop("Inhaber");
		SpinJsonNode zweiterNode = ersterNode.prop("Hobbys");
		SpinList testListe = zweiterNode.elements();
		SpinJsonNode testElement = (SpinJsonNode) testListe.get(2);
		String testElementString = testElement.stringValue();

		LOGGER.info("JSON Array aus zweiter Ebene auslesen: " + testElementString
				+ " ... als nächstes einen Wert im JSON setzen");

		 jetzt auch mal setzen 
		json_eingelesen.prop("Herausgeber", "Der Daniel");
		json_eingelesen.prop("Deckung", 123456);*/

		SpinJsonNode json = JSON("{\"test-array\" : [\"testdata1\",\"testdata2\",1,2,true,1,false,1]}");
		SpinJsonNode list = json.prop("test-array");

		Integer i = list.indexOf("testdata2"); // Should be '1'
		LOGGER.info("Should be '1': " + i.toString());
		Integer j = list.lastIndexOf(1); // Should be '7'
		LOGGER.info("Should be '7': " + j.toString());

		list.append("test2"); // at the end of the list there should now be
								// "test2"
		LOGGER.info("im memory json: " + list.toString() + " - vor löschen von \"test2\" ");
		list.remove("test2"); // Aaaand now, it is gone ;)

		list.insertAt(1, "test3"); // test3 should now be inserted before
									// testdata2
		list.removeAt(1); // Aaaand now, it is gone ;)

		list.insertBefore(true, "test4"); // now there should be test4 on index
											// 4
		list.insertAfter(true, 5); // So now 5 is on index 6

		LOGGER.info("im memory json: " + list.toString() + " - ende ");

	}

}
