package no.henning.jsonparser.casting;

import java.util.HashMap;

import no.henning.jsonparser.casting.implementations.DoubleCasterImpl;
import no.henning.jsonparser.casting.interfaces.Caster;

public class Casters extends HashMap<Class<?>, Caster<?>>
{
	private static final long serialVersionUID = 1344464643L;

	public Casters()
	{
		put(Double.class, new DoubleCasterImpl());
	}
}
