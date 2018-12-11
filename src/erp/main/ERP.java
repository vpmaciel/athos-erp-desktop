package erp.main;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import erp.usuario.UsuarioUtil;

public class Athos {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFC mainFC = new MainFC();
				UsuarioUtil.criarUsuario();
				mainFC.setLocationRelativeTo(null);
				mainFC.setState(Frame.NORMAL);
				mainFC.setVisible(true);
				mainFC.setResizable(false);
				mainFC.toFront();
			}
		});
	}
}