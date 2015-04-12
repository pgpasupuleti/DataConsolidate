package com.steve.dataconsolidate.services.impl;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steve.dataconsolidate.beans.ProjectBean;
import com.steve.dataconsolidate.common.DCNoticeCodeBase;
import com.steve.dataconsolidate.entity.Project;
import com.steve.dataconsolidate.exceptions.DCException;
import com.steve.dataconsolidate.services.GenericEntityService;
import com.steve.dataconsolidate.services.ProjectService;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	private Logger log = Logger.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private GenericEntityService genericEntityService;
	
	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.services.ProjectService#addProject(com.steve.dataconsolidate.entity.Project)
	 */
	@Override
	public Response addProject(ProjectBean projectBean) throws DCException {
		String logMsg = "ProjectService:addProject:";
		try {
			log.debug(logMsg + "Entry");
			Project project = (Project)projectBean.toEntity();
			project = (Project) genericEntityService.createEntity(project);
			if(StringUtils.isNotEmpty(project.getPhoneNumber())){
				return Response.ok().build();
			}
		} catch(DCException dceException){
			throw dceException;
		} catch(Exception e){
			throw new DCException(DCNoticeCodeBase.DATA_EXTRACTION_FAILED, e, e.getMessage());
		} finally {
			log.debug(logMsg + "Exit");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.services.ProjectService#getProject(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Response getProject(String projectName) throws DCException {
		String logMsg = "ProjectService:getProject:";
		JsonObjectBuilder result = Json.createObjectBuilder();;
		try {
			log.debug(logMsg + "Entry");
			StringBuilder criteria = new StringBuilder();
			if(StringUtils.isNotEmpty(projectName)){
				criteria.append("O.projectName='"+projectName+"'");
			}
			List<Project> projects = (List)genericEntityService.getEntities(criteria.toString(), Project.class);
			if(CollectionUtils.isNotEmpty(projects)){
				Project project = projects.get(0);
				ProjectBean projectBean = new ProjectBean();
				projectBean.toBean(project);
				result = (JsonObjectBuilder)projectBean.toJson();
			}
		}  catch(DCException dceException){
			throw dceException;
		} catch(Exception e){e.printStackTrace();
			throw new DCException(DCNoticeCodeBase.DATA_EXTRACTION_FAILED, e, e.getMessage());
		} finally {
			log.debug(logMsg + "Exit");
		}
		return Response.ok(result.build().toString()).build();
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.services.ProjectService#getProjects(java.lang.String)
	 */
	@Override
	public Response getProjects(String searchCriteria) throws DCException {
		String logMsg = "ProjectService:getProject:";
		JsonObjectBuilder result = Json.createObjectBuilder();;
		try {
			log.debug(logMsg + "Entry");
			StringBuilder query = null;
			if(StringUtils.isNotEmpty(searchCriteria)){
				query = new StringBuilder();
				query.append("O.projectName=" + searchCriteria);
			}
			List<Project> projects = (List)genericEntityService.getEntities(query.toString(), Project.class);
			if(CollectionUtils.isNotEmpty(projects)){
				for (Project project : projects) {
					ProjectBean projectBean = new ProjectBean();
					projectBean.toBean(project);
					result = (JsonObjectBuilder)projectBean.toJson();
				}
			}
		}  catch(DCException dceException){
			throw dceException;
		} catch(Exception e){
			throw new DCException(DCNoticeCodeBase.DATA_EXTRACTION_FAILED, e, e.getMessage());
		} finally {
			log.debug(logMsg + "Exit");
		}
		return Response.ok(result.build().toString()).build();
	}

}
