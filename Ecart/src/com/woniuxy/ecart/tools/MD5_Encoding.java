package com.woniuxy.ecart.tools;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5�û�����
 * @author Administrator
 *
 */
public class MD5_Encoding {

 public static void main(String[] args){
 System.out.println(getMd5String(""));
 System.out.println(MD5("good"));
 }
 public final static String MD5(String s) {
 char hexDigits[] = { '0', '1', '2', '3', '4',
    '5', '6', '7', '8', '9',
    'A', 'B', 'C', 'D', 'E', 'F' };
 try {
  byte[] btInput = s.getBytes();
 //���MD5ժҪ�㷨�� MessageDigest ����
  MessageDigest mdInst = MessageDigest.getInstance("MD5");
 //ʹ��ָ�����ֽڸ���ժҪ
  mdInst.update(btInput);
 //�������
  byte[] md = mdInst.digest();
 //������ת����ʮ�����Ƶ��ַ�����ʽ
  int j = md.length;
  char str[] = new char[j * 2];
  int k = 0;
  for (int i = 0; i < j; i++) {
  byte byte0 = md[i];
  str[k++] = hexDigits[byte0 >>> 4 & 0xf];
  str[k++] = hexDigits[byte0 & 0xf];
  }
  return new String(str);
 }
 catch (Exception e) {
  e.printStackTrace();
  return null;
 }
 }
  
  
  
 public static String getMd5String(String str){
 MessageDigest messageDigest = null; 
   
 try { 
  messageDigest = MessageDigest.getInstance("MD5"); 
  
  messageDigest.reset(); 
  
  messageDigest.update(str.getBytes("UTF-8")); 
 } catch (NoSuchAlgorithmException e) { 
  System.out.println("NoSuchAlgorithmException caught!"); 
  System.exit(-1); 
 } catch (UnsupportedEncodingException e) { 
  e.printStackTrace(); 
 } 
  
 byte[] byteArray = messageDigest.digest(); 
  
 StringBuffer md5StrBuff = new StringBuffer(); 
  
 for (int i = 0; i < byteArray.length; i++) {  
  if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) 
  md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i])); 
  else
  md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i])); 
 } 
  
 return md5StrBuff.toString(); 
 }
}


