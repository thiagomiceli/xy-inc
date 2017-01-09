package com.zup.zupapp.dao;

import com.zup.zupapp.domain.Instance;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.exception.InstanceAlreadyExistsException;
import com.zup.zupapp.exception.InstanceDoesNotExistsException;
import com.zup.zupapp.exception.MissingParameterException;
import com.zup.zupapp.exception.ModelDoesNotExistsException;

/**
 * @author thiagomiceli
 * Interface for custom CRUD methods of Instances 
 *
 */
public interface InstanceRepositoryCustom {

	/**
	 * Custom method to save instances
	 * 
	 * @param instance - to be saved
	 * @return the saved instance
	 * @throws UnknownAttributeTypeException  - Exception to be launched when a unknown type of attribute is used
	 * @throws InstanceAlreadyExistsException - Exception to be launched when an instance already exists
	 * @throws MissingParameterException - Exception to be launched when an parameter is missing
	 * @throws ModelDoesNotExistsException - Exception to be launched when an model does not exists
	 */
	public Instance saveInstance(final Instance instance) throws UnknownAttributeTypeException,
			InstanceAlreadyExistsException, MissingParameterException, ModelDoesNotExistsException;

	/**
	 * @param id - of the instance to be updated
	 * @param instance - new instance model to be updated
	 * @return the updated instance
	 * @throws UnknownAttributeTypeException  - Exception to be launched when a unknown type of attribute is used
	 * @throws MissingParameterException - Exception to be launched when an parameter is missing
	 * @throws ModelDoesNotExistsException - Exception to be launched when an model does not exists
	 */
	public Instance updateInstance(final String id, final Instance instance)
			throws UnknownAttributeTypeException, InstanceDoesNotExistsException, MissingParameterException;

}
