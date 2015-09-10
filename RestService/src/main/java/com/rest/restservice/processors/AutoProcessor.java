/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restservice.processors;

import com.rest.restservice.constants.HTTPConstants;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Naveen_Kumar36
 */
public class AutoProcessor implements Processor {

    private final Log LOG = LogFactory.getLog(AutoProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOG.info(MessageFormat.format(HTTPConstants.AUTO_START_JOB, exchange.getFromRouteId()));
        Method method = AutoProcessor.class.getMethod(exchange.getFromRouteId());
        method.invoke(this);
    }

    public void testJob() {
        LOG.info("Test Job is started.");
    }
}
