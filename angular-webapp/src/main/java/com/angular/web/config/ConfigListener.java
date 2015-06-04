package com.angular.web.config;

import com.application.business.jpa.EntityManagerFactoryWrapper;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigListener.class);

    @Override
    public void contextInitialized(ServletContextEvent ctx) {

        LOGGER.info("Initializing App EntityManager");

        EntityManagerFactoryWrapper.getEntityManager();
    }

    @Override
    public void contextDestroyed(ServletContextEvent ctx) {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl) {
                try {
                    LOGGER.info("Deregistering JDBC driver {}", driver);
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    LOGGER.error("Error deregistering JDBC driver {}", driver, ex);
                }
            } else {
                LOGGER.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
            }
        }
    }

}
