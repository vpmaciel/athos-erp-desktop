package arquitetura.validacao.evento.teclado;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class ValidarInteiro extends KeyAdapter {

	@Override
	public void keyReleased(KeyEvent event) {
		String valor = null;
		try {
			valor = ((JTextField) event.getComponent()).getText();
			if (valor.equals("-") || valor.length() > 1 && valor.substring(0, 1).equals("-")) {
				return;
			}
			if (((JTextField) event.getComponent()).getText().equals("")) {
				valor = "";
				return;
			}

			valor = ((JTextField) event.getComponent()).getText();
		} catch (NumberFormatException e) {
			((JTextField) event.getComponent()).setText(valor);
			event.getComponent().requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
