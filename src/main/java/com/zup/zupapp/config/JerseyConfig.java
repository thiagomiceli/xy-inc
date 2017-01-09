package com.zup.zupapp.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.zup.zupapp.jersey.InstanceResource;
import com.zup.zupapp.jersey.ModelResource;

/**
 * @author thiagomiceli
 * Class to configure the jersey
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	/**
	 * mehtod used to register all the jersey resources
	 */
	public JerseyConfig() {
		register(ModelResource.class);
		register(InstanceResource.class);
	}

}
