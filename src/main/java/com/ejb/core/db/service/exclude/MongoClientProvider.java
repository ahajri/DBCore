package com.ejb.core.db.service.exclude;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import com.ejb.core.db.config.EJBProperties;
import com.mongodb.MongoClient;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MongoClientProvider {

	private MongoClient mongoClient = null;

	@EJB
	EJBProperties properties;

	//@Lock(LockType.READ)
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	@PostConstruct
	public void init() {
		String mongoIpAddress = properties.getProperty("mongo.ip");
		Integer mongoPort = Integer.parseInt(properties.getProperty("mongo.port"));
		mongoClient = new MongoClient(mongoIpAddress, mongoPort);

	}

}
