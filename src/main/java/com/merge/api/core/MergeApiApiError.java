/**
 * This file was auto-generated by Fern from our API Definition.
 * 
 * NOTE: Do NOT use this class. `ApiError` is the class that should
 * be used. This class is just included for backwards compatibility
 * purposes.
 */
package com.merge.api.core;

/**
 * @deprecated
 * This exception type will be thrown for any non-2XX API responses.
 */
public class MergeApiApiError extends MergeException {
    /**
     * The error code of the response that triggered the exception.
     */
    private final int statusCode;

    /**
     * The body of the response that triggered the exception.
     */
    private final Object body;

    public MergeApiApiError(String message, int statusCode, Object body) {
        super(message);
        this.statusCode = statusCode;
        this.body = body;
    }

    /**
     * @return the statusCode
     */
    public int statusCode() {
        return this.statusCode;
    }

    /**
     * @return the body
     */
    public Object body() {
        return this.body;
    }

    @java.lang.Override
    public String toString() {
        return "MergeApiApiError{" + "message: " + getMessage() + ", statusCode: " + statusCode + ", body: " + body
                + "}";
    }
}