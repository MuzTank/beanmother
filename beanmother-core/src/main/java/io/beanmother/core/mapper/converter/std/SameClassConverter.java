package io.beanmother.core.mapper.converter.std;

import com.google.common.reflect.TypeToken;
import io.beanmother.core.mapper.converter.AbstractConverter;

public class SameClassConverter extends AbstractConverter {

    public SameClassConverter() {
    }

    public SameClassConverter(int priority) {
        super(priority);
    }

    @Override
    public Object convert(Object source, TypeToken<?> typeToken) {
        return source;
    }

    @Override
    public boolean canHandle(Object source, TypeToken<?> targetTypeToken) {
        return targetTypeToken.equals(TypeToken.of(source.getClass()));
    }
}
