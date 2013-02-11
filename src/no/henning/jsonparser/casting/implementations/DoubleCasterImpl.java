package no.henning.jsonparser.casting.implementations;

import no.henning.jsonparser.casting.interfaces.Caster;

public class DoubleCasterImpl implements Caster<Double>
{
	@Override
	public Double cast(Object value)
	{
		Double result = 0.0;

		if (value == null)
			throw new IllegalArgumentException("Value can not be null");

		try
		{
			if (value instanceof String)
			{
				result = Double.parseDouble((String) value);
			}
			else if (value instanceof Number)
			{
				result = ((Number) value).doubleValue();
			}
			else if (value instanceof Character)
			{
				String stringValue = value.toString();
				result = Double.parseDouble(stringValue);
			}
			else
			{
				throw new IllegalArgumentException(
						"Value can not be converted from type "
								+ value.getClass().getSimpleName());
			}
		}
		catch (NumberFormatException numberFormatException)
		{
			throw new IllegalArgumentException("Value is not a valid number",
					numberFormatException);
		}
		
		return result;
	}

}
