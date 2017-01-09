package com.zup.zupapp.domain;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.data.annotation.Id;

/**
 * @author thiagomiceli
 * POJO to store the instances of Instance
 *
 */
public class Instance implements Serializable {

	private static final long serialVersionUID = 6476459694853556243L;

	/**
	 * store the id of the object
	 */
	@Id
	private String id;

	/**
	 * model name
	 */
	private String modelName;
	
	/**
	 * HashMap to store pairs of attribute-value
	 */
	private HashMap<String, String> attributes;
	
	/**
	 * Default constructor
	 */
	public Instance() {
	}
	
	/**
	 * Contructor
	 * @param modelName - name of the Model
	 * @param attributes - attributes of model
	 */
	public Instance(String modelName, HashMap<String, String> attributes) {
		this.attributes = attributes;
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public String toString() {
		return String.format(modelName + " [id=%s, valores='%s']", id, attributes.toString());
	}
	
	
}
