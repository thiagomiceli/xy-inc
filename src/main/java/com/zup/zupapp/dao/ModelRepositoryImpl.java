package com.zup.zupapp.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.zup.zupapp.domain.Model;
import com.zup.zupapp.exception.MissingParameterException;
import com.zup.zupapp.exception.ModelAlreadyExistsException;
import com.zup.zupapp.exception.ModelDoesNotExistsException;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.repository.ModelRepository;
import com.zup.zupapp.utils.ZupAppUtils;

public class ModelRepositoryImpl implements ModelRepositoryCustom {

	/**
	 * injected reference for access ModelRepository
	 */
	@Autowired
	ModelRepository modelRepository;

	@Override
	public Model saveModel(final Model model) throws UnknownAttributeTypeException, ModelAlreadyExistsException, MissingParameterException {
		if(model.getName() == null || model.getAttributes() == null) {
			throw new MissingParameterException("ModelResource", "save");
		}
		
		if (model.getId() == null && modelRepository.findByNameIgnoreCase(model.getName()) == null) {
			ZupAppUtils.validateAttributeTypes(model.getAttributes());
			return modelRepository.save(model);
		} else {
			throw new ModelAlreadyExistsException(model.getName());
		}
	}

	@Override
	public Model updateModel(final String id, final Model model)
			throws UnknownAttributeTypeException, ModelDoesNotExistsException {
		if(id == null|| model.getName() == null || model.getAttributes() == null) {
			throw new MissingParameterException("ModelResource", "update");
		}
		if (modelRepository.findById(id) != null) {
			// logger.debug("updating Model... " + id);
			ZupAppUtils.validateAttributeTypes(model.getAttributes());
			model.setId(id);
			this.modelRepository.save(model);
			// logger.debug("model " + id + "updated.");
			return model;
		} else {
			throw new ModelDoesNotExistsException(id);
		}
	}

}
