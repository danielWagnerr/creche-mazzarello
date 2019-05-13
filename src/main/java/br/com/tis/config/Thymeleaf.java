package br.com.tis.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class Thymeleaf {

	private ApplicationContext applicationContext;
	 @Bean
	    public SpringSecurityDialect springSecurityDialect(){
	        return new SpringSecurityDialect();
	    }
	 
	    @Bean
	    public TemplateEngine templateEngine() {
	        SpringTemplateEngine engine = new SpringTemplateEngine();
	        engine.setEnableSpringELCompiler(true);
	        engine.setTemplateResolver(templateResolver());
	        return engine;
	    }

	    private ITemplateResolver templateResolver() {
	        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	        resolver.setApplicationContext(applicationContext);
	        resolver.setSuffix(".html");
	        resolver.setPrefix("templates/");
	        resolver.setTemplateMode("HTML5");
	        return resolver;
	    }
}
