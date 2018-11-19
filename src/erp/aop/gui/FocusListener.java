package erp.aop.gui;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public final class FocusListener extends FocusAdapter {

	Component component;

	@Override
	public void focusGained(FocusEvent evt) {
		@SuppressWarnings("unused")
		Component c = evt.getOppositeComponent();
	}

	@Override
	public void focusLost(FocusEvent evt) {
		@SuppressWarnings("unused")
		Component c = evt.getOppositeComponent();
		this.component.requestFocus();
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}
