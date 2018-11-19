package erp.main;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import erp.usuario.UsuarioUtil;

public class Main {

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
				FrameMain frameMain = new FrameMain();
				UsuarioUtil.criarUsuario();
				frameMain.setLocationRelativeTo(null);
				frameMain.setState(Frame.NORMAL);
				frameMain.setVisible(true);
				frameMain.setResizable(false);
				frameMain.toFront();
			}
		});
	}
}