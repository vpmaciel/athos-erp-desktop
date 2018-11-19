package erp.aop.validacao.evento.teclado;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class EventoTecladoValidar extends KeyAdapter {

	public static boolean validar(Component component, Pattern p) {
		Matcher m = p.matcher(((JTextField) component).getText());
		if (!m.find()) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
				((JTextField) component).requestFocus();
			}
			if (component instanceof JFormattedTextField) {
				((JFormattedTextField) component).setText("");
				((JFormattedTextField) component).requestFocus();
			}
			return false;
		}
		return true;
	}

	private String expressao = null;
	private boolean obrigatorio = false;

	private Pattern pattern = null;

	public EventoTecladoValidar(Pattern pattern, boolean obrigatorio) {
		this.setPattern(pattern);
		this.setObrigatorio(obrigatorio);
	}

	public EventoTecladoValidar(String expressao, boolean obrigatorio) {
		this.setExpressao(expressao);
		this.setObrigatorio(obrigatorio);
	}

	public String getExpressao() {
		return this.expressao;
	}

	public Pattern getPattern() {
		return this.pattern;
	}

	public boolean isObrigatorio() {
		return this.obrigatorio;
	}

	@Override
	public void keyReleased(KeyEvent event) {
		try {
			Component component = event.getComponent();
			if (this.expressao != null) {
				this.validar(component, this.expressao);
			} else {
				EventoTecladoValidar.validar(component, this.pattern);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public boolean validar(Component component, String validar) {
		String entrada = null;
		try {
			if (component instanceof JFormattedTextField) {
				entrada = ((JFormattedTextField) component).getText();
				if (!this.obrigatorio && entrada.replaceAll("\\D", "").equals("")) {
					return true;
				}
				if (entrada.matches(validar)) {
					return true;
				}
				((JFormattedTextField) component).setText("");
				((JFormattedTextField) component).requestFocus();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (component instanceof JTextField) {
				entrada = ((JTextField) component).getText();
				if (!this.obrigatorio && entrada.equals("")) {
					return true;
				}
				if (entrada.matches(validar)) {
					return true;
				}
				((JTextField) component).setText("");
				((JTextField) component).requestFocus();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
