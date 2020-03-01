package com.kmboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SiteConfig {

	private String title;

	private String description;

	private String contactName;

	private String contactEmail;

	private String contactLinkUrl;

	private String version;

	public static String getDomain(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		String contextPath = request.getServletContext().getContextPath();
		return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
	}
	
	public static String getContextPath() {
		return "";
	}
	
	public static String getFullPath() {
		return "";
	}

}
