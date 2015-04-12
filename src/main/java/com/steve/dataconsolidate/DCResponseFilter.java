package com.steve.dataconsolidate;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class DCResponseFilter implements ContainerResponseFilter {

	private Logger logger = Logger.getLogger(DCResponseFilter.class);
	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		logger.debug("DC Response filter called...");
		ResponseBuilder responseBuilder = Response.fromResponse(response.getResponse());
		responseBuilder.header("X-DCE-Version","1.0");
		response.setResponse(responseBuilder.build());
		return response;
	}	
}
