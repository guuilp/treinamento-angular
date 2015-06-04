package com.angular.web.config;

import com.angular.web.rest.ClienteRS;
import com.angular.web.rest.ExampleRS;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplication extends Application {

    private final Set<Class<?>> classes = new HashSet<Class<?>>();

    @Override
    public Set<Class<?>> getClasses() {

        classes.add(ExampleRS.class);
        classes.add(ClienteRS.class);
        return classes;
    }

}
