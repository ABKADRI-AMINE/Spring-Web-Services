package com.example.msbanqueamine;

import com.example.msbanqueamine.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//pour dire que c'est une classe de configuration
public class MyConfig {
//    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet=new ResourceConfig();//pour creer un objet de type ResourceConfig qui va contenir les web services de notre application
        jerseyServlet.register(CompteRestJaxRSAPI.class);//pour dire que c'est un web service de type jax rs cad un web service qui va etre exposé en utilisant le protocole http
        return jerseyServlet;
    }
//    @Bean
//    SimpleJaxWsServiceExporter serviceExporter(){
//        SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();//pour creer un objet de type SimpleJaxWsServiceExporter qui va contenir les web services de notre application
//        exporter.setBaseAddress("http://localhost:8089/");//pour dire que le web service va etre exposé sur le port 8089
//        return exporter;
//    }
}
