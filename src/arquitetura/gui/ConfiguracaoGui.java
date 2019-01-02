package arquitetura.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public final class ConfiguracaoGui extends Container {

	private Component[] componentes;
	private List<Component> todosComponentes;

	public ConfiguracaoGui(Container container) {
		this.componentes = this.getComponents();
		this.componentes = container.getComponents();
		this.todosComponentes = this.getAllComponents(container);

		for (Component comp : this.todosComponentes) {
			if (comp instanceof JLabel) {
				JLabel label = (JLabel) comp;
				label.setPreferredSize(new Dimension(740, 25));
				label.setMinimumSize(new Dimension(740, 25));
				label.setSize(new Dimension(740, 25));
				label.setMaximumSize(new Dimension(740, 25));
				continue;
			}
			if (comp instanceof JTextField) {
				JTextField textField = (JTextField) comp;
				textField.setPreferredSize(new Dimension(740, 25));
				textField.setMinimumSize(new Dimension(740, 25));
				textField.setSize(new Dimension(740, 25));
				textField.setMaximumSize(new Dimension(740, 25));
				continue;
			}
			if (comp instanceof JFormattedTextField) {
				JFormattedTextField formattedTextField = (JFormattedTextField) comp;
				formattedTextField.setPreferredSize(new Dimension(740, 25));
				formattedTextField.setMinimumSize(new Dimension(740, 25));
				formattedTextField.setSize(new Dimension(740, 25));
				formattedTextField.setMaximumSize(new Dimension(740, 25));
				continue;
			}
			if (comp instanceof JPasswordField) {
				JPasswordField passwordField = (JPasswordField) comp;
				passwordField.setPreferredSize(new Dimension(740, 25));
				passwordField.setMinimumSize(new Dimension(740, 25));
				passwordField.setSize(new Dimension(740, 25));
				passwordField.setMaximumSize(new Dimension(740, 25));
				continue;
			}
			if (comp instanceof JComboBox<?>) {
				JComboBox<?> comboBox = (JComboBox<?>) comp;
				comboBox.setPreferredSize(new Dimension(740, 25));
				comboBox.setMinimumSize(new Dimension(740, 25));
				comboBox.setSize(new Dimension(740, 25));
				comboBox.setMaximumSize(new Dimension(740, 25));
				continue;
			}
			if (comp instanceof JScrollPane) {
				JScrollPane scrollPane = (JScrollPane) comp;
				scrollPane.setPreferredSize(new Dimension(740, 150));
				scrollPane.setMinimumSize(new Dimension(740, 150));
				scrollPane.setSize(new Dimension(740, 150));
				scrollPane.setMaximumSize(new Dimension(740, 150));
			}
			if (comp instanceof JTextArea) {
				JTextArea textArea = (JTextArea) comp;
				textArea.setPreferredSize(new Dimension(740, 150));
				textArea.setMinimumSize(new Dimension(740, 150));
				textArea.setSize(new Dimension(740, 150));
				textArea.setMaximumSize(new Dimension(740, 150));
			}
		}
	}

	public void desabilitarGui() {
		for (Component comp : this.todosComponentes) {
			JTextArea textArea;
			if (comp instanceof JTextField) {
				JTextField textField = (JTextField) comp;
				textField.setEnabled(false);
				continue;
			}
			if (comp instanceof JComboBox) {
				JComboBox<?> comboBox = (JComboBox<?>) comp;
				comboBox.setEnabled(false);
				continue;
			}
			if (comp instanceof JFormattedTextField) {
				JFormattedTextField formattedTextField = (JFormattedTextField) comp;
				formattedTextField.setEnabled(false);
				continue;
			}
			if (comp instanceof JTextArea) {
				textArea = (JTextArea) comp;
				textArea.setEnabled(false);
				continue;
			}
			if (comp instanceof JPasswordField) {
				JPasswordField passwordField = (JPasswordField) comp;
				passwordField.setEnabled(false);
				continue;
			}
			if (!(comp instanceof JTextArea)) {
				continue;
			}
			textArea = (JTextArea) comp;
			textArea.setEnabled(false);
		}
	}

	public List<Component> getAllComponents(Container c) {
		Component[] comps = c.getComponents();
		ArrayList<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (!(comp instanceof Container)) {
				continue;
			}
			compList.addAll(this.getAllComponents((Container) comp));
		}
		return compList;
	}

	public void habilitarCadastroGui() {
		for (int i = 0; i < this.componentes.length; ++i) {
			if (this.componentes[i] instanceof JTextField) {
				JTextField textField = (JTextField) this.componentes[i];
				textField.setEnabled(true);
				textField.setEditable(true);
				continue;
			}
			if (this.componentes[i] instanceof JComboBox) {
				JComboBox<?> comboBox = (JComboBox<?>) this.componentes[i];
				comboBox.setEnabled(true);
				continue;
			}
			if (this.componentes[i] instanceof JFormattedTextField) {
				JFormattedTextField formattedTextField = (JFormattedTextField) this.componentes[i];
				formattedTextField.setEnabled(true);
				formattedTextField.setEditable(true);
				continue;
			}
			if (this.componentes[i] instanceof JTextArea) {
				JTextArea textArea = (JTextArea) this.componentes[i];
				textArea.setEnabled(true);
				textArea.setEditable(true);
				continue;
			}
			if (this.componentes[i] instanceof JPasswordField) {
				JPasswordField passwordField = (JPasswordField) this.componentes[i];
				passwordField.setEnabled(true);
				passwordField.setEditable(true);
				continue;
			}
			if (!(this.componentes[i] instanceof JScrollPane)) {
				continue;
			}
			JScrollPane scrollPane = (JScrollPane) this.componentes[i];
			Component[] c = scrollPane.getViewport().getComponents();
			for (int t = 0; t < c.length; ++t) {
				if (!(c[t] instanceof JTextArea)) {
					continue;
				}
				JTextArea textArea = (JTextArea) c[t];
				textArea.setEnabled(true);
				textArea.setEditable(true);
			}
		}
	}

	public void habilitarPesquisaRegistroGui(Container container) {
		for (Component component : this.getAllComponents(container)) {
			if (component instanceof JTextField) {
				JTextField textField = (JTextField) component;
				textField.setEnabled(true);
				textField.setEditable(true);
				continue;
			}
			if (component instanceof JComboBox) {
				JComboBox<?> comboBox = (JComboBox<?>) component;
				comboBox.setEnabled(true);
				comboBox.setEditable(true);
				continue;
			}
			if (component instanceof JFormattedTextField) {
				JFormattedTextField formattedTextField = (JFormattedTextField) component;
				formattedTextField.setEnabled(true);
				formattedTextField.setEditable(true);
				continue;
			}
			if (component instanceof JTextArea) {
				JTextArea textArea = (JTextArea) component;
				textArea.setEnabled(true);
				textArea.setEditable(true);
				continue;
			}
			if (!(component instanceof JPasswordField)) {
				continue;
			}
			JPasswordField passwordField = (JPasswordField) component;
			passwordField.setEnabled(true);
			passwordField.setEditable(true);
		}
	}

	public void limparGui() {
		for (Component comp : this.todosComponentes) {
			if (comp instanceof JTextField) {
				JTextField textField = (JTextField) comp;
				textField.setText("");
				continue;
			}
			if (comp instanceof JFormattedTextField) {
				JFormattedTextField formattedTextField = (JFormattedTextField) comp;
				formattedTextField.setText("");
				continue;
			}
			if (comp instanceof JPasswordField) {
				JPasswordField passwordField = (JPasswordField) comp;
				passwordField.setEnabled(true);
				continue;
			}
			if (comp instanceof JScrollPane) {
				JScrollPane scrollPane = (JScrollPane) comp;
				Component[] c = scrollPane.getViewport().getComponents();
				for (int t = 0; t < c.length; ++t) {
					if (!(c[t] instanceof JTextArea)) {
						continue;
					}
					JTextArea textArea = (JTextArea) c[t];
					textArea.setText("");
				}
			}
		}
	}
}