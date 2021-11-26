package com.u238.training.errorResponse;

public interface ErrorResponse {

    int getStatus();

    void setStatus(int status);

    String getMessage();

    void setMessage(String message);

    long getTimestamp();

    void setTimestamp(long timestamp);
}
