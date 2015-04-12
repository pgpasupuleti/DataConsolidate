package com.steve.dataconsolidate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
@Entity
@Table(name="project")
public class Project implements Serializable{
	
	private static final long serialVersionUID = -6336443872360408128L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_number")
	private int projectNumber;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_desc")
	private String projectDescription;
	
	@Column(name="location")
	private String location;

	@Column(name="budget")
	private Double budget;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="contract_agent")
	private String contractAgent;
	
	@Column(name="project_manager")
	private String projectManager;
	
	@Column(name="contractor")
	private String contractor;
	
	@Column(name="phone_number")
	private String phoneNumber;

	
	/**
	 * 
	 */
	public Project() {
	}

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
}