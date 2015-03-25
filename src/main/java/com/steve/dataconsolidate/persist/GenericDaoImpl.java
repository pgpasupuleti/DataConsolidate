package com.steve.dataconsolidate.persist;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.steve.dataconsolidate.common.DCContants;
import com.steve.dataconsolidate.common.DCNoticeCodeBase;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
@SuppressWarnings("rawtypes")
@Repository("genericDao")
@Transactional(propagation=Propagation.REQUIRED)
public class GenericDaoImpl<T, PK> implements GenericDao {

	private static EntityManagerFactory entityManagerFactory = null;
	
	private static EntityManagerFactory getEMF() { 
		try {
			if (entityManagerFactory == null) {
				synchronized (EntityManagerFactory.class) {
					Map<String, Object> configOverrides = new HashMap<String, Object>();
					entityManagerFactory = Persistence.createEntityManagerFactory(DCContants.PERSITENCE_UNIT_DCE,configOverrides);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityManagerFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object create(Object instanse) throws DCException {
		EntityManager em = getEMF().createEntityManager();
		T rtn = null;
		synchronized (em) {
			try {
				em.getTransaction().begin();
				rtn = em.merge((T) instanse);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				if(em.getTransaction().isActive()){
					em.getTransaction().rollback();
				}
				throw new DCException(DCNoticeCodeBase.DB_CONNECTION_FAILED, e, e.getMessage());
			} finally {
				em.close();
			}
		}
		return rtn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object update(Object transientObj) throws DCException {
		EntityManager em = getEMF().createEntityManager();
		T rtn = null;
		synchronized (em) {
			try {
				em.getTransaction().begin();
				em.merge((T)transientObj);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				if(em.getTransaction().isActive()){
					em.getTransaction().rollback();
				}
				throw new DCException(DCNoticeCodeBase.DB_CONNECTION_FAILED, e, e.getMessage());
			}
		}
		return rtn;
	}

	@Override
	public boolean delete(Class type, Serializable id) throws DCException {
		return false;
	}

	@Override
	public boolean deleteAll(String tableName) throws DCException {
		return false;
	}

	@Override
	public Object get(Class type, Serializable id) throws DCException {
		return null;
	}

	@Override
	public List find(Class type, String criteria) throws DCException {
		return null;
	}

}
