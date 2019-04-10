package me.johnniang.springbootcli.exception;

import org.springframework.http.HttpStatus;

/**
 * Authentication exception.
 *
 * @author johnniang
 */
public class AuthenticationException extends ApiException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
