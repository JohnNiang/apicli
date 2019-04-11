package me.johnniang.apicli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * Base exception of the project.
 *
 * @author johnniang
 */
public abstract class ApiException extends RuntimeException {

    /**
     * Error errorData.
     */
    private Object errorData;

    private Object errorCode;

    public ApiException(String message) {
        super(message);
        setErrorCode(getStatus().value());
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        setErrorCode(getStatus().value());
    }

    /**
     * Http status will response.
     *
     * @return http status
     */
    @NonNull
    public abstract HttpStatus getStatus();

    public Object getErrorCode() {
        return errorCode;
    }

    public ApiException setErrorCode(@NonNull Object errorCode) {
        Objects.requireNonNull(errorCode, "Error code must not be null");
        this.errorCode = errorCode;
        return this;
    }

    @Nullable
    public Object getErrorData() {
        return errorData;
    }

    /**
     * Sets error errorData.
     *
     * @param errorData error data
     * @return current exception.
     */
    @NonNull
    public ApiException setErrorData(@Nullable Object errorData) {
        this.errorData = errorData;
        return this;
    }
}
