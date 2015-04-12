package com.rest.restservice.processors.exception;

/**
 *
 * @author Naveen Kumar
 */
public class ExceptionBean {

    private String errorCode;
    private String errorMessage;

    public ExceptionBean(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "HttpException{" + "errorCode=" + errorCode + ", errorMessage=" + errorMessage + '}';
    }
}
