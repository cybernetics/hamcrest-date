/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.IsSameOrAfter.isSameOrAfter;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_PM_GMT;

/**
 * Unit Tests for the {@link isSameOrAfterTest} class
 * 
 * @author Stewart Bissett
 */
public class IsSameOrAfterTest {

	@Test
	public void canCompareTheSameDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isSameOrAfter(JAN_1ST_2012_11_AM_GMT));
	}

	@Test
	public void canCompareABeforeDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isSameOrAfter(JAN_1ST_2012_11_PM_GMT)));
	}

	@Test
	public void canCompareALaterDate() {
		assertThat(JAN_1ST_2012_11_PM_GMT, isSameOrAfter(JAN_1ST_2012_11_AM_GMT));
	}

	@Test
	public void canCompareTheSameDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isSameOrAfter(2012, Months.JAN, 1));
	}

	@Test
	public void canCompareABeforeDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isSameOrAfter(2012, Months.JAN, 2)));
	}

	@Test
	public void canCompareALaterDayMonthYear() {
		assertThat(JAN_1ST_2012_11_PM_GMT, isSameOrAfter(2011, Months.DEC, 31));
	}

	@Test
	public void canCompareTheSameDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isSameOrAfter(2012, Months.JAN, 1, 11, 00, 00));
	}

	@Test
	public void canCompareABeforeDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isSameOrAfter(2012, Months.JAN, 1, 12, 00, 00)));
	}

	@Test
	public void canCompareALaterDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_PM_GMT, isSameOrAfter(2012, Months.JAN, 1, 10, 00, 00));
	}

}
