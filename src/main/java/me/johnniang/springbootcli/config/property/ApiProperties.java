package me.johnniang.springbootcli.config.property;

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
    private boolean productionEnv = true;

}
