package com.steve.dataconsolidate.common;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

/**
 * This class is the base class notice codes. Notice Codes encapsulate information
 * about error, warning and info codes and should contain static instances for each notice code
 * 
 * The codes adhere to a 7 digit structure. An example of the structure for the "ProxyFort" project
 * follows: <br> 
 * Product Code = DC<br>
 * Action<br>
 * <i>Fatal error = 1</i><br>
 * <i>Non-fatal error = 5</i><br>
 * <i>Info = 7</i><br>
 * <br>
 * Category<br>
 * <i>Conf = 10</i><br>
 * <i>Input = 11</i><br>
 * <i>Database = 12</i><br>
 * <i>Network/Communication = 13</i><br>
 * <i>OS = 14</i><br>
 * <i>Other = 15</i><br>
 * <br>
 * ErrorCode<br>
 * <i>Two digit error code</i><br>
 * 
 * @author Praveen Kumar Pasupuleti
 * 
 */

public class DCNoticeCodeBase {

	private String code;
	
	private String description;
	
	//-------------Notice codes------------

	//DB Errors
	public static final DCNoticeCodeBase DB_CONNECTION_FAILED = new DCNoticeCodeBase(
			"DC11001", "Data base connection failed. Reason: {0}.");
	
	public static final DCNoticeCodeBase DB_FETCH_DATA_FAILED = new DCNoticeCodeBase(
			"DC11002","Failed to get data. Reason: {1}");
	
	
	//Input Date Read Failures
	
	public static final DCNoticeCodeBase INVALID_INPUT_FILE = new DCNoticeCodeBase(
			"DC11003", "Invalid Input File. Reason: {0}.");
	
	public static final DCNoticeCodeBase NO_RECORDS_FOUND_IN_FILE = new DCNoticeCodeBase(
			"DC11004", "No records found in the input File.");
	
	public static final DCNoticeCodeBase DATA_EXTRACTION_FAILED = new DCNoticeCodeBase(
			"DC11005", "Data extraction failed. Reason: {0}");
	
	public static final DCNoticeCodeBase CREATE_PROJECT_FAILED = new DCNoticeCodeBase(
			"DC11006","Failed to create Project. Reason: {0}");
	
	public static final DCNoticeCodeBase GET_PROJECT_FAILED = new DCNoticeCodeBase(
			"DC11007","Failed to Get Project Details for Project Name {0}. Reason: {1}");
	
	
	
	
	//------------- Getters ------------
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription(Object... args) {
		
		if (args == null) {
			return getDescription();
		}
		return MessageFormat.format(getDescription(), args);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public String toString(){
		return code + " : " + description;
	}
	
	public String toString(Object...args) {
		if(args == null){
			return toString();
		}
		return code + ": " + MessageFormat.format(getDescription(), args);
	}

	//------------- Constructors  ------------
	
	public DCNoticeCodeBase(String code, String description){
		this.code = code;
		if (StringUtils.isNotEmpty(getResourceBundleName())) {
			try {
				this.description = ResourceBundle.getBundle(getResourceBundleName()).getString(code);
				return;
			} catch(MissingResourceException e){
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		this.description = description;
	}
	
	
	public DCNoticeCodeBase(){
		
	}
	
	//-------------Get Properties Bundle------------
	public String getResourceBundleName() {
		return "properties.messages";
	}
}
