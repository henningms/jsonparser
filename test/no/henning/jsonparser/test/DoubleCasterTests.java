package no.henning.jsonparser.test;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

import no.henning.jsonparser.casting.implementations.DoubleCasterImpl;

public class DoubleCasterTests
{
	private DoubleCasterImpl caster;
	
	@Before
	public void setUp()
	{
		caster = new DoubleCasterImpl();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_ValueIsNull_ThrowIllegalArgumentException()
	{
		// Act
		Double actual = caster.cast(null);
	}
	
	@Test
	public void castToDouble_StringValueIsValidNumberFive_ReturnsFive()
	{
		// Arrange 
		Double expected = 5.0;
		String value = "5";
		
		// Act
		Double actual = caster.cast(value);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void cast_StringValueIsValidNumberOfTwentyFiveOFifteen_ReturnsTwentyFiveOFifteen()
	{
		Double expected = 25.15;
		String value = "25.15";
		
		Double actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	@Test
	public void castToDouble_StringValueIsValidNegativNumber_ReturnsTheNumber()
	{
		Double expected = -100.0;
		String value = "-100";
		
		Double actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_StringValueIsInvalid_ThrowIllegalArgumentException()
	{
		// Act
		Double result = caster.cast("#45.45-7-2&%&");
	}
	
	@Test
	public void castToDouble_NumberValueIsValidOfFive_ReturnsFive()
	{
		// Arrange
		Double expected = 5.0;
		Number value = 5;
		
		// Act
		Double actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test()
	public void castToDouble_NumberValueIsTooHigh_ThrowException()
	{
		Double expected = Double.POSITIVE_INFINITY * 2;
		
		Double actual = caster.cast(expected);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_ValueIsInvalidObject_ThrowIllegalArgumentException()
	{
		List<String> objects = new ArrayList<String>();
		
		Double actual = caster.cast(objects);
	}
	
	@Test
	public void castToDouble_CharacterValueIsValidOfFive_ReturnsFive()
	{
		Double expected = 5.0;
		Character value = '5';
		
		Double actual = caster.cast(value);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_CharacterValueIsInvalid_ThrowIllegalArgumentException()
	{
		Character value = '$';
		
		Double actual = caster.cast(value);
	}

}
