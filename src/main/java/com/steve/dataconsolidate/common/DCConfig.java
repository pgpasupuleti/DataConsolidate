package com.steve.dataconsolidate.common;

import org.springframework.stereotype.Service;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */

@Service("dcConfig")
public class DCConfig {
	
	private String inputDataDirPath;

	/**
	 * @return the inputDataDirPath
	 */
	public String getInputDataDirPath() {
		return inputDataDirPath;
	}

	/**
	 * @param inputDataDirPath the inputDataDirPath to set
	 */
	public void setInputDataDirPath(String inputDataDirPath) {
		this.inputDataDirPath = inputDataDirPath;
	}
}