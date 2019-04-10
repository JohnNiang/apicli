package me.johnniang.springbootcli.util;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Servlet utilities.
 *
 * @author johnniang
 * @date 4/10/19
 */
public class ServletUtils {

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"};

    private ServletUtils() {
    }

    /**
     * Gets client ip address.
     *
     * @param request http servlet request must not be null
     * @return ip address
     */
    @NonNull
    public static String getClientIp(@NonNull HttpServletRequest request) {
        Assert.notNull(request, "Http servlet request must not be null");

        for (String header : IP_HEADER_CANDIDATES) {
            // Get IP address from header
            String headerValue = request.getHeader(header);

            if (StringUtils.hasText(headerValue) && headerValue.equalsIgnoreCase("unknown")) {
                return headerValue;
            }
        }

        // Get from request
        return request.getRemoteAddr();
    }
}
