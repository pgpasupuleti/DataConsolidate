package com.steve.dataconsolidate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steve.dataconsolidate.exceptions.DCException;
import com.steve.dataconsolidate.persist.GenericDao;
import com.steve.dataconsolidate.services.GenericEntityService;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */

@Service("genericEntityService")
@SuppressWarnings({"unchecked","rawtypes"})
public class GenericEntityServiceImpl implements GenericEntityService {

	@Autowired
	private GenericDao genericDao;
	
	@Override
	public Object createEntity(Object o) throws DCException {
		return genericDao.create(o);
	}

	@Override
	public Object updateEntity(Object o) throws DCException {
		return genericDao.update(o);
	}

	@Override
	public Object deleteEntity(Integer id, Class clazz) throws DCException {
		return genericDao.delete(clazz, id);
	}

	@Override
	public Object getEntity(Integer id, Class clazz) throws DCException {
		return genericDao.get(clazz, id);
	}

	@Override
	public List<Object> getEntities(String criteria, Class clazz) throws DCException {
		return genericDao.find(clazz, criteria);
	}
}
