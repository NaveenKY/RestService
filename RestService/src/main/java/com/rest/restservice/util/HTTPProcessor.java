package com.rest.restservice.util;

import com.rest.restservice.constants.HTTPConstants;
import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Naveen Kumar
 */
public abstract class HTTPProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpServletRequest request = exchange.getIn().getBody(HttpServletRequest.class);
        switch (request.getMethod()) {
            case HTTPConstants.POST:
                create(exchange);
                break;
            case HTTPConstants.PUT:
                update(exchange);
                break;
            case HTTPConstants.DELETE:
                delete(exchange);
                break;
            case HTTPConstants.GET:
                get(exchange);
                break;
            default:
                throw new UnsupportedOperationException(HTTPConstants.UNSUPPORTED_METHOD);
        }

    }

    /**
     * This method is used to perform POST operation for rest call.
     *
     * @param exchange
     * @throws java.lang.Exception
     */
    public abstract void create(Exchange exchange) throws Exception;

    /**
     * This method is used to perform PUT operation for rest call.
     *
     * @param exchange
     * @throws java.lang.Exception
     */
    public abstract void update(Exchange exchange) throws Exception;

    /**
     * This method is used to perform DELETE operation for rest call.
     *
     * @param exchange
     * @throws java.lang.Exception
     */
    public abstract void delete(Exchange exchange) throws Exception;

    /**
     * This method is used to perform GET operation for rest call.
     *
     * @param exchange
     * @throws java.lang.Exception
     */
    public abstract void get(Exchange exchange) throws Exception;
}
