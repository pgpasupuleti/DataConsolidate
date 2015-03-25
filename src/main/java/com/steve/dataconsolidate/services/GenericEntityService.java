package com.steve.dataconsolidate.services;

import java.util.List;

import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
@SuppressWarnings("rawtypes")
public interface GenericEntityService {

	/**
	 * @param Obejct o
	 * @return
	 * @throws DCException
	 */
	public Object createEntity(Object o) throws DCException;
	
	
	/**
	 * @param Object o
	 * @return
	 * @throws DCException
	 */
	public Object updateEntity(Object o) throws DCException;
	
	/**
	 * @param id
	 * @param clazz
	 * @return
	 * @throws DCException
	 */
	public Object deleteEntity(Integer id, Class clazZ) throws DCException;
	
	/**
	 * @param id
	 * @param clazz
	 * @return
	 * @throws DCException
	 */
	public Object getEntity(Integer id, Class clazz) throws DCException;
	
	
	/**
	 * @param criteria
	 * @param clazz
	 * @return
	 * @throws DCException
	 */
	public List<Object> getEntities(String criteria, Class clazz) throws DCException;
	
}
