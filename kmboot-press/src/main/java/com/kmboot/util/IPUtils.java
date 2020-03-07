package com.kmboot.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
	private static final List<String> IP_HEADERS = Arrays.asList("X-Forwarded-For", "Proxy-Client-IP",
			"WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR");

	public static String getClientIpAddress(HttpServletRequest request) {
		return IP_HEADERS.stream().map(request::getHeader).filter(Objects::nonNull)
				.filter(ip -> !ip.isEmpty() && !ip.equalsIgnoreCase("unknown")).findFirst()
				.orElseGet(request::getRemoteAddr);
	}
}
