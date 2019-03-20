package com.yiban.test;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.yiban.bean.ApplyBean;
import com.yiban.bean.DepartmentBean;
import com.yiban.bean.ResultBean;
import com.yiban.bean.UserBean;
import com.yiban.dao.ApplyMapper;
import com.yiban.db.DBAccess;
import com.yiban.service.ApplyService;
import com.yiban.service.DepartmentService;
import com.yiban.service.UserService;
import com.yiban.util.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import junit.framework.TestCase;

import io.jsonwebtoken.*;

public class JunitTest extends TestCase {

	@Test
	public void testPrintMessage() throws Exception {
		// 调用service层查询
		ApplyService applyService = new ApplyService();
		List<ApplyBean> applys = applyService.selectByUser(1);

		// 返回操作信息
		if (applys != null && !applys.isEmpty()) {
			for(int i=0; i<applys.size(); i++) {
				System.out.println(applys.get(i).getApplyId());
			}
		}
	}
}
