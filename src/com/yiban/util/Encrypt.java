package com.yiban.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 用来加密、解密给定信息；
 * 主要用来加密用户密码
 */
public class Encrypt {
	
	/**
	 * 用md5算法加密
	 * @param input
	 * @return
	 */
	public static String EncoderByMd5(String input) {
		try {
			// 选定MD5算法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 使用64位编码算法编码返回字符串
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			String output = base64en.encode(md5.digest(input.getBytes("utf-8")));
			// 返回加密后的字符串
			return output;
		} catch (Exception e) {
			// 打印错误信息
			System.out.println(e);
			// 返回空字符串
			return "";
		}
	}
}
