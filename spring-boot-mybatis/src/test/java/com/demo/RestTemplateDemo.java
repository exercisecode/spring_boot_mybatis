package com.demo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

public class RestTemplateDemo extends TestCase {

	String url = "http://127.0.0.1:10000";
	
	public void testProcess() {
		// 方法1
		RestTemplate rest = new RestTemplate();
	    restTemplateR1(rest);
	    String restGetResponse = rest.getForObject(url, String.class);
		System.out.println(" \t  R1 get  " + restGetResponse);
		String restPostResponse = rest.postForObject(url, null, String.class);
		System.out.println(" \t  R1 post  " + restPostResponse);
		System.out.println("\n\n");
		
		// 方法2
		RestTemplate restTemplateR2 = new RestTemplate();
		restTemplateR2(restTemplateR2);
		String r2GetResponse = restTemplateR2.getForObject(url, String.class);
		System.out.println(" \t  R2 get  " + r2GetResponse);
		
	}
	
	/**
	 * 设置 RestTemplate返回值字符集为UTF-8(方法1)
	 * @param restTemplate
	 */
	private void restTemplateR1(RestTemplate restTemplate) {
		if(restTemplate != null) {
			List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
			if(converterList != null && !converterList.isEmpty()) {
				int stringHttpMessageSize = 0;
				for(int size = 0; size < converterList.size(); size++) {
					HttpMessageConverter<?> httpMessageConverter = converterList.get(size);
					if(httpMessageConverter != null && httpMessageConverter.getClass() == StringHttpMessageConverter.class) {
						stringHttpMessageSize = size;
					}
				}
				// remove and utf-8 StringHttpMessageConverter
				converterList.remove(stringHttpMessageSize);
				converterList.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
			}
		}
	}
	
	/**
	 * 
	 * @param restTemplate
	 */
	private void restTemplateR2(RestTemplate restTemplate) {
		if(restTemplate != null) {
			List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
			if(converterList != null && !converterList.isEmpty()) {
				List<HttpMessageConverter<?>> utf8ConverterList = new ArrayList<HttpMessageConverter<?>>();
				for(HttpMessageConverter<?> httpMessageConverter : converterList) {
					if(httpMessageConverter != null) {
						if(httpMessageConverter.getClass() == StringHttpMessageConverter.class) {
							utf8ConverterList.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
						} else {
							utf8ConverterList.add(httpMessageConverter);
						}
					}
				}
				
				restTemplate.setMessageConverters(utf8ConverterList);
			}
		}
	}
	
}
