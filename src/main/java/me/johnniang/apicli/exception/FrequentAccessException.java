package me.johnniang.apicli.exception;

/**
 * Frequent access exception.
 *
 * @author johnniang
 */
public class FrequentAccessException extends BadRequestException {

    public FrequentAccessException(String message) {
        super(message);
    }

    public FrequentAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
