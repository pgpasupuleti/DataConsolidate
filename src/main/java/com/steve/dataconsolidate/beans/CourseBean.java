package com.steve.dataconsolidate.beans;

import java.util.Date;

import com.steve.dataconsolidate.entity.CourseEntity;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class CourseBean extends BaseBean {
	
	private Integer courseId;
	
	private String courseName;
	
	private Date creationDate;
	
	private Date lastModifiedDate;
	
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toEntity()
	 */
	@Override
	public Object toEntity() throws DCException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseId(this.courseId);
		courseEntity.setCourseName(this.courseName);
		courseEntity.setCreationDate(this.creationDate);
		courseEntity.setLastUpdateDate(this.lastModifiedDate);
		return courseEntity;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toBean(java.lang.Object)
	 */
	@Override
	public void toBean(Object object) throws DCException {
		CourseEntity courseEntity = (CourseEntity) object;
		this.courseId = courseEntity.getCourseId();
		this.courseName = courseEntity.getCourseName();
		this.creationDate = courseEntity.getCreationDate();
		this.lastModifiedDate = courseEntity.getLastUpdateDate();
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toJson()
	 */
	@Override
	public Object toJson() throws DCException {
		return null;
	}
	
}