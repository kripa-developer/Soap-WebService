package com.example.soapws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

	@Bean

	@SuppressWarnings({ "rawtypes", "unchecked" })

	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);

		return new ServletRegistrationBean(servlet, "/allService/*");
	}

	@Bean(name = "products")
	 public DefaultWsdl11Definition defaultwsdl11Definition(XsdSchema productSchema){
		
	 DefaultWsdl11Definition wsdl11Definition=new DefaultWsdl11Definition();
	 wsdl11Definition.setPortTypeName ("allServiceSoapHttp");
	 wsdl11Definition.setLocationUri("/allService");
	 wsdl11Definition.setTargetNamespace ("com.springbootsoap.allapis");
	 wsdl11Definition.setSchema(productSchema);

	 return wsdl11Definition;
	 }


	@Bean
	public XsdSchema productSchema() {

		return new SimpleXsdSchema(new ClassPathResource("product.xsd"));
		}

}
