package com.rest.restservice.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author Naveen Kumar
 */
public class FirstRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jetty://http://localhost:8001/restapi")
                .processRef("myProcessor");
    }

}
