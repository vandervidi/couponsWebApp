package com.oa.couponsWebApp;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MD5 class junit for check MD5 class
 */
public class MD5Test {

	/**
	 * can check it too at: http://md5encryption.com/
	 */
	@Test
	public void testEncryptMD5() {
		assertEquals("Here is test for Addition Result: ", "c4ca4238a0b923820dcc509a6f75849b", com.oa.couponsWebApp.MD5.encryptMD5("1"));
	}

}
