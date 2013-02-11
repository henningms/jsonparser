package no.henning.jsonparser.casting.implementations;

import no.henning.jsonparser.casting.interfaces.Caster;

public class StringCasterImpl implements Caster<String>
{

	@Override
	public String cast(Object value)
	{
		String result = "";
		
		if (value == null)
			throw new IllegalArgumentException("Value can not be null");
		
		if (value instanceof String)
		{
			result = (String) value;
		}
		else if (value instanceof Number)
		{
			result = ((Number)value).toString();
		}
		else if (value instanceof Boolean)
		{
			result = Boolean.toString((Boolean)value);
		}
		else
		{
			throw new IllegalArgumentException("Value is not valid for conversion");
		}
		
		return result;
	}

}
