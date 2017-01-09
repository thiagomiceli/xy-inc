package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when a parameter is missing 
 *
 */
public class MissingParameterException extends WebApplicationException {

	private static final long serialVersionUID = 5784336334334603603L;

	/**
	 * Constructor 
	 * @param resourceName - name of the resource
	 * @param resourceMethod - name of the method
	 */
	public MissingParameterException(final String resourceName, final String resourceMethod) {
		super("Ops... there is a missing parameter calling the resource '" + resourceName + "' on '" + resourceMethod
				+ "'.");
	}

	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}