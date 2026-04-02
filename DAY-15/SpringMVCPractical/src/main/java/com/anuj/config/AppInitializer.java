package com.anuj.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { DataConfig.class }; // Database setup
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // MVC setup
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // All requests go to Spring
    }
}
