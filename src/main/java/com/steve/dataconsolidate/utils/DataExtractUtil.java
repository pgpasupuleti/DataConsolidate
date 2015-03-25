package com.steve.dataconsolidate.utils;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.steve.dataconsolidate.beans.InputDataBean;
import com.steve.dataconsolidate.beans.UserBean;
import com.steve.dataconsolidate.common.DCNoticeCodeBase;
import com.steve.dataconsolidate.exceptions.DCException;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class DataExtractUtil {
	
	/**
	 * @param inputDataBean
	 * @return
	 * @throws DCException
	 */
	@SuppressWarnings("resource")
	public static List<UserBean> extractData(InputDataBean inputDataBean) throws DCException {
		List<UserBean> userBeans = null;
		String inputFilePath = inputDataBean.getDataFilePath();
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(inputFilePath));
			List<String[]> rows = csvReader.readAll();
			if (rows.size() == 0) {
				throw new DCException(DCNoticeCodeBase.NO_RECORDS_FOUND_IN_FILE);
			}
			userBeans = new ArrayList<UserBean>(rows.size());
			UserBean userBean = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/dd/mm");
			for (String[] row : rows) {
				String[] rowData = row[0].split("\t");
				if (rowData.length != 1) {
					userBean = new UserBean();
					userBean.setPersonKey(rowData[0]);
					userBean.setFirstName(rowData[1]);
					userBean.setLastName(rowData[2]);
					userBean.setEmail(rowData[3]);
					userBean.setCreationDate(dateFormat.parse(rowData[4]));
					userBeans.add(userBean);
					userBean = null;
				}
			}
		} catch(DCException e){
			throw e;
		} catch(Exception e) {
			throw new DCException(DCNoticeCodeBase.DATA_EXTRACTION_FAILED, e, e.getMessage());
		}
		return userBeans;
	}
}