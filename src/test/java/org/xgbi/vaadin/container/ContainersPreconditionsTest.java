package org.xgbi.vaadin.container;

import static org.junit.Assert.assertEquals;
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
public class ContainersPreconditionsTest {

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

	@Test
	public void checkPropertyIdWithNullObjectsShouldFail() {
		try {
			ContainersPreconditions.checkPropertyId((Container) null, null);
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
		try {
			ContainersPreconditions.checkPropertyId(new IndexedContainer(),
					null);
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
		try {
			ContainersPreconditions.checkPropertyId((Container) null,
					new Object());
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
		try {
			ContainersPreconditions.checkPropertyId((Item) null, null);
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
		try {
			ContainersPreconditions
					.checkPropertyId(new PropertysetItem(), null);
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
		try {
			ContainersPreconditions.checkPropertyId((Item) null, new Object());
			fail("Should throw a NullPointerException");
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void checkPropertyIdWithEmptyContainerShouldFail() {
		try {
			ContainersPreconditions.checkPropertyId(new IndexedContainer(),
					"propertyId");
			fail("Should throw a IllegalStateException");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	public void checkPropertyIdWithContainerAndInvalidPropertyShouldFail() {
		try {
			ContainersPreconditions.checkPropertyId(container, "invalidPropertyId");
			fail("Should throw a IllegalStateException");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	public void checkPropertyIdWithContainerAndValidPropertyShouldReturnPropertyId() {
		Object actual = ContainersPreconditions.checkPropertyId(container, "propertyId");
		assertTrue(actual instanceof String);
		assertEquals("propertyId", actual);
	}

	@Test
	public void checkPropertyIdWithEmptyItemShouldFail() {
		try {
			ContainersPreconditions.checkPropertyId(new PropertysetItem(),
					"propertyId");
			fail("Should throw a IllegalStateException");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	public void checkPropertyIdWithItemAndInvalidPropertyShouldFail() {
		try {
			ContainersPreconditions.checkPropertyId(item, "invalidPropertyId");
			fail("Should throw a IllegalStateException");
		} catch (IllegalStateException e) {
		}
	}
	@Test
	public void checkPropertyIdWithItemAndValidPropertyShouldReturnPropertyId() {
		Object actual = ContainersPreconditions.checkPropertyId(item, "propertyId");
		assertTrue(actual instanceof String);
		assertEquals("propertyId", actual);
	}
}
