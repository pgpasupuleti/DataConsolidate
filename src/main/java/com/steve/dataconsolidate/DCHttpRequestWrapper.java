package com.steve.dataconsolidate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;


public class DCHttpRequestWrapper extends HttpServletRequestWrapper {
	private final byte[] body;
	private final String requestURL;

	protected static final Logger logger = Logger.getLogger(DCHttpRequestWrapper.class);

	public DCHttpRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = org.apache.commons.io.IOUtils.toByteArray(request.getInputStream());	
		requestURL = request.getRequestURL().toString();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				body);
		ServletInputStream servletInputStream = new ServletInputStream() {
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}
		};
		return servletInputStream;
	}
	
	public void logTextPayload() throws UnsupportedEncodingException{
		String decoded = new String(body, "UTF-8");
		logger.trace("Request body: " + decoded);
	}
	
	public void logRequestURL() throws UnsupportedEncodingException{			
		logger.trace("Request URL: " + requestURL);		
	}

	
}

