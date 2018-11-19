package erp.aop.gui;

import javax.swing.JTabbedPane;

public final class TabbedPaneHandle {

	public static void desabilitarTabbedPane(JTabbedPane tabbedPane) {
		int totalAbas = tabbedPane.getTabCount();
		for (int x = 0; x < totalAbas; ++x) {
			tabbedPane.setEnabledAt(x, false);
		}
	}

	public static void habilitarTabbedPane(JTabbedPane tabbedPane) {
		int totalAbas = tabbedPane.getTabCount();
		for (int x = 0; x < totalAbas; ++x) {
			tabbedPane.setEnabledAt(x, true);
		}
	}
}
