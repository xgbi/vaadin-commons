package org.xgbi.vaadin.container;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;

@RunWith(BlockJUnit4ClassRunner.class)
public class ContainersTest {

	Container container;
	Item item;

	@Before
	public void initializeContainer() {
		container = new IndexedContainer();
		container.addContainerProperty("propertyId", Object.class, null);
	}

	@Before
	public void initializeItem() {
		item = new PropertysetItem();
		item.addItemProperty("propertyId", new ObjectProperty<String>("value"));
	}

	@Test(expected = NullPointerException.class)
	public void containsPropertyIdWithNullContainerShouldThrowAnNullPointerException() {
		Containers.containsPropertyId((Container)null, null);
		fail("Should throw a NullPointerException");
	}
	
	@Test(expected = NullPointerException.class)
	public void containsPropertyIdWithNullItemShouldThrowAnNullPointerException() {
		Containers.containsPropertyId((Item)null, null);
		fail("Should throw a NullPointerException");
	}

	@Test
	public void containsPropertyIdWithContainerAndNullOrInvalidPropertyShouldReturnFalse() {
		assertFalse(Containers.containsPropertyId(container, null));
		assertFalse(Containers.containsPropertyId(container, "invalidPropertyId"));
	}
	
	@Test
	public void containsPropertyIdWithContainerShouldReturnTrueOtherwise() {
		assertTrue(Containers.containsPropertyId(container, "propertyId"));
	}
	
	@Test
	public void containsPropertyIdWithItemAndNullOrInvalidPropertyShouldReturnFalse() {
		assertFalse(Containers.containsPropertyId(item, null));
		assertFalse(Containers.containsPropertyId(item, "invalidPropertyId"));
	}
	
	@Test
	public void containsPropertyIdWithItemShouldReturnTrueOtherwise() {
		assertTrue(Containers.containsPropertyId(item, "propertyId"));
	}
}
