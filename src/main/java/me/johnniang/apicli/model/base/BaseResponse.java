package me.johnniang.apicli.model.base;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Global response entity.
 *
 * @author johnniang
 * @date 11/4/19
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    /**
     * Response code.
     */
    private Object code;

    /**
     * Response message.
     */
    private String message;

    /**
     * Response development message
     */
    private String devMessage;

    /**
     * Response data
     */
    private T data;

    public BaseResponse(Object code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Creates an ok result with message and data. (Default code is 200)
     *
     * @param data    result data
     * @param message result message
     * @return ok result with message and data
     */
    @NonNull
    public static <T> BaseResponse<T> ok(@Nullable String message, @Nullable T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), message, data);
    }

    /**
     * Creates an ok result with message only. (Default code is 200)
     *
     * @param message result message
     * @return ok result with message only
     */
    @NonNull
    public static <T> BaseResponse<T> ok(@Nullable String message) {
        return ok(message, null);
    }

    /**
     * Creates an ok result with data only. (Default message is OK, code is 200)
     *
     * @param data data to response
     * @param <T>  data type
     * @return base response with data
     */
    public static <T> BaseResponse<T> ok(@NonNull T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }
}
