package erp.login;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.MessageDigest;
import java.util.List;

import org.apache.log4j.Logger;

import arquitetura.Sis;
import arquitetura.data.Data;
import arquitetura.gui.Msg;
import erp.main.MainControl;
import erp.usuario.Usuario;
import erp.usuario.UsuarioFac;

public class LoginControl {

	public class ButtonEntrar implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			MainControl.getLoginFc().getLoginPc().validarGui();
			usuario = new Usuario();
			usuario.setNome(MainControl.getLoginFc().getLoginPc().getTextFieldNome().getText());
			usuario.setSenha(new String(MainControl.getLoginFc().getLoginPc().getTextFieldSenha().getPassword()));

			String original = usuario.getSenha();
			MessageDigest algorithm = null;
			byte messageDigest[] = null;
			try {
				algorithm = MessageDigest.getInstance("SHA-256");
				messageDigest = algorithm.digest(original.getBytes("UTF-8"));
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String senha = hexString.toString();
			usuario.setSenha(senha);

			if (UsuarioFac.isRegistroValido(usuario)) {
				List<Usuario> list = (List<Usuario>) UsuarioFac.pesquisarRegistro(usuario);
				Sis.setUsuario(list.get(0));
				MainControl.getLoginFc().setVisible(false);
				MainControl.getMainFc().toFront();
				logger.warn(Data.getDataHoraCompleta());

			} else {
				Msg.avisoUsuarioInvalido();
				MainControl.getLoginFc().toFront();
				++tentativas;

				if (tentativas >= LoginControl.MAXIMO_LOGIN_TENTATIVAS) {
					Msg.avisoFecharSistema();
					System.exit(0);
				}
			}
		}
	}

	public class ButtonEntrarTeclado extends KeyAdapter {

		@Override
		public void keyPressed(final KeyEvent evt) {
			final int key = evt.getKeyCode();
			if (key == KeyEvent.VK_ENTER) {
				evt.getComponent().requestFocus();
				MainControl.getLoginFc().getLoginPc().validarGui();
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			MainControl.getLoginFc().setVisible(false);
		}
	}

	final static Logger logger = Logger.getLogger(Usuario.class);

	private static final int MAXIMO_LOGIN_TENTATIVAS = 3;

	public static int getMaximoLoginTentativas() {
		return LoginControl.MAXIMO_LOGIN_TENTATIVAS;
	}

	private int tentativas = 0;
	private Usuario usuario;

}
