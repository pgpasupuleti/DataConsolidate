package com.steve.dataconsolidate.exceptions;

import com.steve.dataconsolidate.common.DCNoticeCodeBase;

/**
 * @author Praveen Kumar Pasupuleti
 *
 */
public class DCException extends Exception {

	private static final long serialVersionUID = -9177443662584616709L;

	protected DCNoticeCodeBase dcNoticeCode = null;
	
	protected String[] messageVars = null;

	public DCException(DCNoticeCodeBase dcNoticeCode){
		super(dcNoticeCode.toString());
		this.dcNoticeCode = dcNoticeCode;
	}
	
	public DCException(DCNoticeCodeBase dcNoticeCode, Throwable t) {
		super(dcNoticeCode.toString(), t);
		this.dcNoticeCode = dcNoticeCode;
	}
	
	public DCException(DCNoticeCodeBase dcNoticeCode, String... messageVars) {
		super(dcNoticeCode.toString((Object[])messageVars));
		this.dcNoticeCode = dcNoticeCode;
		this.messageVars = messageVars;
	}
	
	public DCException(DCNoticeCodeBase dcNoticeCode, Throwable t, String... messageVars) {
		super(dcNoticeCode.toString((Object[])messageVars), t);
		this.dcNoticeCode = dcNoticeCode;
		this.messageVars = messageVars;
	}
	
	public String getErrorCode(){
		return dcNoticeCode.getCode();
	}
}