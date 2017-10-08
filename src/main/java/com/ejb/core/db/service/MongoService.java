package com.ejb.core.db.service;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJBException;

/**
 * 
 * @author ahajri
 *
 */
public interface MongoService extends Serializable {

	/**
	 * 
	 * @return test answer
	 * @throws EJBException
	 */
	public String testRemote() throws EJBException;

	/**
	 * 
	 * @param collectionName
	 * @param filter
	 * @return {@link Set}
	 * @throws EJBException
	 */
	public Set<String> findInCollection(String collectionName, Map<String, Object> filter) throws EJBException;

	/**
	 * 
	 * @param collectionName
	 * @param doc
	 * @throws EJBException
	 */
	public void insertOne(String collectionName, Map<String, Object> doc) throws EJBException;

}
