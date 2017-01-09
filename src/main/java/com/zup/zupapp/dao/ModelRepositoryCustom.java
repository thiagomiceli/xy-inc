package com.zup.zupapp.dao;

import com.zup.zupapp.domain.Model;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.exception.ModelAlreadyExistsException;
import com.zup.zupapp.exception.ModelDoesNotExistsException;

/**
 * @author thiagomiceli
 * Interface for custom CRUD methods of Models 
 */
public interface ModelRepositoryCustom {
	
	/**
	 * @param model - to be saved
	 * @return the saved model
	 * @throws UnknownAttributeTypeException - Exception to be launched when a unknown type of attribute is used
	 * @throws ModelAlreadyExistsException -  Exception to be launched when a model already exists
	 */
	public Model saveModel(final Model model) throws UnknownAttributeTypeException, ModelAlreadyExistsException;
	
	/**
	 * @param id - of the model to be updated
	 * @param model - to be updated
	 * @return the new model
	 * @throws UnknownAttributeTypeException - Exception to be launched when a unknown type of attribute is used
	 * @throws ModelAlreadyExistsException -  Exception to be launched when a model already exists
	 */
	public Model updateModel(final String id, final Model model) throws UnknownAttributeTypeException, ModelDoesNotExistsException;
}
