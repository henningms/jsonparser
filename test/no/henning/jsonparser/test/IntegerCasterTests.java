package no.henning.jsonparser.test;

import static org.junit.Assert.*;

import no.henning.jsonparser.casting.implementations.IntegerCasterImpl;

import org.junit.Before;
import org.junit.Test;

public class IntegerCasterTests
{
	private IntegerCasterImpl caster;
	
	@Before
	public void setUp()
	{
		caster = new IntegerCasterImpl();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cast_ValueIsNull_ThrowsIllegalArgumentException()
	{
		Integer actual = caster.cast(null);
	}
	
	@Test
	public void cast_IntegerValueIsFive_ReturnsFive()
	{
		Integer expected = 5;
		Integer value = 5;
		
		Integer actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_DoubleValueIsFiveOFive_ReturnsFive()
	{
		Integer expected = 5;
		Double value = 5.5;
		
		Integer actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_FloatValueIsTenOTen_ReturnsTen()
	{
		Integer expected = 10;
		Float value = 10.10f;
		
		Integer actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_LongValueIsTwentyThousand_ReturnsTwentyThousand()
	{
		Integer expected = 20000;
		Long value = 20000L;
		
		Integer actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_LongValueIsTooBig_ReturnsMaxValue()
	{
		Integer expected = Integer.MAX_VALUE;
		Long value = Integer.MAX_VALUE + Integer.MAX_VALUE + 10L;
		
		Integer actual = caster.cast(value);
		
		assertEquals(expected, actual);
		
		
	}

}
