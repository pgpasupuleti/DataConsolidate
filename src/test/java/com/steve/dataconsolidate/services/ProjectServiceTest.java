package com.steve.dataconsolidate.services;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.steve.dataconsolidate.common.DCConfig;
import com.steve.dataconsolidate.entity.Project;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class ProjectServiceTest {

	private Logger log = Logger.getLogger(ProjectServiceTest.class);
	
	@Autowired
	private static GenericEntityService genericEntityService;
	
	@Autowired
	private DCConfig dcConfig;
	
	@Before
	public void setUp(){
		String[] path = {"classpath*:META-INF/spring/applicationContext-test.xml"};
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		genericEntityService = applicationContext.getBean(GenericEntityService.class);
		//dataConsolidateService = applicationContext.getBean(DataConsolidateService.class);
		dcConfig = applicationContext.getBean(DCConfig.class);
	}
	
	@AfterClass
	public static void tearDown(){
	}
	
	//-----------Test Case------------
	//@Test
	public void testProjectCreate(){
		try {
			genericEntityService.createEntity(getProject());
			Assert.assertTrue(true);
		} catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void testGetProjects(){
		try {
			List<Project> projects = (List)genericEntityService.getEntities("O.projectName = 'DCE'", Project.class);
			System.out.println(projects.size());
		}catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	private static Project getProject(){
		Project project = new Project();
		project.setBudget(100.00);
		project.setContractAgent("Praveen");
		project.setContractor("Praveen");
		Calendar calendar = Calendar.getInstance();
		project.setEndDate(calendar.getTime());
		project.setStartDate(calendar.getTime());
		project.setLocation("India");
		project.setPhoneNumber("00000000");
		project.setProjectDescription("project desc");
		project.setProjectManager("Praveen");
		project.setProjectName("DCE");
		
		return project;
	}
}
