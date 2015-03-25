package com.steve.dataconsolidate.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.beans.UserBean;
import com.steve.dataconsolidate.common.DCNoticeCodeBase;
import com.steve.dataconsolidate.exceptions.DCException;
import com.steve.dataconsolidate.services.DataConsolidateService;
import com.steve.dataconsolidate.services.GenericEntityService;
import com.steve.dataconsolidate.utils.DataExtractUtil;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
@Service("dataConsolidateService")
public class DataConsolidateServiceImpl implements DataConsolidateService {

	private Logger log = Logger.getLogger(DataConsolidateServiceImpl.class);
	
	@Autowired
	private GenericEntityService genericEntityService;
	
	/* (non-Javadoc)
	 * @see com.steve.dataconsolidate.services.DataConsolidationService#readProcessAndStoreData(com.steve.dataconsolidate.beans.InputDataBean)
	 */
	@Override
	public boolean readProcessAndStoreData(InputDataBean inputDataBean) throws DCException {
		String logMsg = "DataConsolidateServiceImpl:readAndStoreData:";
		log.debug( logMsg + "Entry");
		try {
			if(isValidData(inputDataBean)){
				List<UserBean> userBeans = DataExtractUtil.extractData(inputDataBean);
				for (UserBean userBean : userBeans) {
					genericEntityService.createEntity(userBean.toEntity());
				}
			}
			return true;
		} catch(DCException e) {
			throw e;
		} catch (Exception e) {
			throw new DCException(DCNoticeCodeBase.DB_CONNECTION_FAILED, e, e.getMessage());
		}
	}
	//-------------HELPERS--------------
	private boolean isValidData(InputDataBean inputDataBean) throws DCException {
		//FIXME: Add validations for the input file.
		return true;
	}
}