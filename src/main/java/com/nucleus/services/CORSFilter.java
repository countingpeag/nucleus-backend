package com.nucleus.services;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

//Filter Class to enable Cross Origin Resources Shearing
//We need to add more parameter in the web.xml file
@Provider
public class CORSFilter implements ContainerResponseFilter {

    public ContainerResponse filter(ContainerRequest request,
        ContainerResponse response) {

        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().add("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization");
        response.getHttpHeaders().add("Access-Control-Allow-Credentials","true");
        response.getHttpHeaders().add("Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        return response;
    }
}