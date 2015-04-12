package com.rest.restservice.processors;

import com.rest.restservice.util.HTTPProcessor;
import org.apache.camel.Exchange;

/**
 *
 * @author Naveen Kumar
 */
public class MyProcessor extends HTTPProcessor {

    @Override
    public void create(Exchange exchange) throws Exception {
        exchange.getOut().setBody("Create Method Called");
    }

    @Override
    public void update(Exchange exchange) throws Exception {
        exchange.getOut().setBody("Update Method Called");
    }

    @Override
    public void delete(Exchange exchange) throws Exception {
        exchange.getOut().setBody("Delete Method Called");
    }

    @Override
    public void get(Exchange exchange) throws Exception {
        exchange.getOut().setBody("Get Method Called");
    }

}
