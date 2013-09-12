/**
 * 
 */
package org.xgbi.vaadin.tabsheet;

import java.util.Collection;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet.Tab;

/**
 * Class to build {@link Tab} and return them to be used by a
 * {@link LazyTabsheet}.
 * 
 * @author Houbeb Ben Othmene
 * @author Vincent Demeester
 */
public interface TabFactory {

	/**
	 * Get the list of tab
	 * 
	 * @return
	 */
	Collection<Component> getTabs();

}
