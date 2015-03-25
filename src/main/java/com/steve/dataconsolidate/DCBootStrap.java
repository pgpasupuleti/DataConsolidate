package com.steve.dataconsolidate;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.entity.CourseEntity;
import com.steve.dataconsolidate.entity.UserCourseEntity;
import com.steve.dataconsolidate.entity.UserEntity;
import com.steve.dataconsolidate.services.DataConsolidationService;
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
	private static DataConsolidationService dataConsolidateService;
	
	public static void main(String[] args) {
		try {
			//getError();
			
			String[] path = {"classpath*:META-INF/spring/applicationContext.xml"};
			ApplicationContext applicaitonContext = new ClassPathXmlApplicationContext(path);
			genericEntityService = applicaitonContext.getBean(GenericEntityService.class);
			dataConsolidateService = applicaitonContext.getBean(DataConsolidationService.class);
			
			
			dataConsolidateService.readProcessAndStoreData(getInputDataBean());
			
			
			/*UserEntity userEntity = (UserEntity)genericEntityService.createEntity(getUserData());
			int userId = userEntity.getUserId();
			
			CourseEntity courseEntity = (CourseEntity)genericEntityService.createEntity(getCourse());
			int courseId = courseEntity.getCourseId();
			
			UserCourseEntity userCourseEntity = (UserCourseEntity) genericEntityService.createEntity(getUserCourse(userId, courseId));
			System.out.println("======DONE=====");*/
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	//-------------HELPERES---------------
	
	private static InputDataBean getInputDataBean(){
		InputDataBean inputDataBean = new InputDataBean();
		inputDataBean.setDataFilePath("/Users/paspr01/Praveen/projects/Steve/src/main/resources/dataFile.txt");
		return inputDataBean;
	}
	private static UserEntity getUserData(){
		UserEntity userEntity = new UserEntity();
		userEntity.setPersonKey("PersonKey");
		userEntity.setEmail("emailAddress");
		userEntity.setFirstName("Firstname");
		userEntity.setLastName("lastName");
		Calendar calendar = Calendar.getInstance();
		userEntity.setCreationDate(calendar.getTime());
		userEntity.setLastUpdateDate(calendar.getTime());
		return userEntity;
	}
	
	private static CourseEntity getCourse(){
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseName("courseName");
		Calendar calendar = Calendar.getInstance();
		courseEntity.setCreationDate(calendar.getTime());
		courseEntity.setLastUpdateDate(calendar.getTime());
		return courseEntity;
	}
	
	private static UserCourseEntity getUserCourse(int userId, int courseId){
		UserCourseEntity userCourseEntity = new UserCourseEntity();
		userCourseEntity.setCourseId(courseId);
		userCourseEntity.setUserId(userId);
		Calendar calendar = Calendar.getInstance();
		userCourseEntity.setCreationDate(calendar.getTime());
		userCourseEntity.setLastUpdateDate(calendar.getTime());
		userCourseEntity.setCompletionDate(calendar.getTime());
		return userCourseEntity;
	}
}