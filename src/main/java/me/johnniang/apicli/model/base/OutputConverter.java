package me.johnniang.apicli.model.base;

import org.springframework.lang.NonNull;

import static me.johnniang.apicli.util.BeanUtils.updateProperties;

/**
 * Converter interface for output DTO.
 *
 * <b>The implementation type must be equal to DTO type</b>
 *
 * @param <DTO>    the implementation class type
 * @param <DOMAIN> domain type
 * @author johnniang
 */
public interface OutputConverter<DTO extends OutputConverter<DTO, DOMAIN>, DOMAIN> {

    /**
     * Convert from domain.(shallow)
     *
     * @param domain domain data
     * @return converted dto data
     */
    @SuppressWarnings("unchecked")
    @NonNull
    default <T extends DTO> T convertFrom(DOMAIN domain) {

        updateProperties(domain, this);

        return (T) this;
    }
}
