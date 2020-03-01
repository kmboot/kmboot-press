package com.kmboot.system.model;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.http.HttpStatus;

public class RestResultMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public static final String CODE = "code";

	public static final String MESSAGE = "message";

	public static final String DATA = "data";
	//
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_ERROR = 0;
	public static final int CODE_ERROR_HTTP = -HttpStatus.INTERNAL_SERVER_ERROR.value();

	public RestResultMap() {
		super();
	}

	public RestResultMap(int code, String msg, Object data) {
		super.put(CODE, code);
		super.put(MESSAGE, msg);
		if (Objects.nonNull(data)) {
			super.put(DATA, data);
		}
	}

	public static RestResultMap error(String msg) {
		return RestResultMap.error(msg, null);
	}

	public static RestResultMap error(String msg, Object data) {
		return new RestResultMap(CODE_ERROR, msg, data);
	}

	public static RestResultMap success() {
		return RestResultMap.success("success");
	}

	public static RestResultMap success(String msg, Object data) {
		return new RestResultMap(CODE_SUCCESS, msg, data);
	}

	public static RestResultMap success(String msg) {
		return RestResultMap.success(msg, null);
	}
}
