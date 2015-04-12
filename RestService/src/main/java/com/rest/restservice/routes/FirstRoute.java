package com.rest.restservice.routes;

import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author Naveen Kumar
 */
public class FirstRoute extends RouteBuilder {

    @PropertyInject("HTTP_PROTOCOL")
    private String httpProtocol;

    @PropertyInject("HTTP_HOST")
    private String httpHost;

    @PropertyInject("HTTP_PORT")
    private String httpPort;

    @PropertyInject("HTTP_BASE_URI")
    private String httpBaseUri;

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .to("exceptionProcessor")
                .handled(true);

        from("jetty://" + httpProtocol + httpHost + httpPort + httpBaseUri + "restapi")
                .processRef("myProcessor");
    }
}
