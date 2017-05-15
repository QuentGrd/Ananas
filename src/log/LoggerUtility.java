package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtility {
	
	private static final String LOG_CONFIG = "res/log.properties";

	public static Logger getLogger(Class<?> logClass) {
		PropertyConfigurator.configure(LOG_CONFIG);
		String className = logClass.getName();
		return Logger.getLogger(className);
	}
}
