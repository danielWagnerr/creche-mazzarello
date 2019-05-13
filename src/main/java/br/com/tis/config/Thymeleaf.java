package br.com.tis.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class Thymeleaf {
	
	 @Bean
	    public SpringSecurityDialect springSecurityDialect(){
	        return new SpringSecurityDialect();
	    }
}
