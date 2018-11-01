package com.ken.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Property util for file config.properties
 * 
 * @author ken
 */
public class PropertyUtil {

	private static final Logger logger = Logger.getLogger(PropertyUtil.class);

	private static Properties props;

	static {
		loadProps();
	}

	synchronized static private void loadProps() {
		logger.info("Load properties files: config.properties");
		props = new Properties();
		InputStream in = null;
		try {
			in = PropertyUtil.class.getClassLoader().getResourceAsStream("config.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error("config.properties is not found.");
		} catch (IOException e) {
			logger.error("config.properties load error.");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("config.properties load error.");
			}
		}
		logger.info("Loaded properties files: config.properties");
	}

	public static String getProperty(String key) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
}
