package com.ejb.core.db.service.impl;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ejb.core.db.DBConnection;
import com.ejb.core.db.service.DBService;

/**
 * 
 * @author ahajri
 *
 */
@Stateless(name = "mongoService")
@Remote(DBService.class)
public class DBServiceImpl implements DBService {

	/**
	 * UID serialization version
	 */
	private static final long serialVersionUID = -5525073395698397946L;
	
	/**
	 * 
	 */
	@EJB
	private DBConnection connectionHbase;

	@Override
	public String testRemote() throws EJBException {
		return "Hello there, this is remote EJB invokation test";
	}

}
