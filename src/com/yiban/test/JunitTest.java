package com.yiban.test;

import java.security.Key;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.DepartmentBean;
import com.yiban.bean.UserBean;
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
	public void testPrintMessage() {
	}
}
