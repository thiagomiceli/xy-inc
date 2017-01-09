package com.zup.zupapp.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.zup.zupapp.domain.Instance;
import com.zup.zupapp.domain.Model;
import com.zup.zupapp.exception.InstanceAlreadyExistsException;
import com.zup.zupapp.exception.InstanceDoesNotExistsException;
import com.zup.zupapp.exception.MissingParameterException;
import com.zup.zupapp.exception.ModelDoesNotExistsException;
import com.zup.zupapp.exception.UnknownAttributeTypeException;
import com.zup.zupapp.repository.InstanceRepository;
import com.zup.zupapp.repository.ModelRepository;
import com.zup.zupapp.utils.ZupAppUtils;

public class InstanceRepositoryImpl implements InstanceRepositoryCustom {

	/**
	 * injected reference for access ModelRepository
	 */
	@Autowired
	ModelRepository modelRepository;

	/**
	 * injected reference for access InstanceRepository
	 */
	@Autowired
	InstanceRepository instanceRepository;

	@Override
	public Instance saveInstance(Instance instance) throws UnknownAttributeTypeException, InstanceAlreadyExistsException,
			MissingParameterException, ModelDoesNotExistsException {
		if (instance.getModelName() == null || instance.getAttributes() == null) {
			throw new MissingParameterException("InstanceResource", "save");
		}
		if (instance.getId() == null) {
			Model model = modelRepository.findByNameIgnoreCase(instance.getModelName());
			if (model != null) {
				ZupAppUtils.validateAttributeValues(model.getAttributes(), instance.getAttributes());
				return instanceRepository.save(instance);
			} else {
				throw new ModelDoesNotExistsException(instance.getModelName());
			}
		} else {
			throw new InstanceAlreadyExistsException(instance.getId());
		}
	}

	@Override
	public Instance updateInstance(String id, Instance instance)
			throws UnknownAttributeTypeException, InstanceDoesNotExistsException, MissingParameterException {
		if (instance.getModelName() == null || instance.getAttributes() == null) {
			throw new MissingParameterException("InstanceResource", "update");
		}
		if (this.instanceRepository.findById(id) != null) {
			Model model = modelRepository.findByNameIgnoreCase(instance.getModelName());
			if (model != null) {
				// logger.debug("updatingProduct>> " + id);
				ZupAppUtils.validateAttributeValues(
						modelRepository.findByNameIgnoreCase(instance.getModelName()).getAttributes(),
						instance.getAttributes());
				instance.setId(id);
				this.instanceRepository.save(instance);
				// logger.debug("product>>" + id + "updated.");
				return instance;
			} else {
				throw new ModelDoesNotExistsException(instance.getModelName());
			}

		} else {
			throw new InstanceDoesNotExistsException(id);
		}
	}

}
