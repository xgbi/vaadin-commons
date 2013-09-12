/**
 * 
 */
package org.xgbi.vaadin.tabsheet;

import java.util.Collection;

import com.vaadin.ui.Component;

/**
 * @author Houbeb Ben Othmene
 * @author Vincent Demeester
 * 
 */
public interface TabFactory {

	/**
	 * Get the list of tab
	 * @return
	 */
	Collection<Component> getTabs();
	
}
