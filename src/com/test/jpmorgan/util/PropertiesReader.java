package com.test.jpmorgan.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utility Class to get the property from the config
 * 
 * @author Selvakumar Rajendran
 * 
 */
public class PropertiesReader {

	private static PropertiesReader propertiesReader;
	private Properties prop = new Properties();

	/**
	 * Load the properties from config.properties
	 * 
	 * @throws Exception
	 */
	private PropertiesReader() throws Exception {
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("config.properties");
		prop.load(in);
	}

	/**
	 * Get the single instanced property reader.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static PropertiesReader getInstance() throws Exception {
		return propertiesReader == null ? new PropertiesReader()
				: propertiesReader;
	}

	/**
	 * Get the property for the config.properties from the class path.
	 * 
	 * @param name
	 * @return
	 */
	public String getProperty(String name) {
		return prop.getProperty(name);
	}
}
