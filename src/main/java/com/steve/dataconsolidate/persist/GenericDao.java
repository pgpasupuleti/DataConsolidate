package com.steve.dataconsolidate.persist;

import java.io.Serializable;
import java.util.List;

import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public interface GenericDao<T, PK extends Serializable> {
	
	/**
	 * @param instanse
	 * @return
	 * @throws DCException
	 */
	public T create(T instanse) throws DCException;

	/**
	 * @param transientObj
	 * @return
	 * @throws DCException
	 */
	public T update(T transientObj) throws DCException;
	
	/**
	 * @param type
	 * @param id
	 * @throws DCException
	 */
	public boolean delete(Class<T> type, PK id) throws DCException;
	
	/**
	 * @param tableName
	 * @return
	 * @throws DCException
	 */
	public boolean deleteAll(String tableName) throws DCException;
	
	/**
	 * @param type
	 * @param id
	 * @return
	 * @throws DCException
	 */
	public T get(Class<T> type, PK id) throws DCException;
	
	/**
	 * @param type
	 * @param criteria
	 * @return
	 * @throws DCException
	 */
	public List<T> find(Class<T> type, String criteria) throws DCException;
}
