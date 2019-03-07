package com.yiban.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class ResultBean {
	// 返回码
	private String code;
	// 返回信息提示
	private String message;
	// 返回的数据
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public static ResultBean success() {
		ResultBean result = new ResultBean();
        result.setCode("1");
        result.setMessage("操作成功");
        return result;
	}
	
	public static ResultBean error(String str) {
		ResultBean result = new ResultBean();
        result.setCode("-1");
        result.setMessage(str);
        return result;
	}
	
	public ResultBean add(String key, Object value){
        this.getData().put(key, value);
        return this;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
