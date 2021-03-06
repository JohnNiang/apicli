package me.johnniang.apicli.config;

import me.johnniang.apicli.config.filter.CorsFilter;
import me.johnniang.apicli.config.filter.LogFilter;
import me.johnniang.apicli.config.property.ApiProperties;
import me.johnniang.apicli.model.constant.ApiConstant;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Api configuration.
 *
 * @author johnniang
 * @date 4/10/19
 */
@Configuration
@EnableConfigurationProperties(ApiProperties.class)
public class ApiConfiguration {

    @Bean
    @ConditionalOnMissingFilterBean(CorsFilter.class)
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> corsFilter = new FilterRegistrationBean<>();

        corsFilter.setOrder(Ordered.HIGHEST_PRECEDENCE + 10);
        corsFilter.setFilter(new CorsFilter());
        corsFilter.addUrlPatterns(ApiConstant.API_PREFIX + "*");

        return corsFilter;
    }

    @Bean
    @ConditionalOnMissingFilterBean(LogFilter.class)
    public FilterRegistrationBean<LogFilter> logFilter() {
        FilterRegistrationBean<LogFilter> logFilter = new FilterRegistrationBean<>();

        logFilter.setOrder(Ordered.HIGHEST_PRECEDENCE + 9);
        logFilter.setFilter(new LogFilter());
        logFilter.addUrlPatterns(ApiConstant.API_PREFIX + "*");

        return logFilter;
    }
}
