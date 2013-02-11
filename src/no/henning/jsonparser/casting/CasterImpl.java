package no.henning.jsonparser.casting;

import no.henning.jsonparser.casting.interfaces.Caster;

public class CasterImpl
{
	private static Casters casters = new Casters();
	
	public static Object cast(Class desiredValueClass, Object value)
	{
		Caster<?> casterImplementation = casters.get(desiredValueClass);
		
		return casterImplementation.cast(value);
	}
	
	public static Double castToDouble(Object value)
	{
		return (Double) cast(Double.class, value);
	}
	
	public static String castToString(Object value)
	{
		return "";
	}
}
