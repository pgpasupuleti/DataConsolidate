package com.steve.dataconsolidate.services;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public interface DataConsolidateService {
	
	/**
	 * @param inputDataBean
	 * @return
	 * @throws DCException
	 */
	public boolean readProcessAndStoreData(InputDataBean inputDataBean) throws DCException;
}
