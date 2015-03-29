package com.rest.restservice.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Naveen Kumar
 */
public class MyProcessor implements Processor{

    public void process(Exchange exchng) throws Exception {
        exchng.getOut().setBody("Hello");
    }
    
}
