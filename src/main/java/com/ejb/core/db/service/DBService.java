package com.ejb.core.db.service;

import java.io.Serializable;

import javax.ejb.EJBException;

/**
 * 
 * @author ahajri
 *
 */
public interface DBService extends Serializable {

	public String testRemote() throws EJBException;

}
