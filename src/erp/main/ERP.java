package erp.main;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import arquitetura.gui.Msg;
import erp.usuario.UsuarioUtil;

public class ERP {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException exception) {
			exception.printStackTrace();
			Msg.erroLookAndFeel();
		}

		// Mostra uma imagem com o título da aplicação
		SplashScreen splash = new SplashScreen(3000);
		splash.toFront();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFc mainFc = new MainFc();
				UsuarioUtil.criarUsuario();
				mainFc.setState(Frame.NORMAL);
				mainFc.setLocationRelativeTo(null);
				mainFc.setVisible(true);
				mainFc.setResizable(false);
				mainFc.toFront();
			}
		});
	}
}