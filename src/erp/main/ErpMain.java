package erp.main;

import java.awt.Frame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import arquitetura.Jpa;
import arquitetura.gui.Msg;
import erp.usuario.UsuarioUtil;

public class ErpMain {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Thread thread = Thread.currentThread();
			thread.setName("athos");
			SplashScreen splash = new SplashScreen(5000);
			splash.toFront();
			MainFc mainFc = new MainFc();
			UsuarioUtil.criarUsuario();
			mainFc.setState(Frame.NORMAL);
			mainFc.setLocationRelativeTo(null);
			mainFc.setVisible(true);
			mainFc.setResizable(false);
			mainFc.toFront();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException exception) {
			exception.printStackTrace();
			Msg.erroLookAndFeel();
		} catch (Exception e) {
			e.printStackTrace();
			if (Jpa.getEntityManagerFactory().isOpen()) {
				Jpa.getEntityManagerFactory().close();
			}
			Msg.erroGeral();
		} finally {

		}
	}
}