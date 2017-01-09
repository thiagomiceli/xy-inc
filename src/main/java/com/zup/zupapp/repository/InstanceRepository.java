package com.zup.zupapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zup.zupapp.dao.InstanceRepositoryCustom;
import com.zup.zupapp.domain.Instance;

/**
 * @author thiagomiceli
 * Interface used to define custom queries for Instance
 *
 */
public interface InstanceRepository extends MongoRepository<Instance, String>, InstanceRepositoryCustom {
	
	/**
	 * Fetch Instance by id
	 * @param id - of the Instance 
	 * @return - the retrieved Instance
	 */
	public Instance findById(final String id);

	/**
	 * Fetch Instance by ModelName
	 * @param modelName - the model name
	 * @return the retrieved Instance
	 */
	public List<Instance> findByModelNameIgnoreCase(final String modelName);

}
