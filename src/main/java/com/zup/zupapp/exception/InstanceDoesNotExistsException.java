package com.zup.zupapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author thiagomiceli
 * Exception to be launched when an Instance does not exixts
 *
 */
public class InstanceDoesNotExistsException  extends WebApplicationException {

	private static final long serialVersionUID = -8559895114222268507L;

	/**
	 * Constructor
	 * @param id - of the instance
	 */
	public InstanceDoesNotExistsException(final String id) {
		super("Ops... the instance '" + id + "' does not exists.");
	}

	@Override
	public Response getResponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}