package org.xgbi.vaadin;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * {@link LazyComponent} is an interface defining {@link Component} that is
 * actually a placeholder for a real {@link Component}.
 * <p>
 * {@link LazyComponent} are used for component that have multiple
 * {@link Component} but display only one ({@link TabSheet} for example).
 * </p>
 * 
 * @author Vincent Demeester
 * 
 */
public interface LazyComponent extends Component {

	/**
	 * Get the real {@link Component}.
	 * 
	 * @return
	 */
	Component getInnerComponent();
}
