package org.xgbi.vaadin.tabsheet;

import static org.junit.Assert.fail;
import static org.xgbi.assertj.vaadin.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

public class LazyTabSheetTest {
	
	Collection<Component> components;
	
	@Before
	public void initializeComponents() {
		components = new HashSet<Component>();
		components.add(new Button());
		components.add(new Label());
	}

	@Test
	public void lazyTabSheetEmptyShouldHaveNoTabsAndASelectedTabListener() {
		LazyTabSheet tabsheet = new LazyTabSheet();
		assertThat(tabsheet)
				.hasListener(SelectedTabChangeEvent.class)
				.hasNoTab();
	}

	@Test(expected = NullPointerException.class)
	public void fromCollectionWithNullShouldThrowANullPointerException() {
		LazyTabSheet.fromCollection(null);
		fail("Should throw a NullPointerException");
	}
	
	@Test(expected = NullPointerException.class)
	public void fromComponentsWithNullShouldThrowANullPointerException() {
		LazyTabSheet.fromComponents((Component[])null);
		fail("Should throw a NullPointerException");
	}
	
	@Test(expected = NullPointerException.class)
	public void fromFactoryWithNullShouldThrowANullPointerException() {
		LazyTabSheet.withFactory(null);
		fail("Should throw a NullPointerException");
	}

	@Test
	public void fromComponentsWithNoArgumentsShouldHaveNoTabsAndASelectedTabListener() {
		TabSheet tabsheet = LazyTabSheet.fromComponents();
		assertThat(tabsheet)
				.hasListener(SelectedTabChangeEvent.class)
				.hasNoTab();
	}
	
	@Test
	public void fromCollectionWithEmptyCollectionShouldHaveNoTabsAndASelectedTabListener() {
		TabSheet tabsheet = LazyTabSheet.fromCollection(Arrays
				.asList(new Component[] {}));
		assertThat(tabsheet)
				.hasListener(SelectedTabChangeEvent.class)
				.hasNoTab();
	}
	
	@Test
	public void fromCollectionWithCollectionShouldHaveTheSameNumberOfTabsAsTheCollection() {
		TabSheet tabsheet = LazyTabSheet.fromCollection(components);
		assertThat(tabsheet)
				.hasTabCount(components.size());
	}
	
	@Test
	public void fromFactoryWithShouldHaveTheSameNumberOfTabsAsTheFactory() {
		TabSheet tabsheet = LazyTabSheet.withFactory(new SampleFactory());
		assertThat(tabsheet)
			.hasTabCount(components.size());
	}
	
	private class SampleFactory implements TabFactory {
		
		public SampleFactory() {}

		@Override
		public Collection<Component> getTabs() {
			return components;
		}
	}

}
