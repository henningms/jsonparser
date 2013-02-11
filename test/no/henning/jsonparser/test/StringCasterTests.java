package no.henning.jsonparser.test;

import java.util.HashMap;
import java.util.Map;

import no.henning.jsonparser.casting.implementations.StringCasterImpl;

import static org.junit.Assert.*;
import org.junit.*;

public class StringCasterTests
{
	private StringCasterImpl caster;
	
	@Before
	public void setUp()
	{
		caster = new StringCasterImpl();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cast_ValueIsNull_ThrowsIllegalArgumentException()
	{
		String actual = caster.cast(null);
	}
	
	@Test
	public void cast_IntegerValueIsFive_StringIsFive()
	{
		String expected = "5";
		Integer value = 5;
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_DoubleValueIsFiveOFifteen_StringIsFiveOFifteen()
	{
		Double value = 5.15;
		String expected = "5.15";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_FloatValueIsTenOTwentyFive_StringIsTenOTwentyFive()
	{
		Float value = 10.25f;
		String expected = "10.25";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_LongValueIsTwentyThousand_StringIsTwentyThousand()
	{
		Long value = 20000L;
		String expected = "20000";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_BooleanValueIsTrue_StringIsTrue()
	{
		Boolean value = true;
		String expected = "true";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_BooleanValueIsFalse_StringIsFalse()
	{
		Boolean value = false;
		String expected = "false";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_StringValueIsHey_StringIsHey()
	{
		String value = "Hey";
		String expected = "Hey";
		
		String actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cast_ValueIsInvalidObject_ThrowsIllegalArgumentException()
	{
		Map<Object, Object> value = new HashMap<Object, Object>();
		
		String actual = caster.cast(value);
	}
}
