package com.ejb.core.db;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.inject.Inject;

import com.ejb.core.db.config.EJBProperties;

/**
 * Class DB Manager
 */
@Stateful
@Local
public class DBConnection {


	
	@Inject
	private EJBProperties properties;

	
}
