package com.yiban.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.PermissionBean;
import com.yiban.bean.ReviewBean;
import com.yiban.bean.RoleBean;
import com.yiban.bean.UserBean;
import com.yiban.dao.ApplyMapper;
import com.yiban.dao.ReviewMapper;
import com.yiban.dao.UserMapper;
import com.yiban.db.DBAccess;

@Service
public class ApplyService {

	public boolean insert(ApplyBean apply) {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 执行SQL语句
			result = mapper.doCreate(apply);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return ((result > 0) ? true : false);
	}

	public ApplyBean select(Integer applyId) {
		SqlSession sqlsession = null;
		ApplyBean apply = null;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 执行SQL语句
			apply = mapper.doSelect(applyId);
		} catch (Exception e) {
			System.out.println(e);
			return apply;
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return apply;
	}

	/**
	 * 给定userId，返回该用户所能审核的所有申请
	 * 通过判断部门是否一致，权限是否足够
	 */
	public List<ApplyBean> selectByUser(Integer userId) {
		SqlSession sqlSession = null;
		List<ApplyBean> applys = new ArrayList<>();
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();

			// 查询用户
			UserBean user = sqlSession.getMapper(UserMapper.class).doSelect(userId);
			
			// 获取用户department
			int departmentId = user.getDepartment().getDepartmentId();

			// 获取用户permisssionId
			List<PermissionBean> permissions = new ArrayList<>();
			List<RoleBean> roles = user.getRoles();
			for (int i = 0; i < roles.size(); i++) {
				permissions.addAll(roles.get(i).getPermissions());
			}
			
			// 根据permissionId和departmentId选取申请
			for (int i = 0; i < permissions.size(); i++) {
				// 获取权限id
				int permissionId = permissions.get(i).getPermissionId();
				// 查询符合apply，加入list
				switch (permissionId) {
				case 1:
					applys.addAll(sqlSession.getMapper(ApplyMapper.class).permissionOne(departmentId));
					break;
				case 2:
					applys.addAll(sqlSession.getMapper(ApplyMapper.class).permissionTwo(departmentId));
					break;
				case 3:
					applys.addAll(sqlSession.getMapper(ApplyMapper.class).permissionThree(departmentId));
					break;
				case 4:
					applys.addAll(sqlSession.getMapper(ApplyMapper.class).permissionFour(departmentId));
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ApplyService->selectByUser has error: " + e);
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return applys;
	}

	public ApplyBean delete(Integer applyId) {
		SqlSession sqlsession = null;
		ApplyBean apply = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 查询要删除对象
			apply = mapper.doSelect(applyId);
			// 执行删除
			result = mapper.doDelete(applyId);
		} catch (Exception e) {
			System.out.println(e);
			return apply;
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return result > 0 ? apply : null;
	}

	public boolean review(ReviewBean review) {
		SqlSession sqlSession = null;
		ApplyBean apply = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);

			// 查询被审核申请
			apply = mapper.doSelect(review.getApplyId());

			// 保存审核结果
			apply.setIsPass(review.getIsPass());
			apply.setDescription(review.getDescription());

			// 更新bean对象
			result = mapper.doUpdate(apply);

			// 记录审核情况
			if (result > 0) {
				ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
				result = reviewMapper.doCreate(review);
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			sqlSession.close();
		}

		return (result > 0 ? true : false);
	}
}
