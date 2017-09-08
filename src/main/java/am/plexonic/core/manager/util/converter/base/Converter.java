package am.plexonic.core.manager.util.converter.base;

import org.springframework.core.convert.ConversionException;

/**
 * The converter interface.
 */
public interface Converter<S, T> {

    T convert(S source) throws ConversionException;
}
