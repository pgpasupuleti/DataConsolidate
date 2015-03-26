package com.steve.dataconsolidate.services;


import java.io.File;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.common.DCConfig;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class DataConsolidateServiceTest {

	private Logger log = Logger.getLogger(DataConsolidateServiceTest.class);
	
	@Autowired
	private GenericEntityService genericEntityService;
	
	@Autowired
	private DataConsolidateService dataConsolidateService;
	
	@Autowired
	private DCConfig dcConfig;
	
	@Before
	public void setUp(){
		String[] path = {"classpath*:META-INF/spring/applicationContext-test.xml"};
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		genericEntityService = applicationContext.getBean(GenericEntityService.class);
		dataConsolidateService = applicationContext.getBean(DataConsolidateService.class);
		dcConfig = applicationContext.getBean(DCConfig.class);
	}
	
	@AfterClass
	public static void tearDown(){

	}
	
	//---------Test cases -------------
	@Test
	public void testReadProcessNStoreData(){
		try {
			boolean result = dataConsolidateService.readProcessAndStoreData(getInputDataBean());
			if (result) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true);
			}
			
		}catch(DCException e){
			Assert.assertFalse(true);
		}
	}
	
	//---------Negative Test cases -------------
	
	
	//---------HELPERS----------------
	private InputDataBean getInputDataBean(){
		InputDataBean inputDataBean = new InputDataBean();
		String inputDataDirPath = dcConfig.getInputDataDirPath();
		inputDataBean.setDataFilePath(inputDataDirPath + File.separator + "dataFile.txt");
		return inputDataBean;
	}
}
