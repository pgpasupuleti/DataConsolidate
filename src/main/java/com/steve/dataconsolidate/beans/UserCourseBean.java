package com.steve.dataconsolidate.beans;

import java.util.Date;

import com.steve.dataconsolidate.entity.UserCourseEntity;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class UserCourseBean extends BaseBean {

	private Integer userCourseId;
	private Integer userId;
	private Integer courseId;
	private Date creationDate;
	private Date lastModifiedDate;
	private Date completionDate;
	
	/**
	 * @return the userCourseId
	 */
	public Integer getUserCourseId() {
		return userCourseId;
	}

	/**
	 * @param userCourseId the userCourseId to set
	 */
	public void setUserCourseId(Integer userCourseId) {
		this.userCourseId = userCourseId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toEntity()
	 */
	@Override
	public Object toEntity() throws DCException {
		UserCourseEntity userCourseEntity = new UserCourseEntity();
		userCourseEntity.setCompletionDate(this.completionDate);
		userCourseEntity.setCourseId(this.courseId);
		userCourseEntity.setUserCourseId(this.userCourseId);
		userCourseEntity.setCreationDate(this.creationDate);
		userCourseEntity.setLastUpdateDate(this.lastModifiedDate);
		userCourseEntity.setUserId(this.userId);
		return userCourseEntity;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toBean(java.lang.Object)
	 */
	@Override
	public void toBean(Object object) throws DCException {
		UserCourseEntity userCourseEntity = (UserCourseEntity)object;
		this.completionDate = userCourseEntity.getCompletionDate();
		this.courseId = userCourseEntity.getCourseId();
		this.creationDate = userCourseEntity.getCreationDate();
		this.lastModifiedDate = userCourseEntity.getLastUpdateDate();
		this.userCourseId = userCourseEntity.getUserCourseId();
		this.userId = userCourseEntity.getUserId();
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toJson()
	 */
	@Override
	public Object toJson() throws DCException {
		return null;
	}
}