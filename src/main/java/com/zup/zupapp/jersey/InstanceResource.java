package com.zup.zupapp.jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.zupapp.domain.Instance;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.exception.InstanceAlreadyExistsException;
import com.zup.zupapp.exception.InstanceDoesNotExistsException;
import com.zup.zupapp.repository.InstanceRepository;

/**
 * @author thiagomiceli
 * Jersey resource of Instances
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class InstanceResource {
	
	/**
	 * Logger 
	 */
	private static final Logger logger = LoggerFactory.getLogger(InstanceResource.class);

	/**
	 * Injected instance of InstanceRepository
	 */
	@Autowired
	InstanceRepository instanciaRepository;

	/**
	 * Get all Instances of a Model
	 * @param modelName - name of the model
	 * @return
	 */
	@GET
	@Path("/{modelName}")
	public List<Instance> getAllModelInstances(@PathParam("modelName") String modelName) {
		logger.debug("getAllModelInstances...");
		List<Instance> instancias = this.instanciaRepository.findByModelNameIgnoreCase(modelName);
		return instancias;
	}

	/**
	 * Get one specific Instance
	 * @param modelName - name of the model
	 * @param id - of the Instance
	 * @return
	 */
	@GET
	@Path("/{modelName}/{id}")
	public Instance getOneModelInstance(@PathParam("modelName") String modelName, @PathParam("id") String id) {
		logger.debug("getOneModelInstance...");
		Instance instances = this.instanciaRepository.findById(id);
		return instances;
	}

	/**
	 * Save a new Instance
	 * @param instance - Instance to be saved
	 * @return the new Instance
	 * @throws UnknownAttributeTypeException - launched when an attribute type is unknown
	 * @throws InstanceAlreadyExistsException- launched when an Instance already exists
	 */
	@POST
	@Path("/{modelName}")
	public Instance save(Instance instance) throws UnknownAttributeTypeException, InstanceAlreadyExistsException {
		logger.debug("save instance");
		Instance newInstance = this.instanciaRepository.saveInstance(instance);
		return newInstance;
	}

	/**
	 * Update an specific Instance
	 * @param modelName - name of the model
	 * @param id - of the Instance to be updated
	 * @param instance - the new instance 
	 * @return updated instance
	 * @throws UnknownAttributeTypeException - launched when an attribute type is unknown
	 * @throws InstanceAlreadyExistsException - launched when an Instance already exists
	 */
	@PUT
	@Path("/{modelName}/{id}")
	public Instance update(@PathParam("modelName") String modelName, @PathParam("id") String id, Instance instance)
			throws UnknownAttributeTypeException, InstanceAlreadyExistsException {
		logger.debug("updating instance... " + id);
		Instance newInstance = this.instanciaRepository.updateInstance(id, instance);
		logger.debug("instance " + id + "updated.");
		return newInstance;
	}

	/**
	 * Delete an specific Instance
	 * @param modelName - name of the model
	 * @param id - of the Instance to be deleted
	 * @throws InstanceDoesNotExistsException - launched when Instance not found
	 */
	@DELETE
	@Path("/{modelName}/{id}")
	public void delete(@PathParam("modelName") String modelName, @PathParam("id") String id)
			throws InstanceDoesNotExistsException {
		Instance instance = this.instanciaRepository.findById(id);
		if (instance != null) {
			logger.debug("deleting instance... " + id);
			this.instanciaRepository.delete(instance);
			logger.debug("instance deleted  " + id);
		} else {
			throw new InstanceDoesNotExistsException(id);
		}
	}
}
