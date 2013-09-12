package org.xgbi.vaadin.container;

import static com.google.common.base.Preconditions.checkNotNull;

import com.vaadin.data.Container;
import com.vaadin.data.Item;

/**
 * Simple static methods to do less check and get work quickly when working on
 * {@link Container}.
 * 
 * <p>
 * This is not a Preconditions class like {@link ContainersPreconditions}.
 * </p>
 * 
 * @author Vincent Demeester
 * 
 */
public class Containers {

	private Containers() {
	}

	/**
	 * Check if the container reference passed as argument has the propertyId.
	 * 
	 * @param container
	 *            a container reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @return true if the container has the propertyId, false otherwise.
	 */
	public static boolean containsPropertyId(Container container,
			Object propertyId) {
		checkNotNull(container);
		checkNotNull(container.getContainerPropertyIds());
		return container.getContainerPropertyIds().contains(propertyId);
	}
	
	/**
	 * Check if the item reference passed as argument has the propertyId.
	 * 
	 * @param item
	 *            an item reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @return true if the item has the propertyId, false otherwise.
	 */
	public static boolean containsPropertyId(Item item,
			Object propertyId) {
		checkNotNull(item);
		checkNotNull(item.getItemPropertyIds());
		return item.getItemPropertyIds().contains(propertyId);
	}
}
