package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesReader {
	static Properties dataProp;
	static Properties locProp;
	static Properties elementProp;
	static HashMap<String, String> configMap;
	private static final Logger logger = AppLogger.getLogger();

	static {
		initConfigMap();
	}

	/**
	 * Reads specified key's value from the config.properties file.
	 * 
	 * @param key Key present inside config.properties file
	 * @return Value associated with the key
	 * @author nikdav
	 */
	public static String readKey(String key) {
		String envValue = System.getenv(key);
		if (configMap.get(key) == null && envValue == null) {
			throw new NullPointerException("'" + key
					+ "' neither exists inside data.properties file nor defined as an environment variable ...");
		} else if (configMap.get(key) != null && envValue != null) {
			throw new RuntimeException(
					"'" + key + "' exists inside data.properties file but also defined as an environment variable ...");
		} else if (configMap.get(key) != null && envValue == null) {
			logger.info("'" + key + "' key read from .properties file ...");
			return configMap.get(key).trim();
		} else {
			logger.info("'" + key + "' key read as an environment variable ...");
			return envValue.trim();
		}
	}

	/**
	 * Initializing and populating the config map with the content from
	 * data.properties file.
	 * 
	 * @author nikdav
	 */
	public static void initConfigMap() {
		try {
			FileInputStream data = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
			dataProp = new Properties();
			dataProp.load(data);
			logger.info("loaded data from config.properties file ...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		configMap = new HashMap<String, String>();
		for (String propKey : dataProp.stringPropertyNames()) {
			configMap.put(propKey, dataProp.getProperty(propKey));
		}
	}

}
