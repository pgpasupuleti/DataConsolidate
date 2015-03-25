package com.steve.dataconsolidate.services;


import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.steve.dataconsolidate.beans.InputDataBean;
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
	
	@Before
	public void setUp(){
		String[] path = {"classpath*:META-INF/spring/applicationContext-test.xml"};
		ApplicationContext applicaitonContext = new ClassPathXmlApplicationContext(path);
		genericEntityService = applicaitonContext.getBean(GenericEntityService.class);
		dataConsolidateService = applicaitonContext.getBean(DataConsolidateService.class);
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
		inputDataBean.setDataFilePath("/Users/paspr01/Praveen/projects/Steve/src/main/resources/dataFile.txt");
		return inputDataBean;
	}
}
