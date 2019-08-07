package by.epam.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Сергей
 *
 */
public class Application {

	private static final Logger LOG = LogManager.getLogger(Application.class.getName());
	
	public static void start() {
		LOG.info("Application have been started");
	}
	
}
