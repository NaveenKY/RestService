/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.restservice.processors.exception;

import com.google.gson.Gson;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Naveen Kumar
 */
public class ExceptionProcessor implements Processor {

    private static final String ERROR_CODE = "500";

    @Override
    public void process(Exchange exchange) throws Exception {
        Throwable exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
        if (exception instanceof HttpException) {
            Gson gson = new Gson();
            ExceptionBean httpException = new ExceptionBean(((HttpException) exception).getErrorCode(), 
                    ((HttpException) exception).getErrorMessage());
            exchange.getOut().setBody(gson.toJson(httpException));
        } else {
            ExceptionBean httpException = new ExceptionBean(ERROR_CODE, exception.getMessage());
            Gson gson = new Gson();
            exchange.getOut().setBody(gson.toJson(httpException));
        }
    }
}
