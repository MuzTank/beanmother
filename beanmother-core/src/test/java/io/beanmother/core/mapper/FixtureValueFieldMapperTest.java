package io.beanmother.core.mapper;

import io.beanmother.core.common.FixtureValue;
import io.beanmother.core.converter.ConverterFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link SetterAndFieldFixtureMapper}
 */
public class FixtureValueFieldMapperTest {

    SetterAndFieldFixtureMapper mapper;

    @Before
    public void setup() {
        mapper = (SetterAndFieldFixtureMapper) new MapperMediatorImpl(new ConverterFactory()).getFixtureMapper();
    }

    @Test
    public void testSimpleObjectMapping() {
        FieldObject obj = new FieldObject();

        mapper.map(obj, "integer", new FixtureValue(10));
        assertEquals(obj.integer, new Integer(10));

        mapper.map(obj, "primitiveInt", new FixtureValue(11));
        assertEquals(obj.primitiveInt, 11);

        Date date = new Date();
        mapper.map(obj, "date", new FixtureValue(date));
        assertEquals(obj.date, date);

        mapper.map(obj, "string", new FixtureValue("test"));
        assertEquals(obj.string, "test");
    }

    @Test
    public void testCastingAndMapping() {
        FieldObject obj = new FieldObject();
        mapper.map(obj, "number", new FixtureValue(10));
        assertEquals(obj.number, new Integer(10));

        mapper.map(obj, "ploat", new FixtureValue(10));
        assertEquals(obj.ploat, new Float(10));
    }

    public static class FieldObject {
        public int primitiveInt;
        public Integer integer;
        public Number number;
        public Float ploat;
        public Date date;
        public String string;
    }
}
