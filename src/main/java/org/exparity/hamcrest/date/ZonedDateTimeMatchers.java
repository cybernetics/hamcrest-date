package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;

import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.exparity.hamcrest.date.core.IsMaximum;
import org.exparity.hamcrest.date.core.IsMinimum;
import org.exparity.hamcrest.date.core.IsMinute;
import org.exparity.hamcrest.date.core.IsMonth;
import org.exparity.hamcrest.date.core.IsSame;
import org.exparity.hamcrest.date.core.IsSameDay;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.exparity.hamcrest.date.core.IsSecond;
import org.exparity.hamcrest.date.core.IsWithin;
import org.exparity.hamcrest.date.core.IsYear;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for
 * comparing {@link ZonedDateTime} instances
 * 
 * @author Stewart Bissett
 */
public abstract class ZonedDateTimeMatchers {

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, after(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the timezone of the reference date
	 */
	public static Matcher<ZonedDateTime> after(final Date date, final ZoneId tz) {
		return after(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, after(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the timezone of the reference date
	 */
	public static Matcher<ZonedDateTime> after(final LocalDateTime date, final ZoneId tz) {
		return after(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, after(ZonedDateTime.now()));
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> after(final ZonedDateTime date) {
		return new IsAfter<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, after(2012, Month.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param dayOfMonth
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 */
	public static Matcher<ZonedDateTime> after(final int year,
			final Month month,
			final int dayOfMonth,
			final int hour,
			final int minute,
			final int second,
			final ZoneId tz) {
		return after(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> before(final Date date, final ZoneId tz) {
		return before(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(LocalDateTime.now(), ZoneId.systemDefailt()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> before(final LocalDateTime date, final ZoneId tz) {
		return before(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(ZonedDateTime.now()));
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> before(final ZonedDateTime date) {
		return new IsBefore<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the end
	 * of the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(2012, Month.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param dayOfMonth
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 */
	public static Matcher<ZonedDateTime> before(final int year,
			final Month month,
			final int dayOfMonth,
			final int hour,
			final int minute,
			final int second,
			final ZoneId tz) {
		return before(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDay(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameDay(final Date date, final ZoneId tz) {
		return sameDay(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDay(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameDay(final LocalDateTime date, final ZoneId tz) {
		return sameDay(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDay(ZonedDateTime.now()));
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameDay(final ZonedDateTime date) {
		return new IsSameDay<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDay(2012, Month.JAN, 1, ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param dayOfMonth
	 *            the reference day of the month against which the examined date
	 *            is checked
	 * @param month
	 *            the reference month against which the examined date is checked
	 * @param year
	 *            the reference year against which the examined date is checked
	 * @param tz
	 *            the reference time zone
	 */
	public static Matcher<ZonedDateTime> sameDay(final int year,
			final Month month,
			final int dayOfMonth,
			final ZoneId tz) {
		return sameDay(LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instant of the year as the reference date down to the millisecond in the
	 * specified time zone
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(new Date(), ZoneId.systemDefault())
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the timezone the reference date is in
	 */
	public static Matcher<ZonedDateTime> sameInstant(final Date date, final ZoneId tz) {
		return sameInstant(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instant of the year as the reference date in the specified time zone
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(LocalDate.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone the reference date is in
	 */
	public static Matcher<ZonedDateTime> sameInstant(final LocalDateTime date, final ZoneId tz) {
		return sameInstant(ZonedDateTime.of(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(ZonedDateTime.now()));
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameInstant(final ZonedDateTime date) {
		return new IsSame<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * specified instance down to the second
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(2012, Month.JAN, 1, 3, 15, 0))
	 * </pre>
	 * 
	 * @param dayOfMonth
	 *            the reference day of the month against which the examined date
	 *            is checked
	 * @param month
	 *            the reference month against which the examined date is checked
	 * @param year
	 *            the reference year against which the examined date is checked
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 * @param nanos
	 *            the nanosecond of the second
	 * @param tz
	 *            the timezone of the instant
	 */
	public static Matcher<ZonedDateTime> sameInstant(final int year,
			final Month month,
			final int dayOfMonth,
			final int hour,
			final int minute,
			final int second,
			final int nanos,
			final ZoneId tz) {
		return sameInstant(ZonedDateTime.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos), tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrBefore(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameOrBefore(final ZonedDateTime date) {
		return new IsSameOrBefore<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrBefore(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameOrBefore(final Date date, final ZoneId tz) {
		return sameOrBefore(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrBefore(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameOrBefore(final LocalDateTime date, final ZoneId tz) {
		return sameOrBefore(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or before the start of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 11, 59, 59, ZoneId.systemDefault()));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 * @param tz
	 *            the time zone of the date to check against
	 */
	@Factory
	public static Matcher<ZonedDateTime> sameOrBefore(final int year,
			final Month month,
			final int day,
			final int hour,
			final int minute,
			final int second,
			final ZoneId tz) {
		return sameOrBefore(LocalDateTime.of(year, month, day, hour, minute, second), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrAfter(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameOrAfter(final Date date, final ZoneId tz) {
		return sameOrAfter(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrAfter(LocalDateTime.now(), ZoneId.systemDefaut()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameOrAfter(final LocalDateTime date, final ZoneId tz) {
		return sameOrAfter(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrAfter(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameOrAfter(final ZonedDateTime date) {
		return new IsSameOrAfter<ZonedDateTime>(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or after the start of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 */
	public static Matcher<ZonedDateTime> sameOrAfter(final int year,
			final Month month,
			final int day,
			final int hour,
			final int minute,
			final int second,
			final ZoneId tz) {
		return sameOrAfter(LocalDateTime.of(year, month, day, hour, minute, second), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMonth(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameMonthOfYear(final Date date, final ZoneId tz) {
		return sameMonthOfYear(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMonth(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameMonthOfYear(final LocalDateTime date, final ZoneId tz) {
		return sameMonthOfYear(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMonth(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameMonthOfYear(final ZonedDateTime date) {
		return isMonth(date.getMonth());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfMonth(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameDayOfMonth(final Date date, final ZoneId tz) {
		return sameDayOfMonth(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfMonth(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameDayOfMonth(final LocalDateTime date, final ZoneId tz) {
		return sameDayOfMonth(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfMonth(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameDayOfMonth(final ZonedDateTime date) {
		return isDayOfMonth(date.getDayOfMonth());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isDayOfMonth(4))
	 * </pre>
	 * 
	 * @param date
	 *            the expected day of the month
	 */
	public static Matcher<ZonedDateTime> isDayOfMonth(final int dayOfMonth) {
		return new IsDayOfMonth<ZonedDateTime>(dayOfMonth);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameYear(final Date date, final ZoneId tz) {
		return isYear(toZonedDateTime(date, tz).getYear());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameYear(final LocalDateTime date, final ZoneId tz) {
		return isYear(toZonedDateTime(date, tz).getYear());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameYear(final ZonedDateTime date) {
		return isYear(date.getYear());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(2013))
	 * </pre>
	 * 
	 * @param year
	 *            the reference year against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> isYear(final int year) {
		return new IsYear<ZonedDateTime>(year);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.MINUTES, new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> within(final long period,
			final ChronoUnit unit,
			final Date date,
			final ZoneId tz) {
		return within(period, unit, toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.MINUTES, LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> within(final long period,
			final ChronoUnit unit,
			final LocalDateTime date,
			final ZoneId tz) {
		return within(period, unit, toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.DAYS, Moments.today()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> within(final long period, final ChronoUnit unit, final ZonedDateTime date) {
		return new IsWithin<ZonedDateTime>(period, unit, date);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given
	 * period of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(5, TimeUnit.DAYS, 2012, Months.MAY, 12));
	 * </pre>
	 * 
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param dayofMonth
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 * @param hour
	 *            the hour of the day
	 * @param minute
	 *            the minute of the hour
	 * @param second
	 *            the second of the minute
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> within(final long period,
			final ChronoUnit unit,
			final int year,
			final Month month,
			final int dayofMonth,
			final int hour,
			final int minute,
			final int second,
			final ZoneId tz) {
		return within(period, unit, LocalDateTime.of(year, month, dayofMonth, hour, minute, second), tz);
	}

	/**
	 * Creates a matcher that matches when the examined date is yesterday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isYesterday() {
		return sameDay(ZonedDateTime.now().plusDays(-1));
	}

	/**
	 * Creates a matcher that matches when the examined date is today
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isToday() {
		return sameDay(ZonedDateTime.now());
	}

	/**
	 * Creates a matcher that matches when the examined date is tomorrow
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isTomorrow());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isTomorrow() {
		return sameDay(ZonedDateTime.now().plusDays(1));
	}

	/**
	 * Creates a matcher that matches when the examined date is on a monday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isDayOfWeek(final DayOfWeek... dayOfWeek) {
		return new IsDayOfWeek<ZonedDateTime>(dayOfWeek);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a monday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isMonday() {
		return isDayOfWeek(MONDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a tuesday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isTuesday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isTuesday() {
		return isDayOfWeek(TUESDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a wednesday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWednesday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isWednesday() {
		return isDayOfWeek(WEDNESDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a thursday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isThursday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isThursday() {
		return isDayOfWeek(THURSDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a friday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFriday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isFriday() {
		return isDayOfWeek(FRIDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a saturday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSaturday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isSaturday() {
		return isDayOfWeek(SATURDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a sunday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSunday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isSunday() {
		return isDayOfWeek(SUNDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a weekday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWeekday());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isWeekday() {
		return isDayOfWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a weekend
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWeekend());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isWeekend() {
		return isDayOfWeek(SATURDAY, SUNDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day
	 * of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isFirstDayOfMonth() {
		return isMinimum(ChronoField.DAY_OF_MONTH);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the maximum
	 * value of the given date part in its period
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 * 
	 * @param field
	 *            the temporal field to check
	 */
	public static Matcher<ZonedDateTime> isMinimum(final TemporalField field) {
		return new IsMinimum<ZonedDateTime>(field);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day
	 * of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isLastDayOfMonth() {
		return isMaximum(ChronoField.DAY_OF_MONTH);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the maximum
	 * value of the given date part in its period
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 * 
	 * @param field
	 *            the temporal field to check
	 */
	public static Matcher<ZonedDateTime> isMaximum(final TemporalField field) {
		return new IsMaximum<ZonedDateTime>(field);
	}

	/**
	 * Creates a matcher that matches when the examined date is in the expected
	 * month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMonth(Month.AUGUST));
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isMonth(final Month month) {
		return new IsMonth<ZonedDateTime>(month);
	}

	/**
	 * Creates a matcher that matches when the examined date is in January
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJanuary());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isJanuary() {
		return isMonth(JANUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in February
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFebruary());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isFebruary() {
		return isMonth(FEBRUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in March
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMarch());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isMarch() {
		return isMonth(MARCH);
	}

	/**
	 * Creates a matcher that matches when the examined date is in April
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isApril());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isApril() {
		return isMonth(APRIL);
	}

	/**
	 * Creates a matcher that matches when the examined date is in May
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMay());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isMay() {
		return isMonth(MAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in June
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJune());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isJune() {
		return isMonth(JUNE);
	}

	/**
	 * Creates a matcher that matches when the examined date is in July
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJuly());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isJuly() {
		return isMonth(JULY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in August
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isAugust());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isAugust() {
		return isMonth(AUGUST);
	}

	/**
	 * Creates a matcher that matches when the examined date is in September
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSeptember());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isSeptember() {
		return isMonth(SEPTEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in October
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isOctober());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isOctober() {
		return isMonth(OCTOBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in November
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isNovember());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isNovember() {
		return isMonth(NOVEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in December
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isDecember());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isDecember() {
		return isMonth(DECEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is a leap year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isLeapYear());
	 * </pre>
	 */
	public static Matcher<ZonedDateTime> isLeapYear() {
		return new IsLeapYear<ZonedDateTime>();
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * hour (0-23)
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isHour(12));
	 * </pre>
	 * 
	 * @param hour
	 *            the hour of the day (0-23)
	 */
	public static Matcher<ZonedDateTime> isHour(final int hour) {
		return new IsHour<ZonedDateTime>(hour);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameHourOfDay(final Date date, final ZoneId tz) {
		return sameHourOfDay(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameHourOfDay(final LocalDateTime date, final ZoneId tz) {
		return sameHourOfDay(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameHourOfDay(final ZonedDateTime date) {
		return isHour(date.getHour());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * minute (0-59)
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMinute(12));
	 * </pre>
	 * 
	 * @param Minute
	 *            the minute of the day (0-59)
	 */
	public static Matcher<ZonedDateTime> isMinute(final int minute) {
		return new IsMinute<ZonedDateTime>(minute);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Minute as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameMinuteOfHour(final Date date, final ZoneId tz) {
		return sameMinuteOfHour(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Minute as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameMinuteOfHour(final LocalDateTime date, final ZoneId tz) {
		return sameMinuteOfHour(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * minute as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameMinuteOfHour(final ZonedDateTime date) {
		return isMinute(date.getMinute());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * second (0-59)
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSecond(12));
	 * </pre>
	 * 
	 * @param Second
	 *            the second of the day (0-59)
	 */
	public static Matcher<ZonedDateTime> isSecond(final int Second) {
		return new IsSecond<ZonedDateTime>(Second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Second as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(new Date(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameSecondOfMinute(final Date date, final ZoneId tz) {
		return sameSecondOfMinute(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Second as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(LocalDateTime.now(), ZoneId.systemDefault()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param tz
	 *            the time zone of the reference date
	 */
	public static Matcher<ZonedDateTime> sameSecondOfMinute(final LocalDateTime date, final ZoneId tz) {
		return sameSecondOfMinute(toZonedDateTime(date, tz));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(ZonedDateTime.now()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<ZonedDateTime> sameSecondOfMinute(final ZonedDateTime date) {
		return isSecond(date.getSecond());
	}

	private static ZonedDateTime toZonedDateTime(final Date date, final ZoneId tz) {
		return date.toInstant().atZone(tz);
	}

	private static ZonedDateTime toZonedDateTime(final LocalDateTime date, final ZoneId tz) {
		return ZonedDateTime.of(date, tz);
	}

}