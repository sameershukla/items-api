package com.example.microservicedebugging.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;

/**
 * Configuration for httptrace actuator endpoint
 * @author Sameer Shukla
 *
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public HttpTraceRepository htttpTraceRepository()
	{
	  return new InMemoryHttpTraceRepository();
	}
	
}
