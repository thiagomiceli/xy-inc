package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when an Instance already exixts
 *
 */
public class InstanceAlreadyExistsException extends WebApplicationException {

	private static final long serialVersionUID = 2808875238558376812L;

	/**
	 * Constructor
	 * @param instanceName - name of the instance
	 */
	public InstanceAlreadyExistsException(final String instanceName) {
		super("Ops... the instance '" + instanceName + "' already exists.");
	}

	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}