package http.server;

import http.RequestDemo01;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import javax.servlet.ServletException;

public class ServletServer {
	
	public static final String DISH = "/dish";

	public static void main(String[] args) throws ServletException {
		
		DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(ServletServer.class.getClassLoader())
				                                             .setContextPath(DISH)
				                                             .setDeploymentName("dish.war")
				                                             .addServlets(Servlets.servlet("request01", RequestDemo01.class).addMappings("/cancelSoldOut")
				                                            		    .addMappings("/request01"));
		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();
		
		HttpHandler servletHandler = manager.start();
		PathHandler path = Handlers.path(Handlers.redirect(DISH)).addPrefixPath(DISH, servletHandler);
		
		Undertow server = Undertow.builder().addHttpListener(8089, "127.0.0.1").setHandler(path).build();
		server.start();
	}

}
