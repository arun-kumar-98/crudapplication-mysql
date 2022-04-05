package com.crud.crudapplicationmysql.model;

import java.io.Serializable;
import java.util.Date;

public class ErrorDetails implements Serializable {

    private String message;
    private Date timestamp;
    private String errorCode;

    public ErrorDetails() {
    }

    public ErrorDetails(String message, Date timestamp, String errorCode) {
        this.message = message;
        this.timestamp = timestamp;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
