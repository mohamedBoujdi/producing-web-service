package com.example.producingwebservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration //this annotation is used to mark a class as a configuration class
//a configuration class is a class that contains one or more @Bean methods
//the @Bean annotation tells Spring that a method annotated with @Bean will return an object that should be registered
// as a bean in the Spring application context
@EnableWs //this annotation is used to enable Spring Web Services
public class WebServiceConfig {
    @Bean
    //we use the @Bean annotation to tell Spring to register the MessageDispatcherServlet
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();//we create a MessageDispatcherServlet instance
        //we use the MessageDispatcherServlet to dispatch incoming SOAP messages to the appropriate endpoint
        servlet.setApplicationContext(applicationContext);//we set the ApplicationContext on the MessageDispatcherServlet
        servlet.setTransformWsdlLocations(true);//we set the transformWsdlLocations property to true to ensure that relative
        //locations in the WSDL are transformed into absolute locations
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "countries")//we use the @Bean annotation to tell Spring to register the xsd2java generated Countries class
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }
}
