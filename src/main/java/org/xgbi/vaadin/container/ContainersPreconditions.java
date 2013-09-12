package org.xgbi.vaadin.container;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Preconditions;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;

/**
 * Simple static methods to be called to verify correct state or elements of
 * {@link Container}s and related stuff ({@link Property}, {@link Item}, ...).
 * 
 * The inspiration is clearly {@link Preconditions}, and it even use it.
 * 
 * @author Vincent Demeester
 * 
 */
public class ContainersPreconditions {

	private ContainersPreconditions() {
	}

	/**
	 * Ensures that a container reference passed as a parameter to the calling
	 * method contains a propertyId.
	 * 
	 * @param container
	 *            a container reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @param errorMessage
	 *            the exception message to use if the check fails; will be
	 *            converted to a string using {@link String#valueOf(Object)}
	 * @return the non-null propertyId that was validated
	 * @throws IllegalStateException
	 *             if the container does not contain the propertyId
	 */
	public static <T> T checkPropertyId(Container container, T propertyId,
			Object errorMessage) {
		checkNotNull(container);
		checkNotNull(propertyId);
		checkNotNull(container.getContainerPropertyIds(),
				"The container has no propertyIds.");
		if (!container.getContainerPropertyIds().contains(propertyId)) {
			throw new IllegalStateException(String.valueOf(errorMessage));
		}
		return propertyId;
	}

	/**
	 * Ensures that a container reference passed as a parameter to the calling
	 * method contains a propertyId.
	 * 
	 * @param container
	 *            a container reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @return the non-null propertyId that was validated
	 * @throws IllegalStateException
	 *             if the container does not contain the propertyId
	 */
	public static <T> T checkPropertyId(Container container, T propertyId) {
		return checkPropertyId(container, propertyId, "Container " + container
				+ " does not contains " + propertyId);
	}

	/**
	 * Ensures that a item reference passed as a parameter to the calling method
	 * contains a propertyId.
	 * 
	 * @param item
	 *            an item reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @param errorMessage
	 *            the exception message to use if the check fails; will be
	 *            converted to a string using {@link String#valueOf(Object)}
	 * @return the non-null propertyId that was validated
	 * @throws IllegalStateException
	 *             if the item does not contain the propertyId
	 */
	public static <T> T checkPropertyId(Item item, T propertyId, Object errorMessage) {
		checkNotNull(item);
		checkNotNull(propertyId);
		checkNotNull(item.getItemPropertyIds(),
				"The container has no propertyIds.");
		if (!item.getItemPropertyIds().contains(propertyId)) {
			throw new IllegalStateException(String.valueOf(errorMessage));
		}
		return propertyId;
	}

	/**
	 * Ensures that a item reference passed as a parameter to the calling method
	 * contains a propertyId.
	 * 
	 * @param item
	 *            an item reference
	 * @param propertyId
	 *            an object reference representing the propertyId
	 * @return the non-null propertyId that was validated
	 * @throws IllegalStateException
	 *             if the item does not contain the propertyId
	 */
	public static <T> T checkPropertyId(Item item, T propertyId) {
		return checkPropertyId(item, propertyId, "Item " + item
				+ " does not contains " + propertyId);
	}
}
