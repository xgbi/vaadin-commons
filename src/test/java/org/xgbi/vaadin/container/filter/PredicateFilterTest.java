package org.xgbi.vaadin.container.filter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vaadin.data.Container.Filter;

public class PredicateFilterTest {

	@Test
	public void passesFilterWithNoPredicateShouldAlwaysReturnTrue() {
		Filter filter = new PredicateFilter();
		boolean actual = filter.passesFilter(null, null); // Ugly but..
		assertTrue(actual);
	}
	
	@Test
	public void appliesToPropertyShouldAlwaysReturnFalse() {
		Filter filter = new PredicateFilter();
		boolean actual = filter.appliesToProperty(null); // Ugly
		assertFalse(actual);
		actual = filter.appliesToProperty("Test"); // Ugly
		assertFalse(actual);
	}

}
