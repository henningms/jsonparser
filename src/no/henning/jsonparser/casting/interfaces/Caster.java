package no.henning.jsonparser.casting.interfaces;

public interface Caster<T>
{
	T cast(Object value);
}
