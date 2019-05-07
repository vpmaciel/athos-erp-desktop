package erp.main;

import java.awt.EventQueue;
import java.awt.Frame;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import arquitetura.gui.Msg;
import erp.usuario.UsuarioUtil;

public class ERP {

	public static void main(String[] args) {

		try {
			String separador = System.getProperty("file.separator");
			String caminhoArquivo = "C:" + separador + "athos" + separador + "mensagens_de_log";
			File arquivo = new File(caminhoArquivo);
			arquivo.mkdir();
		} catch (Exception e) {
			Msg.erroCriarPasta();
		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException e) {
			Msg.erroLookAndFeel();
		}

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFc mainFc = new MainFc();
				UsuarioUtil.criarUsuario();
				mainFc.setState(Frame.NORMAL);
				mainFc.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
				mainFc.setLocationRelativeTo(null);
				mainFc.setVisible(true);
				mainFc.setResizable(false);
				mainFc.toFront();
			}
		});
	}
}