package com.yiban.test;

import java.applet.Applet;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

	@Autowired
	private ApplyBean apply;
	
	@Test
	public void testPrintMessage() throws Exception {
		System.out.println(apply.hashCode());
	}
}
