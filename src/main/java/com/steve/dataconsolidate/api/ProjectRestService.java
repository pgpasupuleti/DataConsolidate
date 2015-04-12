	package com.steve.dataconsolidate.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steve.dataconsolidate.entity.Project;
import com.steve.dataconsolidate.exceptions.DCException;
import com.steve.dataconsolidate.services.ProjectService;
import com.steve.dataconsolidate.services.impl.ProjectServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author Praveen kumar Pasupuleti
 *
 */
@Service
@Path("/project")
@Api(value="/project", description = "project Services", position=1)
public class ProjectRestService {

	private Logger log = Logger.getLogger(ProjectRestService.class);
	
	@Autowired
	private  ProjectService projectService;

	@Path("/list")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "<b>ProjectName:</b> getProjets"
			+ "<br><b>Description</b>:  Get the projects",
			position = 1, response = Project.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 403, message = "Forbidden if no privilege"),
			@ApiResponse(code = 500, message = "Internal Error")
	})
	public Response getProjects(
			@ApiParam(value = "Project name", required = false) @QueryParam("projectName") String projectName) throws DCException {
		Response response = projectService.getProject(projectName);
		return response;
	}
}
