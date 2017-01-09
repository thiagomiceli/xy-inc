package com.zup.zupapp.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.zup.zupapp.dao.ModelRepositoryCustom;
import com.zup.zupapp.domain.Model;


/**
 * @author thiagomiceli
 * Interface used to define custom queries for Model
 *
 */
public interface ModelRepository extends MongoRepository<Model, String>, ModelRepositoryCustom {
	
	/**
	 * Fetch Model by name
	 * @param modelName - the name of the Model
	 * @return the retrieved Model
	 */
	public Model findByNameIgnoreCase(String modelName);
	
	/**
	 * Fetch Model by id
	 * @param id - of the Model
	 * @return the retrieved Model
	 */
	public Model findById(String id);
}


