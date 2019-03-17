package com.yiban.dao;

import com.yiban.bean.ApplyBean;

public interface ApplyMapper {
	
	public int doCreate(ApplyBean apply);
	
	public ApplyBean doSelect(Integer applyId);
	
	public int doDelete(Integer applyId);
	
	public int doUpdate(ApplyBean apply);
}
