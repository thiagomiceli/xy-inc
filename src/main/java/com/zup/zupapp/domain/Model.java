package com.zup.zupapp.domain;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.data.annotation.Id;

/**
 * @author thiagomiceli
 * POJO to store the instances of Model
 *
 */
public class Model implements Serializable {

	private static final long serialVersionUID = 584170817465544559L;

	/**
	 * store the id of the object
	 */
	@Id
	private String id;

	/**
	 * Model name 
	 */
	private String name;
	
	/**
	 * HashMap to store pairs of attributeName-attributeType
	 */
	private HashMap<String, String> attributes;


	/**
	 * Default constructor
	 */
	public Model() {
	}

	/**
	 * Constructor
	 * @param name - of the model
	 * @param attributes - of the model
	 */
	public Model(String name, HashMap<String, String> attributes) {
		this.name = name;
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAtributos(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return String.format("Modelo [id=%s, nome='%s', atributos='%s']", id, name, attributes.toString());
	}

}
