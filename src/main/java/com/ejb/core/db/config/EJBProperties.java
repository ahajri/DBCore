package com.ejb.core.db.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Singleton properties
 * 
 * @author ahajri
 *
 */
@Singleton(name = "properties")
@Startup
public class EJBProperties {

	Properties properties = null;

	@PostConstruct
	public void init()  {
		InputStream inputStream = EJBProperties.class.getClassLoader().getResourceAsStream("application.properties");

		if (properties == null) {
			properties = new Properties();
		}

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}