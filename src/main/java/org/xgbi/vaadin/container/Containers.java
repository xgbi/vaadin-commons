package org.xgbi.vaadin.container;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.xgbi.vaadin.container.ContainersPreconditions.checkPropertyId;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;

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
	 * 
	 * @throws NullPointerException
	 *             if the container is null, the propertyIds of the container is
	 *             null.
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
	 * 
	 * @throws NullPointerException
	 *             if the container is null, the propertyIds of the container is
	 *             null.
	 */
	public static boolean containsPropertyId(Item item, Object propertyId) {
		checkNotNull(item);
		checkNotNull(item.getItemPropertyIds());
		return item.getItemPropertyIds().contains(propertyId);
	}

	/**
	 * Check if the property has a value.
	 * 
	 * @param property
	 *            the property reference
	 * @return true if it has a value, false otherwise.
	 * 
	 * @throws NullPointerException
	 *             if the property is null.
	 */
	public static boolean propertyHasValue(Property property) {
		checkNotNull(property);
		return property.getValue() != null;
	}

	/**
	 * Return the value of the property identified by the container, itemId and
	 * propertyId.
	 * 
	 * @param container
	 *            the container reference
	 * @param itemId
	 *            the itemId reference
	 * @param propertyId
	 *            the propertyId reference
	 * @return the value if it exists, null otherwise.
	 * 
	 * @throws NullPointerException
	 *             if the container, itemId or propertyId are null.
	 */
	public static Object getValueOfProperty(Container container, Object itemId,
			Object propertyId) {
		checkPropertyId(container, propertyId);
		if (container.containsId(itemId)) {
			Item item = container.getItem(itemId);
			return getValueOfProperty(item, propertyId);
		}
		return null;
	}

	/**
	 * Return the value of the property identified by the item and propertyId.
	 * 
	 * @param item
	 *            the item reference
	 * @param propertyId
	 *            the propertyId reference
	 * @return the value if it exists, null otherwise.
	 * 
	 * @throws NullPointerException
	 *             if the item or propertyId are null.
	 */
	public static Object getValueOfProperty(Item item, Object propertyId) {
		checkPropertyId(item, propertyId);
		Property property = item.getItemProperty(propertyId);
		if (propertyHasValue(property)) {
			return property.getValue();
		}
		return null;
	}
}
