package com.steve.dataconsolidate.beans;

import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public abstract class BaseBean {
	
	/**
	 * @param object
	 * @return
	 * @throws DCException
	 */
	public abstract Object toEntity() throws DCException;
	

	/**
	 * @param object
	 * @throws DCException
	 */
	public abstract void toBean(Object object) throws DCException;
	
}
