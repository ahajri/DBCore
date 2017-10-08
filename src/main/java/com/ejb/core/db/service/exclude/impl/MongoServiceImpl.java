package com.ejb.core.db.service.exclude.impl;

import java.sql.DatabaseMetaData;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.bson.Document;

import com.ejb.core.db.service.MongoService;
import com.ejb.core.db.service.exclude.MongoClientProvider;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * @author
 *         <p>
 *         ahajri
 *         </p>
 *
 */
@Stateless(name = "mongoService")
@Remote(MongoService.class)
public class MongoServiceImpl implements MongoService {

	/**
	 * UID serialization version
	 */
	private static final long serialVersionUID = -5525073395698397946L;

	@EJB
	private MongoClientProvider mongoClientProvider;

	@Override
	public String testRemote() throws EJBException {
		return "Hello there, this is remote EJB invokation test";
	}

	@Override
	public Set<String> findInCollection(String collectionName, Map<String, Object> filter) throws EJBException {
		MongoClient mongoClient = mongoClientProvider.getMongoClient();
		Set<String> collections = new HashSet<>();
		MongoDatabase db = mongoClient.getDatabase("CoreDB");
		MongoCollection<Document> collection = db.getCollection(collectionName);
		FindIterable<Document> found = collection.find();
		found.forEach(new Block<Document>() {
			@Override
			public void apply(Document d) {
				collections.add(d.toJson());
			}
		});
		return collections;
	}

	@Override
	public void insertOne(String collectionName, Map<String, Object> doc) throws EJBException {
		MongoClient mongoClient = mongoClientProvider.getMongoClient();
		MongoDatabase db = mongoClient.getDatabase("CoreDB");
		MongoCollection<Document> collection = db.getCollection(collectionName);
		collection.insertOne(new Document(doc));
		

	}

}
