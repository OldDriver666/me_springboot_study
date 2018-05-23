package tan.security.hash;

import java.util.Random;

import org.apache.shiro.codec.Hex;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

/**
 * MD5工具类，加盐
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-6-11 下午7:57:36
 */
public class SHATest{    
	
	public static void main(String[] args) throws NoSuchAlgorithmException {  
    String salt = CryptoUtils.getSalt();  
    String password = "admin123";  
    String hashPassword = CryptoUtils.getHash(password, salt);  
    System.out.println("hashPassword:" + hashPassword);  
    System.out.println("salt:" + salt);  
    System.out.println("password:" + password);  
    // verify  
    boolean result = CryptoUtils.verify(hashPassword, password, salt);  
    System.out.println("Verify:" + result);  
  
}  }