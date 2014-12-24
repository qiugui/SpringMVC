 package com.qg.util;

import java.security.MessageDigest;
 
 /**
  * 
 * @ClassName: MD5 
 * @Description: TODO MD5算法的实现 
 * @author qiugui 
 * @date 2014年11月18日 下午3:30:36 
 *
  */
 public class MD5 {

	 public static String encipher(String string){
		 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b',
				 'c','d','e','f'};
		 
		 try {
			byte[] strTemp=string.getBytes();
			
			MessageDigest messageDigestTemp=MessageDigest.getInstance("MD5");
			
			messageDigestTemp.update(strTemp);
			
			byte[] messageDigest=messageDigestTemp.digest();
			
			int j=messageDigest.length;
			
			char str[]=new char[j*2];
			
			int k=0;
			
			for(int i=0;i<j;i++){
				byte byte0=messageDigest[i];
				
				str[k++]=hexDigits[byte0 >>> 4 & 0xf];
				str[k++]=hexDigits[byte0 & 0xf];
			}
			
			return new String(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}

 