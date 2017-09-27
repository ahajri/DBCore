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
@Singleton(name="properties")
@Startup
public class EJBProperties {

	Properties properties;

	@PostConstruct
	public void init() throws IOException {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("application.properties");

		properties = new Properties();
		System.out.println("InputStream is: " + inputStream);
		// Loading the properties
		properties.load(inputStream);

	}

}