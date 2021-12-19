package com.damian.discountcalculator.exception;

/**
 * Business Exception contained the message for the user of the application.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }

}