package org.xgbi.vaadin.container.filter;

import java.util.Arrays;
import java.util.Collection;

import com.google.common.base.Predicate;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;

/**
 * {@link Filter} that use any number of guava {@link Predicate} for filtering
 * the items.
 * 
 * @author Vincent Demeester
 * 
 */
public class PredicateFilter implements Filter {

	private static final long serialVersionUID = -4917086483407241159L;

	private final Collection<Predicate<Item>> predicates;

	public PredicateFilter(Predicate<Item>... predicates) {
		this.predicates = Arrays.asList(predicates);
	}

	@Override
	public boolean passesFilter(Object itemId, Item item)
			throws UnsupportedOperationException {
		boolean passes = true;
		for (Predicate<Item> predicate : predicates) {
			passes = passes && predicate.apply(item);
		}
		return passes;
	}

	@Override
	public boolean appliesToProperty(Object propertyId) {
		return false;
	}

}
