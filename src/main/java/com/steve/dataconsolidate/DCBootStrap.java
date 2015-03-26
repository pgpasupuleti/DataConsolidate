package com.steve.dataconsolidate;

import java.io.File;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.common.DCConfig;
import com.steve.dataconsolidate.common.DCContants;
import com.steve.dataconsolidate.entity.CourseEntity;
import com.steve.dataconsolidate.entity.UserCourseEntity;
import com.steve.dataconsolidate.entity.UserEntity;
import com.steve.dataconsolidate.services.DataConsolidateService;
import com.steve.dataconsolidate.services.GenericEntityService;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class DCBootStrap {
	
	private static Logger log = Logger.getLogger(DCBootStrap.class);
	
	@Autowired
	private static GenericEntityService genericEntityService;
	
	@Autowired
	private static DataConsolidateService dataConsolidateService;
	
	@Autowired
	private static DCConfig dcConfig;
	
	public static void main(String[] args) {
		try {
			String[] path = {"classpath*:META-INF/spring/applicationContext.xml"};
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
			genericEntityService = applicationContext.getBean(GenericEntityService.class);
			dataConsolidateService = applicationContext.getBean(DataConsolidateService.class);
			dcConfig = applicationContext.getBean(DCConfig.class);
			
			dataConsolidateService.readProcessAndStoreData(getInputDataBean());
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	//-------------HELPERES---------------
	private static InputDataBean getInputDataBean(){
		InputDataBean inputDataBean = new InputDataBean();
		String inputDataDirPath = dcConfig.getInputDataDirPath();
		inputDataBean.setDataFilePath(inputDataDirPath + File.separator + DCContants.INPUT_DATA_FILE);
		return inputDataBean;
	}
}