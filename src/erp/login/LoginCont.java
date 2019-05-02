package erp.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import arquitetura.AOP;
import arquitetura.gui.Msg;
import erp.main.MainCont;
import erp.usuario.Usuario;
import erp.usuario.UsuarioFac;

public class LoginCont {

	public class ButtonEntrar implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			MainCont.getLoginFc().getLoginPc().validarGui();
			usuario = new Usuario();
			usuario.setNome(MainCont.getLoginFc().getLoginPc().getTextFieldNome().getText());
			usuario.setSenha(new String(MainCont.getLoginFc().getLoginPc().getTextFieldSenha().getPassword()));

			if (UsuarioFac.isRegistroValido(usuario)) {
				List<Usuario> list = (List<Usuario>) UsuarioFac.pesquisarRegistro(usuario);
				AOP.setUsuario(list.get(0));
				MainCont.getLoginFc().setVisible(false);

			} else {
				Msg.avisoUsuarioInvalido();
				++tentativas;

				if (tentativas >= LoginCont.MAXIMO_LOGIN_TENTATIVAS) {
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
				MainCont.getLoginFc().getLoginPc().validarGui();
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			MainCont.getLoginFc().setVisible(false);
		}
	}

	private static final int MAXIMO_LOGIN_TENTATIVAS = 3;

	public static int getMaximoLoginTentativas() {
		return LoginCont.MAXIMO_LOGIN_TENTATIVAS;
	}

	private int tentativas = 0;
	private Usuario usuario;

}
