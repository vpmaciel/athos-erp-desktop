package arquitetura.validacao.evento.teclado;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class ValidarInteiroPositivo extends KeyAdapter {

	String valor = "";

	@Override
	public void keyReleased(KeyEvent event) {
		try {
			char c = event.getKeyChar();
			if (c == '-') {
				((JTextField) event.getComponent()).setText(this.valor);
			}
			if (((JTextField) event.getComponent()).getText().equals("")) {
				this.valor = "";
				return;
			}
			@SuppressWarnings("unused")
			Integer integer = null;
			this.valor = ((JTextField) event.getComponent()).getText();
		} catch (NumberFormatException e) {
			((JTextField) event.getComponent()).setText(this.valor);
			event.getComponent().requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
