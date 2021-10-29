package com.onapage.project.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class IpUtils {
	private static final int HTTP_CONNECTION_TIMEOUT=5000;
	private static final int HTTP_SOCKET_TIMEOUT=6000;
	private static final int HTTP_CONNECTION_MANAGER_TIMEOUT=5000;
	private static final RequestConfig config = RequestConfig.custom().setConnectTimeout(HTTP_CONNECTION_TIMEOUT)
			.setConnectionRequestTimeout(HTTP_CONNECTION_MANAGER_TIMEOUT).setSocketTimeout(HTTP_SOCKET_TIMEOUT).build();

//	private static final String FRONTSTR="http://ip.taobao.com/service/getIpInfo.php?ip=";
	private static final String FRONTSTR="https://apis.map.qq.com/ws/location/v1/ip?key=GURBZ-WAIED-BG54L-HLZHI-CPWR7-2OBFP&ip=";
	
	public static JSONObject httpGetRequest(String url)throws IOException,UnsupportedEncodingException {
		log.info("");
		HttpGet httpGet = new HttpGet();
		httpGet.addHeader(HTTP.CONTENT_TYPE,"application/json; charset=UTF-8");
		httpGet.setURI(URI.create(url));
		httpGet.setConfig(config);
		return fetchResult(httpGet);
	}
	public static JSONObject getHttpEntityContent(HttpResponse response) throws IOException,UnsupportedEncodingException {
		HttpEntity entity = response.getEntity();
		String result ="";
		if(entity!=null) {
			try(InputStream ips = entity.getContent();
					InputStreamReader isr = new InputStreamReader(ips,"UTF-8");
					BufferedReader br = new BufferedReader(isr)){
				String line =null;
				StringBuilder sb = new StringBuilder();
				while((line =br.readLine())!=null) {
					sb.append(line+"\n");
				}
				result = sb.toString();
			}
		}
		return JSONObject.parseObject(result);
	}
	public static JSONObject fetchResult(HttpRequestBase httpRequestBase)throws IOException {
		CloseableHttpClient httpClient =HttpClientBuilder.create().build();
		JSONObject httpEntityContent;
		JSONObject result = new JSONObject();
		try(CloseableHttpResponse response = httpClient.execute(httpRequestBase)){
			result.put("code",response.getStatusLine().getStatusCode());
			httpEntityContent = getHttpEntityContent(response);
			result.put("message", httpEntityContent);
		}
		return result;
	}
	public static JSONObject getAddressByIp(String ip) throws UnsupportedEncodingException, IOException {
		return httpGetRequest(FRONTSTR+ip);
	}
}
