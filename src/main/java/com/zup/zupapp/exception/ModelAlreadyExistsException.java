package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when an Model already exixts
 *
 */
public class ModelAlreadyExistsException extends WebApplicationException {

	private static final long serialVersionUID = -1801261353581414220L;

	/**
	 * Constructor
	 * @param modelName - name of the Model
	 */
	public ModelAlreadyExistsException(final String modelName) {
		super("Ops... the model '"
				+ modelName + "' already exists.");
	}
	
	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}