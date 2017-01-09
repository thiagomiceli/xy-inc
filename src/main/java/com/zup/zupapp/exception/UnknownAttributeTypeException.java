package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when an unknown attribute is found
 *
 */
public class UnknownAttributeTypeException extends WebApplicationException {

	private static final long serialVersionUID = 6783721006476826717L;

	/**
	 * Constructor
	 * @param attributeName - name of the attribute
	 * @param attributeType - type of the attribute
	 */
	public UnknownAttributeTypeException(final String attributeName, final String attributeType) {
		super("Sorry but... the attribute " + attributeName + " has an unrecognized type of '"
				+ attributeType + "'.");
	}
	
	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}