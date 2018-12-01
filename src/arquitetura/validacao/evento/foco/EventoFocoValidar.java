package arquitetura.validacao.evento.foco;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class EventoFocoValidar implements FocusListener {

	private String expressao = null;
	private Pattern pattern = null;

	public EventoFocoValidar(Pattern pattern) {
		this.setPattern(pattern);
	}

	public EventoFocoValidar(String expressao) {
		this.setExpressao(expressao);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent event) {
		try {
			Component component = event.getComponent();
			if (this.expressao != null) {
				this.validar(component, this.expressao);
			} else {
				this.validar(component, this.pattern);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getExpressao() {
		return this.expressao;
	}

	public Pattern getPattern() {
		return this.pattern;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public boolean validar(Component component, Pattern p) {
		String entrada = ((JTextField) component).getText();
		entrada = ((JTextField) component).getText();
		Matcher m = p.matcher(entrada);
		try {
			if (component instanceof JFormattedTextField) {
				if (m.find()) {
					return true;
				}
				if (((JFormattedTextField) component).getText().replaceAll("\\D", "").equals("")) {
					((JFormattedTextField) component).requestFocus();
				}
				((JFormattedTextField) component).setText("");
				return false;
			}
			if (component instanceof JTextField) {
				if (m.find()) {
					return true;
				}
				if (!entrada.equals("")) {
					((JTextField) component).requestFocus();
				}
				((JTextField) component).setText("");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean validar(Component component, String validar) {
		String entrada = ((JTextField) component).getText();
		try {
			if (component instanceof JFormattedTextField) {
				entrada = ((JFormattedTextField) component).getText();
				if (entrada.matches(validar)) {
					return true;
				}
				if (!((JFormattedTextField) component).getText().replaceAll("\\D", "").equals("")) {
					((JFormattedTextField) component).requestFocus();
				}
				((JFormattedTextField) component).setText("");
				return false;
			}
			if (component instanceof JTextField) {
				if (entrada.matches(validar)) {
					return true;
				}
				if (!entrada.equals("")) {
					((JTextField) component).requestFocus();
				}
				((JTextField) component).setText("");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
