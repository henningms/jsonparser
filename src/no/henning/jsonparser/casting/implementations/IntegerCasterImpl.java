package no.henning.jsonparser.casting.implementations;

import no.henning.jsonparser.casting.interfaces.Caster;

public class IntegerCasterImpl implements Caster<Integer>
{
	@Override
	public Integer cast(Object value)
	{
		Integer result = 0;
		
		if (value == null)
			throw new IllegalArgumentException("Value can not be null");
		
		if (value instanceof Number)
		{
			result = ((Number)value).intValue();
		}
		
		return result;
	}

}
