package com.myweb.www.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] {encodingFilter};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
		String uploadLocation = "D:\\_myweb\\_java\\fileUpload";
		int maxFileSize = 1024 * 1024; // 1 MB
		int maxReqSize = maxFileSize * 5; // 파일 요청 최대 크기
		int fileSizeThreshold = maxReqSize; // 메모리에서 파일을 전송할 때 만들어지는 임시공간의 크기
		
		MultipartConfigElement multipartConfigElement
		= new MultipartConfigElement(uploadLocation,
										maxFileSize, maxReqSize, fileSizeThreshold);
		registration.setMultipartConfig(multipartConfigElement);
	}
	

}
