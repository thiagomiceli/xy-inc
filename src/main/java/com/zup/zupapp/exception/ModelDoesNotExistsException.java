package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when an Model does not exixts
 *
 */
public class ModelDoesNotExistsException extends WebApplicationException {

	private static final long serialVersionUID = -742061383441158072L;

	/**
	 * Constructor
	 * @param id - of the Model
	 */
	public ModelDoesNotExistsException(final String id) {
		super("Ops... the model '" + id + "' does not exists.");
	}

	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}