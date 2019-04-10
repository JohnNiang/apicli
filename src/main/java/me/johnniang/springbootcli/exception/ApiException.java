package me.johnniang.springbootcli.exception;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    @NonNull
    public abstract Object getStatus();

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
