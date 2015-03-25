package com.steve.dataconsolidate.beans;

import java.util.Date;

import com.steve.dataconsolidate.entity.UserEntity;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class UserBean extends BaseBean {
	
	private Integer userId;
	
	private String personKey;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date lastModifiedDate;
	
	private Date creationDate;

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
	 * @return the personKey
	 */
	public String getPersonKey() {
		return personKey;
	}

	/**
	 * @param personKey the personKey to set
	 */
	public void setPersonKey(String personKey) {
		this.personKey = personKey;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toEntity(java.lang.Object)
	 */

	@Override
	public Object toEntity() throws DCException {
		UserEntity userEntity = new UserEntity();
		userEntity.setCreationDate(this.creationDate);
		userEntity.setEmail(this.email);
		userEntity.setFirstName(this.firstName);
		userEntity.setLastName(this.lastName);
		userEntity.setPersonKey(this.personKey);
		userEntity.setLastUpdateDate(this.lastModifiedDate);
		return userEntity;
	}

	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.beans.BaseBean#toBean(java.lang.Object)
	 */
	@Override
	public void toBean(Object object) throws DCException {
		UserEntity userEntity = (UserEntity) object;
		this.creationDate = userEntity.getCreationDate();
		this.email = userEntity.getEmail();
		this.firstName = userEntity.getFirstName();
		this.lastModifiedDate = userEntity.getLastUpdateDate();
		this.lastName = userEntity.getLastName();
		this.personKey = userEntity.getPersonKey();
		this.userId = userEntity.getUserId();
	}
}