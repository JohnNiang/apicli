package me.johnniang.apicli.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Api properties.
 *
 * @author johnniang
 * @date 4/10/19
 */
@Data
@ConfigurationProperties("api")
public class ApiProperties {

    /**
     * Production environment.
     */
    private boolean prodEnv = true;

    /**
     * Documentation enabled.
     */
    private boolean docEnabled = false;

}
