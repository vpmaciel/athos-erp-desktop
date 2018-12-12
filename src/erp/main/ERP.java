package erp.main;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import erp.usuario.UsuarioUtil;

public class ERP {

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
				MainFc mainFc = new MainFc();
				UsuarioUtil.criarUsuario();
				mainFc.setLocationRelativeTo(null);
				mainFc.setState(Frame.NORMAL);
				mainFc.setVisible(true);
				mainFc.setResizable(false);
				mainFc.toFront();
			}
		});
	}
}