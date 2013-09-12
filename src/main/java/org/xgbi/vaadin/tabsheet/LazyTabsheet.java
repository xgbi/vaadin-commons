/**
 * 
 */
package org.xgbi.vaadin.tabsheet;

import java.util.Arrays;
import java.util.Collection;

import org.xgbi.vaadin.LazyComponent;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;

/**
 * A {@link TabSheet} loading component only on selection. The selectedTab is
 * the one added by calling {@link LazyTabsheet#addNoLazyTab(String)} or
 * {@link LazyTabsheet#addNoLazyTab(String, Resource)}.
 * 
 * FIXME: Rewrite to not being able to add tab from there but using the Factory
 * 
 * @author Houbeb Ben Othmene
 * @author Vincent Demeester
 * 
 */
public class LazyTabsheet extends TabSheet implements SelectedTabChangeListener {

	private static final long serialVersionUID = -8720216985546412778L;
	
	/**
	 * A {@link TabSheet} that loads the component on demand, see
	 * {@link SelectedTabChangeListener}
	 */
	public LazyTabsheet() {
		super();
		addListener(this);
		setSizeFull();
	}

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
		if (event.getTabSheet() != null) {
			TabSheet source = event.getTabSheet();
			Component selected = source.getSelectedTab();
			Tab selectedTab = source.getTab(selected);
			if (selected instanceof LazyComponent) {
				String caption = selectedTab.getCaption();
				if (caption != null) {
					Component actualComponent = ((LazyComponent) selected).getInnerComponent();
					// check whether the tab selected contains already the actual
					// component
					if (actualComponent != null && selected != actualComponent) {
						actualComponent.setSizeFull();
						actualComponent.addStyleName("white");
						source.replaceComponent(selected, actualComponent);
					}
				}
			}
		}
	}
	
	/**
	 * Get a TabSheet that takes a factory for specifying the tabs.
	 * 
	 * @param factory
	 * @return
	 */
	public static TabSheet withFactory(TabFactory factory) {
		return fromCollection(factory.getTabs());
	}
	
	public static TabSheet fromComponents(Component... components) {
		return fromCollection(Arrays.asList(components));
	}

	public static TabSheet fromCollection(Collection<Component> components) {
		TabSheet tabSheet = new LazyTabsheet();
		for (Component c : components) {
			tabSheet.addComponent(c);
		}
		return tabSheet;
	}

}
