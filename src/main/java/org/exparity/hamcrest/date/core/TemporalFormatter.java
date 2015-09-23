package org.exparity.hamcrest.date.core;

/**
 * Return the description of a temporal value
 * 
 * @author Stewart Bissett
 * @param <T> The temporal type
 */
@FunctionalInterface
public interface TemporalFormatter<T> {

	/**
	 * @param temporal the temporal value to describe
	 * @return a pretty description of the temporal value as a date
	 */
	public String describe(final T temporal);
}