package arquitetura.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import arquitetura.gui.Msg;

public final class Entrada {

	public static boolean validar(JComboBox<?> box, JLabel label) {
		if (box.getSelectedItem() == null) {
			Msg.avisoCampoObrigatorio(label.getText());
			box.requestFocus();
			return false;
		}
		return true;
	}

	public static boolean validar(JPasswordField field1, JLabel label1, JPasswordField field2, JLabel label2) {
		String valor1 = new String(field1.getPassword());
		if (valor1.equals(new String(field2.getPassword())) && !valor1.equals(null) && !valor1.equals("")) {
			return true;
		}
		field1.requestFocus();
		field1.setText("");
		field2.setText("");
		Msg.avisoCampoDiferente(label1, label2);
		return false;
	}

	public static boolean validar(JTextField field, JLabel label, boolean valido, boolean obrigatorio) {
		String valor = field.getText();
		if (field instanceof JFormattedTextField) {
			if (!obrigatorio && !valor.equals(null)) {
				return true;
			}
			if (obrigatorio && valor.equals(null)) {
				Msg.avisoCampoObrigatorio(label.getText());
				field.requestFocus();
				return false;
			}
		}
		if (!obrigatorio && valor.equals("")) {
			return true;
		}
		if (obrigatorio && valor.equals("")) {
			Msg.avisoCampoObrigatorio(label.getText());
			field.requestFocus();
			return false;
		}
		if (valido) {
			return true;
		}
		Msg.avisoCampoInvalido(label.getText());
		field.requestFocus();
		field.setText("");
		return false;
	}

	public static boolean validar(JTextField field, String label, Pattern p, boolean obrigatorio) {
		String valor = field.getText().toUpperCase();
		if (field instanceof JFormattedTextField) {
			if (!obrigatorio && !valor.equals(null)) {
				return true;
			}
			if (obrigatorio && valor.equals(null)) {
				Msg.avisoCampoObrigatorio(label);
				field.requestFocus();
				return false;
			}
			Matcher m = p.matcher(valor);
			if (!m.find()) {
				Msg.avisoCampoInvalido(label);
				field.requestFocus();
				field.setText("");
				return false;
			}
			return true;
		}
		if (!obrigatorio && valor.equals("")) {
			return true;
		}
		if (obrigatorio && valor.equals("")) {
			Msg.avisoCampoObrigatorio(label);
			field.requestFocus();
			return false;
		}
		Matcher m = p.matcher(valor);
		if (!m.find()) {
			Msg.avisoCampoInvalido(label);
			field.requestFocus();
			field.setText("");
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
