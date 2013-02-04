package no.henning.jsonparser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import no.henning.jsonparser.casting.CasterImpl;

import org.junit.Test;

public class CasterTests
{

	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_ValueIsNull_ThrowIllegalArgumentException()
	{
		// Act
		Double actual = CasterImpl.castToDouble(null);
	}
	
	@Test
	public void castToDouble_StringValueIsValidNumberFive_ReturnsFive()
	{
		// Arrange 
		Double expected = 5.0;
		String value = "5";
		
		// Act
		Double actual = CasterImpl.castToDouble(value);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void castToDouble_StringValueIsValidNegativNumber_ReturnsTheNumber()
	{
		Double expected = -100.0;
		String value = "-100";
		
		Double actual = CasterImpl.castToDouble(value);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_StringValueIsInvalid_ThrowIllegalArgumentException()
	{
		// Act
		Double result = CasterImpl.castToDouble("#45.45-7-2&%&");
	}
	
	@Test
	public void castToDouble_NumberValueIsValidOfFive_ReturnsFive()
	{
		// Arrange
		Double expected = 5.0;
		Number value = 5;
		
		// Act
		Double actual = CasterImpl.castToDouble(value);
		
		assertEquals(expected, actual);
	}
	
	@Test()
	public void castToDouble_NumberValueIsTooHigh_ThrowException()
	{
		Double expected = Double.POSITIVE_INFINITY * 2;
		
		Double actual = CasterImpl.castToDouble(expected);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_ValueIsInvalidObject_ThrowIllegalArgumentException()
	{
		List<String> objects = new ArrayList<String>();
		
		Double actual = CasterImpl.castToDouble(objects);
	}
	
	@Test
	public void castToDouble_CharacterValueIsValidOfFive_ReturnsFive()
	{
		Double expected = 5.0;
		Character value = '5';
		
		Double actual = CasterImpl.castToDouble(value);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void castToDouble_CharacterValueIsInvalid_ThrowIllegalArgumentException()
	{
		Character value = '$';
		
		Double actual = CasterImpl.castToDouble(value);
	}

}
