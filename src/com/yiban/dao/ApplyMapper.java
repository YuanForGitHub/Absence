package com.yiban.dao;

import java.util.List;

import com.yiban.bean.ApplyBean;

public interface ApplyMapper {
	
	public int doCreate(ApplyBean apply);
	
	public ApplyBean doSelect(Integer applyId);
		
	public int doDelete(Integer applyId);
	
	public int doUpdate(ApplyBean apply);
	
	/*权限1：审核干事值班请假 */
	public List<ApplyBean> permissionOne(int departmentId);
	
	/*权限2：审核干部值班请假*/
	public List<ApplyBean> permissionTwo(int departmentId);
	
	/*权限3：审核干事会议活动请假*/
	public List<ApplyBean> permissionThree(int departmentId);
	
	/*权限4：审核干部会议活动请假*/
	public List<ApplyBean> permissionFour(int departmentId);
}
