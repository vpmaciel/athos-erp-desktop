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

	private List<Component> componentList;

	public ConfiguracaoGui(Container container) {
		try {

			this.componentList = this.getAllComponents(container);

			for (Component comp : this.componentList) {
				if (comp instanceof JLabel) {
					JLabel label = (JLabel) comp;
					label.setPreferredSize(new Dimension(740, 30));
					label.setMinimumSize(new Dimension(740, 30));
					label.setSize(new Dimension(740, 30));
					label.setMaximumSize(new Dimension(740, 30));
					continue;
				}
				if (comp instanceof JTextField) {
					JTextField field = (JTextField) comp;
					field.setPreferredSize(new Dimension(740, 30));
					field.setMinimumSize(new Dimension(740, 30));
					field.setSize(new Dimension(740, 30));
					field.setMaximumSize(new Dimension(740, 30));
					continue;
				}
				if (comp instanceof JFormattedTextField) {
					JFormattedTextField formattedTextField = (JFormattedTextField) comp;
					formattedTextField.setPreferredSize(new Dimension(740, 30));
					formattedTextField.setMinimumSize(new Dimension(740, 30));
					formattedTextField.setSize(new Dimension(740, 30));
					formattedTextField.setMaximumSize(new Dimension(740, 30));
					continue;
				}
				if (comp instanceof JPasswordField) {
					JPasswordField passwordField = (JPasswordField) comp;
					passwordField.setPreferredSize(new Dimension(740, 30));
					passwordField.setMinimumSize(new Dimension(740, 30));
					passwordField.setSize(new Dimension(740, 30));
					passwordField.setMaximumSize(new Dimension(740, 30));
					continue;
				}
				if (comp instanceof JComboBox<?>) {
					JComboBox<?> comboBox = (JComboBox<?>) comp;
					comboBox.setPreferredSize(new Dimension(740, 30));
					comboBox.setMinimumSize(new Dimension(740, 30));
					comboBox.setSize(new Dimension(740, 30));
					comboBox.setMaximumSize(new Dimension(740, 30));
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
					JTextArea field = (JTextArea) comp;
					field.setPreferredSize(new Dimension(740, 150));
					field.setMinimumSize(new Dimension(740, 150));
					field.setSize(new Dimension(740, 150));
					field.setMaximumSize(new Dimension(740, 150));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void desabilitarGui() {
		try {
			for (Component component : this.componentList) {

				if (component instanceof JTextField) {
					JTextField textField = (JTextField) component;
					textField.setEnabled(false);
					continue;
				}
				if (component instanceof JComboBox) {
					JComboBox<?> comboBox = (JComboBox<?>) component;
					comboBox.setEnabled(false);
					continue;
				}
				if (component instanceof JFormattedTextField) {
					JFormattedTextField formattedTextField = (JFormattedTextField) component;
					formattedTextField.setEnabled(false);
					continue;
				}
				if (component instanceof JTextArea) {
					JTextArea textArea = (JTextArea) component;
					textArea.setEnabled(false);
					continue;
				}
				if (component instanceof JPasswordField) {
					JPasswordField passwordField = (JPasswordField) component;
					passwordField.setEnabled(false);
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Component> getAllComponents(Container c) {

		Component[] component = c.getComponents();
		ArrayList<Component> componentArrayList  = new ArrayList<Component>();
		try {
			for (Component comp : component) {
				componentArrayList.add(comp);
				if (!(comp instanceof Container)) {
					continue;
				}
				componentArrayList.addAll(this.getAllComponents((Container) comp));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return componentArrayList;
	}

	public void habilitarCadastroGui() {
		try {
			for (Component component : this.componentList) {
				if (component instanceof JTextField) {
					JTextField field = (JTextField) component;
					field.setEnabled(true);
					field.setEditable(true);
					continue;
				}
				if (component instanceof JComboBox) {
					JComboBox<?> comboBox = (JComboBox<?>) component;
					comboBox.setEnabled(true);
					continue;
				}
				if (component instanceof JFormattedTextField) {
					JFormattedTextField formattedTextField = (JFormattedTextField) component;
					formattedTextField.setEnabled(true);
					formattedTextField.setEditable(true);
					continue;
				}
				if (component instanceof JTextArea) {
					JTextArea field = (JTextArea) component;
					field.setEnabled(true);
					field.setEditable(true);
					continue;
				}
				if (component instanceof JPasswordField) {
					JPasswordField passwordField = (JPasswordField) component;
					passwordField.setEnabled(true);
					passwordField.setEditable(true);
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void habilitarPesquisaRegistroGui(Container container) {
		try {
			for (Component component : this.componentList) {
				if (component instanceof JTextField) {
					JTextField field = (JTextField) component;
					field.setEnabled(true);
					field.setEditable(true);
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
					JTextArea field = (JTextArea) component;
					field.setEnabled(true);
					field.setEditable(true);
					continue;
				}
				if (!(component instanceof JPasswordField)) {
					continue;
				}
				JPasswordField passwordField = (JPasswordField) component;
				passwordField.setEnabled(true);
				passwordField.setEditable(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void limparGui() {
		try {
			for (Component component : this.componentList) {
				if (component instanceof JComboBox<?>) {
					JComboBox<?> comboBox = (JComboBox<?>) component;
					Integer index = comboBox.getItemCount();
					if (index > 0) {
						comboBox.setSelectedIndex(0);
					}
					continue;
				}
				if (component instanceof JTextField) {
					JTextField field = (JTextField) component;
					field.setText("");
					continue;
				}
				if (component instanceof JFormattedTextField) {
					JFormattedTextField formattedTextField = (JFormattedTextField) component;
					formattedTextField.setText("");
					continue;
				}
				if (component instanceof JPasswordField) {
					JPasswordField passwordField = (JPasswordField) component;
					passwordField.setText("");
					continue;
				}
				if (component instanceof JTextArea) {
					JTextArea textArea = (JTextArea) component;
					textArea.setText("");
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}