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

import com.zup.zupapp.domain.Model;
import com.zup.zupapp.exception.ModelAlreadyExistsException;
import com.zup.zupapp.exception.ModelDoesNotExistsException;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.repository.ModelRepository;

/**
 * @author thiagomiceli
 * Jersey resource of Models
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/models")
public class ModelResource {
	/**
	 * Logger 
	 */
	private static final Logger logger = LoggerFactory.getLogger(ModelResource.class);

	/**
	 * Injected instance of ModelRepository
	 */
	@Autowired
	ModelRepository modelRepository;

	/**
	 * Get all instances of Model
	 * @return the models
	 */
	@GET
	public List<Model> getAllModels() {
		logger.debug("getAllModels...");
		List<Model> models = this.modelRepository.findAll();
		return models;
	}
	
	/**
	 * Get one specific model
	 * @param id - of the model
	 * @return the retrieved model
	 */
	@GET
	@Path("/{id}")
	public Model getOneModel(@PathParam("id") String id) {
		logger.debug("getOneModelInstance...");
		Model model = this.modelRepository.findById(id);
		return model;
	}

	/**
	 * Save a model
	 * @param model - model to be saved
	 * @return - the new model
	 * @throws UnknownAttributeTypeException - launched when the model has an unknown attribute
	 * @throws ModelAlreadyExistsException  - launched when the model already exists
	 */
	@POST
	public Model save(Model model) throws UnknownAttributeTypeException, ModelAlreadyExistsException {
		logger.debug("saving model...");
		Model newModel = this.modelRepository.saveModel(model);
		logger.debug("model saved... " + model.getName());
		return newModel;
	}

	/**
	 * Update a model
	 * @param nameModel - name of the model
	 * @param id - id of the model to be updated
	 * @param model - the new model
	 * @return updated model
	 * @throws UnknownAttributeTypeException - launched when the model has an unknown attribute
	 * @throws ModelDoesNotExistsException - launched when the model does not exists
	 */
	@PUT
	@Path("/{id}")
	public Model update(@PathParam("nomeModelo") String nameModel, @PathParam("id") String id, Model model)
			throws UnknownAttributeTypeException, ModelDoesNotExistsException {
		logger.debug("updating Model... " + id);
		Model newModel = this.modelRepository.updateModel(id, model);
		logger.debug("model " + id + "updated.");
		return newModel;
	}

	/**
	 * Delete a Model 
	 * @param id - of the model to be deleted
	 * @throws ModelDoesNotExistsException - launched when the model does not exists
	 */
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") String id) throws ModelDoesNotExistsException {
		Model model = this.modelRepository.findById(id);
		if (model != null) {
			this.modelRepository.delete(model);
			logger.debug("model deleted... " + id);
		} else {
			throw new ModelDoesNotExistsException(id);
		}
	}

}
