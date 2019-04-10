package me.johnniang.springbootcli.model;

import me.johnniang.springbootcli.util.ReflectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

import static me.johnniang.springbootcli.util.BeanUtils.transformFrom;
import static me.johnniang.springbootcli.util.BeanUtils.updateProperties;

/**
 * Converter interface for input DTO.
 *
 * @author johnniang
 */
public interface InputConverter<DOMAIN> {

    /**
     * Convert to domain.(shallow)
     *
     * @return new domain with same value(not null)
     */
    @SuppressWarnings("unchecked")
    default DOMAIN convertTo() {
        // Get parameterized type
        ParameterizedType currentType = ReflectionUtils.getParameterizedType(InputConverter.class, this.getClass());

        // Assert not equal
        Objects.requireNonNull(currentType, "Cannot fetch actual type because parameterized type is null");

        Class<DOMAIN> domainClass = (Class<DOMAIN>) currentType.getActualTypeArguments()[0];

        return transformFrom(this, domainClass);
    }

    /**
     * Update a domain by dto.(shallow)
     *
     * @param domain updated domain
     */
    default void update(DOMAIN domain) {
        updateProperties(this, domain);
    }
}

