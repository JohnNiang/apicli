package me.johnniang.springbootcli.model;

import static me.johnniang.springbootcli.util.BeanUtils.updateProperties;

/**
 * Converter interface for output DTO.
 *
 * <b>The implementation type must be equal to DTO type</b>
 *
 * @param <DTO>    the implementation class type
 * @param <DOMAIN> doamin type
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
    default <T extends DTO> T convertFrom(DOMAIN domain) {

        updateProperties(domain, this);

        return (T) this;
    }
}
