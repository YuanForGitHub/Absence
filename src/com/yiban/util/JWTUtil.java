package com.yiban.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	// token加密时使用的密钥
	// 一旦得到该密钥也就可以伪造token了
	public static String sercetKey = "YibanAbsence";

	// 代表token的有效时间,
	// JWT由3个部分组成,分别是 头部Header,载荷Payload一般是用户信息和声明,签证Signature一般是密钥和签名
	// 当头部用base64进行编码后一般都会呈现eyJ...形式,而载荷为非强制使用,签证则包含了哈希算法加密后的数据,包括转码后的header,payload和sercetKey
	// 而payload又包含几个部分,issuer签发者,subject面向用户,iat签发时间,exp过期时间,aud接收方。
	public final static long keeptime = 1800000;

	public static String generToken(String subject) {

		long ttlMillis = keeptime;
		
		// 使用Hash256算法进行加密
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		// 获取系统时间以便设置token有效时间
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// JWT生成类,设置生成时间
		JwtBuilder builder = Jwts.builder().setIssuedAt(now);

		// 加入subject
		builder.setSubject(subject);
		
		// 由于Payload是非必须加入的,所以此处省略

		// 进行签名,生成Signature
		builder.signWith(signatureAlgorithm, sercetKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// 返回最终的token结果
		return builder.compact();
	}

	/**
	 * 该函数用于更新token
	 * 
	 * @param token
	 * @return
	 */
	public static String updateToken(String token) {

		// Claims就是包含了我们的Payload信息类
		Claims claims = verifyToken(token);
		String subject = claims.getSubject();

		// 生成新的token,根据现在的时间
		return generToken(subject);
	}

	public static Claims verifyToken(String token) {
		// 将token解密出来,将payload信息包装成Claims类返回
		Claims claims = Jwts.parser().setSigningKey(sercetKey)
				.parseClaimsJws(token).getBody();

		return claims;
	}

}