package org.exparity.hamcrest.date.testutils;

import java.time.ZoneId;

/**
 * Static repository of {@link ZoneId}
 *
 * @author Stewart Bissett
 */
public abstract class ZoneIds {

	public static final ZoneId GMT = ZoneId.of("GMT"); // 00:00
	public static final ZoneId UTC = ZoneId.of("UTC"); // 00:00
	public static final ZoneId CET = ZoneId.of("Europe/Paris"); // +01:00
	public static final ZoneId EST = ZoneId.of("America/New_York"); // -04:00

}
