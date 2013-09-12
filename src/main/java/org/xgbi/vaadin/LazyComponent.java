package org.xgbi.vaadin;

import com.vaadin.ui.Component;

/**
 * 
 * @author Vincent Demeester
 *
 */
public interface LazyComponent extends Component {

	/**
	 * @return
	 */
	Component getInnerComponent();
}
