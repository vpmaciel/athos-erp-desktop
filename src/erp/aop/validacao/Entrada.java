package erp.aop.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import erp.aop.gui.Msg;

public final class Entrada {

	public static boolean validar(JComboBox<?> box, JLabel label) {
		if (box.getSelectedItem() == null) {
			Msg.avisoCampoObrigatorio(label.getText());
			box.requestFocus();
			return false;
		}
		return true;
	}

	public static boolean validar(JPasswordField textField1, JLabel label1, JPasswordField textField2, JLabel label2) {
		String valor1 = new String(textField1.getPassword());
		if (valor1.equals(new String(textField2.getPassword())) && !valor1.equals(null) && !valor1.equals("")) {
			return true;
		}
		textField1.requestFocus();
		textField1.setText("");
		textField2.setText("");
		Msg.avisoCampoDiferente(label1, label2);
		return false;
	}

	public static boolean validar(JTextField textField, JLabel label, boolean valido, boolean obrigatorio) {
		String valor = textField.getText();
		if (textField instanceof JFormattedTextField) {
			if (!obrigatorio && !valor.equals(null)) {
				return true;
			}
			if (obrigatorio && valor.equals(null)) {
				Msg.avisoCampoObrigatorio(label.getText());
				textField.requestFocus();
				return false;
			}
		}
		if (!obrigatorio && valor.equals("")) {
			return true;
		}
		if (obrigatorio && valor.equals("")) {
			Msg.avisoCampoObrigatorio(label.getText());
			textField.requestFocus();
			return false;
		}
		if (valido) {
			return true;
		}
		Msg.avisoCampoInvalido(label.getText());
		textField.requestFocus();
		textField.setText("");
		return false;
	}

	public static boolean validar(JTextField textField, JLabel label, Pattern p, boolean obrigatorio) {
		String valor = textField.getText().toUpperCase();
		if (textField instanceof JFormattedTextField) {
			if (!obrigatorio && !valor.equals(null)) {
				return true;
			}
			if (obrigatorio && valor.equals(null)) {
				Msg.avisoCampoObrigatorio(label.getText());
				textField.requestFocus();
				return false;
			}
			Matcher m = p.matcher(valor);
			if (!m.find()) {
				Msg.avisoCampoInvalido(label.getText());
				textField.requestFocus();
				textField.setText("");
				return false;
			}
			return true;
		}
		if (!obrigatorio && valor.equals("")) {
			return true;
		}
		if (obrigatorio && valor.equals("")) {
			Msg.avisoCampoObrigatorio(label.getText());
			textField.requestFocus();
			return false;
		}
		Matcher m = p.matcher(valor);
		if (!m.find()) {
			Msg.avisoCampoInvalido(label.getText());
			textField.requestFocus();
			textField.setText("");
			return false;
		}
		return true;
	}

	public static boolean validar(Pattern p, Object objeto) {
		String valor = null;
		if (objeto instanceof String) {
			valor = objeto.toString();
		} else if (objeto instanceof JTextField || objeto instanceof JFormattedTextField) {
			valor = ((JTextField) objeto).getText();
		}
		Matcher m = p.matcher(valor);
		if (!m.find()) {
			return false;
		}
		return true;
	}
}
