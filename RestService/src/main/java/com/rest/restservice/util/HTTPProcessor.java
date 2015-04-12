package com.rest.restservice.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpMethod;

/**
 *
 * @author Naveen Kumar
 */
public abstract class HTTPProcessor implements Processor{

    @Override
    public void process(Exchange exchng) throws Exception {
        HttpServletRequest request = exchng.getIn().getBody(HttpServletRequest.class);
        if (request.getMethod() == "POST") {
            create(exchng);
        } else if (request.getMethod() == "PUT") {
            update(exchng);
        } else if (request.getMethod() == "DELETE") {
            delete(exchng);
        } else if (request.getMethod() == "GET") {
            get(exchng);
        } else {
            throw new UnsupportedOperationException("HTTP Method Not supported yet.");
        }
    }
    
    /**
     * This method is used to perform POST operation for rest call.
     * @param exchange
     */
    public abstract void create(Exchange exchange);
    
    /**
     * This method is used to perform PUT operation for rest call.
     * @param exchange
     */
    public abstract void update(Exchange exchange);
    
    /**
     * This method is used to perform DELETE operation for rest call.
     * @param exchange
     */
    public abstract void delete(Exchange exchange);
    
    /**
     * This method is used to perform GET operation for rest call.
     * @param exchange
     */
    public abstract void get(Exchange exchange);
}
