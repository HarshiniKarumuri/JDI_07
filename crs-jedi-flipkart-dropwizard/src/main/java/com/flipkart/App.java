package com.flipkart;

import com.flipkart.rest.controller.AdminRESTController;
import com.flipkart.rest.controller.ProfessorRESTController;
import com.flipkart.rest.controller.StudentRESTController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.log4j.Logger;

/**
 * Web service starts execution here
 */
public class App extends Application<Configuration> {
    private static final Logger logger = Logger.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        logger.info("Registering REST resources");

        // All the REST Services registered here
        e.jersey().register(new AdminRESTController());
        e.jersey().register(new ProfessorRESTController());
        e.jersey().register(new StudentRESTController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
