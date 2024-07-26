/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.core;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class MergeException extends RuntimeException {
    public MergeException(String message) {
        super(message);
    }

    public MergeException(String message, Exception e) {
        super(message, e);
    }
}