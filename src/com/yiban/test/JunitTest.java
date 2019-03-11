package com.yiban.test;

import java.security.Key;
import java.util.Date;

import org.junit.Test;

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
       String token = JWTUtil.generToken("xiaoming");
       System.out.println(token);
       
       Claims claims = JWTUtil.verifyToken(token);
       System.out.println(claims.getSubject());
       
       token = JWTUtil.updateToken(token);
       System.out.println(token);
	}
}
