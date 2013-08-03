package dino.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Request {
	
	public void httpGet(String host,String url){
		
	}

	public void httpGet(String host,int port,String url){			
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(host,port,"http");
		HttpMethod method = getGetMethod(url);
		try {
			client.executeMethod(method);
			System.out.println(method.getStatusLine());
			System.out.println(new String(method.getResponseBodyAsString().getBytes()));
			method.releaseConnection();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void httpGet(String host,int port,String protocol,String url){
		
	}
	
	private HttpMethod getGetMethod(String url){
		return new GetMethod("url");    
	}
	
	public static void main(String[] argus){
		new Request().httpGet("www.sina.com.cn", 80 , "");
	}
	/*
	private static String host = "202.120.32.118";
	private static int port = 8080;
	private static String postUrl = "/sms/SmsSendInstance.do";
	private static String receiveUrl = "/sms/SmsDeliverInstance.do";
	private static String reportUrl = "/sms/SmsReportInstance.do";
	
	//private static String url = "http://202.120.32.118:8080/sms/SmsSendInstance.do";
	public static void main9(String[] argus){
		
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(host,port,"http");
		HttpMethod method = getPostMethod(postUrl);
		try {
			client.executeMethod(method);
			System.out.println(method.getStatusLine());
			System.out.println(new String(method.getResponseBodyAsString().getBytes()));
			method.releaseConnection();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] argus){
		
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(host,port,"http");
		HttpMethod method = getReceiveMethod(receiveUrl);
		try {
			client.executeMethod(method);
			System.out.println(method.getStatusLine());
			System.out.println(new String(method.getResponseBodyAsString().getBytes()));
			method.releaseConnection();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void main44(String[] argus){
		
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(host,port,"http");
		HttpMethod method = getReportMethod(reportUrl);
		try {
			client.executeMethod(method);
			System.out.println(method.getStatusLine());
			System.out.println(new String(method.getResponseBodyAsString().getBytes()));
			method.releaseConnection();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	private static HttpMethod getReceiveMethod(String url) {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
		String timeStamp = sdf.format(new Date(System.currentTimeMillis())).substring(0, 14);
		
		PostMethod post = new PostMethod(url);     
		NameValuePair accountId = new NameValuePair("accountId","admin");  
		MD5 md = new MD5();
		NameValuePair pwd = new NameValuePair("pwd",md.getMD5ofStr("admin6888"+timeStamp));
		//NameValuePair mobs = new NameValuePair("mobs","18621820872");
		//NameValuePair msg = new NameValuePair("msg","test new sms");
		NameValuePair ext = new NameValuePair("ExtCode","6240");
		NameValuePair timestamp = new NameValuePair("timestamp",timeStamp);
		post.setRequestBody(new NameValuePair[] { accountId,pwd,ext,timestamp});   
		return post; 
	}
	
	
	private static HttpMethod getReportMethod(String url) {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
		String timeStamp = sdf.format(new Date(System.currentTimeMillis())).substring(0, 14);
		
		PostMethod post = new PostMethod(url);     
		//NameValuePair accountId = new NameValuePair("accountId","admin");
		NameValuePair accountId = new NameValuePair("accountId","sms_zbb");
		//NameValuePair accountId = new NameValuePair("accountId","sms_lib");
		MD5 md = new MD5();
		//NameValuePair pwd = new NameValuePair("pwd",md.getMD5ofStr("admin6888"+timeStamp));

		NameValuePair pwd = new NameValuePair("pwd",md.getMD5ofStr("sms_zbb6240"+timeStamp));//NameValuePair pwd = new NameValuePair("pwd",md.getMD5ofStr("sms_lib37"+timeStamp));
		//NameValuePair mobs = new NameValuePair("mobs","18621820872");
		//NameValuePair msg = new NameValuePair("msg","test new sms");
		//NameValuePair ext = new NameValuePair("msgid","1212031630261354523426220");
		NameValuePair ext = new NameValuePair("msgid","1303130948571363139337778");
		NameValuePair timestamp = new NameValuePair("timestamp",timeStamp);
		post.setRequestBody(new NameValuePair[] { accountId,pwd,ext,timestamp});   
		return post; 
	}

	public static void main2(String[] argus){
		String xmlString = "<data><deliver><mobile>13761156520</mobile><msg>you are</msg><ext>0</ext><time>2012-08-01 15:15:38.0</time></deliver></data>";
		Hashtable ht = XMLParse(xmlString);
		System.out.println(ht.get("deliver"));
	}
	private static HttpMethod getGetMethod(String url){
		return new GetMethod("url");    
	}
	private static HttpMethod getPostMethod(String url){
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
		String timeStamp = sdf.format(new Date(System.currentTimeMillis())).substring(0, 14);
		
		PostMethod post = new PostMethod(url);     
		NameValuePair accountId = new NameValuePair("accountId","admin");  
		MD5 md = new MD5();
		NameValuePair pwd = new NameValuePair("pwd",md.getMD5ofStr("admin6888"+timeStamp));
		NameValuePair mobs = new NameValuePair("mobs","18017250866");
		NameValuePair msg = new NameValuePair("msg","test new sms");
		NameValuePair ext = new NameValuePair("ext","1234");
		NameValuePair timestamp = new NameValuePair("timestamp",timeStamp);
		post.setRequestBody(new NameValuePair[] { accountId,pwd,mobs,msg,ext,timestamp});   
		return post; 
	} 
	*/

}
