package com.steve.dataconsolidate.services;

import javax.ws.rs.core.Response;

import com.steve.dataconsolidate.beans.ProjectBean;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public interface ProjectService {
	
	/**
	 * @param projectBean
	 * @return
	 * @throws DCException
	 */
	public Response addProject(ProjectBean projectBean) throws DCException;
	
	/**
	 * @param projectName
	 * @return
	 * @throws DCException
	 */
	public Response getProject(String projectName) throws DCException;
	
	/**
	 * @param searchCriteria
	 * @return
	 * @throws DCException
	 */
	public Response getProjects(String searchCriteria) throws DCException;
	
}
