package com.steve.dataconsolidate.beans;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import com.steve.dataconsolidate.entity.Project;
import com.steve.dataconsolidate.exceptions.DCException;
import com.steve.dataconsolidate.utils.JsonUtil;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class ProjectBean extends BaseBean {
	
	private int projectNumber;
	private String projectName;
	private String projectDescription;
	private String location;
	private Double budget;
	private Date startDate;
	private Date endDate;
	private String contractAgent;
	private String projectManager;
	private String contractor;
	private String phoneNumber;

	/**
	 * @return the projectNumber
	 */
	public int getProjectNumber() {
		return projectNumber;
	}

	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectDescription
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * @param projectDescription the projectDescription to set
	 */
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the budget
	 */
	public Double getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the contractAgent
	 */
	public String getContractAgent() {
		return contractAgent;
	}

	/**
	 * @param contractAgent the contractAgent to set
	 */
	public void setContractAgent(String contractAgent) {
		this.contractAgent = contractAgent;
	}

	/**
	 * @return the projectManager
	 */
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager the projectManager to set
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the contractor
	 */
	public String getContractor() {
		return contractor;
	}

	/**
	 * @param contractor the contractor to set
	 */
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toEntity()
	 */
	@Override
	public Object toEntity() throws DCException {
		Project project = new Project();
		project.setBudget(this.budget);
		project.setContractAgent(this.contractAgent);
		project.setContractor(this.contractor);
		project.setEndDate(this.endDate);
		project.setLocation(this.location);
		project.setPhoneNumber(this.phoneNumber);
		project.setProjectDescription(this.projectDescription);
		project.setProjectManager(this.projectManager);
		project.setProjectName(this.projectName);
		project.setProjectNumber(this.projectNumber);
		project.setStartDate(this.startDate);
		return project;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toBean(java.lang.Object)
	 */
	@Override
	public void toBean(Object object) throws DCException {
		Project project = (Project) object;
		this.setBudget(project.getBudget());
		this.setContractAgent(project.getContractAgent());
		this.setContractor(project.getContractor());
		this.setEndDate(project.getEndDate());
		this.setLocation(project.getLocation());
		this.setPhoneNumber(project.getPhoneNumber());
		this.setProjectDescription(project.getProjectDescription());
		this.setProjectManager(project.getProjectManager());
		this.setProjectName(project.getProjectName());
		this.setProjectNumber(project.getProjectNumber());
		this.setStartDate(project.getStartDate());
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toJson(java.lang.Object)
	 */
	@Override
	public Object toJson() throws DCException {
		JsonObjectBuilder result =  Json.createObjectBuilder();
		JsonUtil.putSafe(result, "budget", this.getBudget().toString());
		JsonUtil.putSafe(result, "contractAgent", this.getContractAgent());
		JsonUtil.putSafe(result, "contractor", this.getContractor());
		JsonUtil.putSafe(result, "endDate", this.getEndDate());
		JsonUtil.putSafe(result, "location", this.getLocation());
		JsonUtil.putSafe(result, "phoneNumber", this.getPhoneNumber());
		JsonUtil.putSafe(result, "projectDescription", this.getProjectDescription());
		JsonUtil.putSafe(result, "projectManager", this.getProjectManager());
		JsonUtil.putSafe(result, "projectName", this.getProjectName());
		JsonUtil.putSafe(result, "projectNumber", this.getProjectNumber());
		JsonUtil.putSafe(result, "startDate", this.getStartDate());
		return result;
	}
}