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
import erp.main.MainCT;
import erp.usuario.Usuario;
import erp.usuario.UsuarioFAC;

public class LoginCT {

	private LoginPC loginPC = MainCT.getFrameLogin().getPanelLogin();

	public class ButtonCancelarHandle implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			loginPC.limparGUI();
		}
	}

	public class ButtonEntrarHandle implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			loginPC.validarCamposCadastro();
			usuario = new Usuario();
			usuario.setNome(loginPC.getTextFieldNome().getText());
			usuario.setSenha(new String(loginPC.getTextFieldSenha().getPassword()));

			if (UsuarioFAC.isRegistroValido(usuario)) {
				List<Usuario> list = (List<Usuario>) UsuarioFAC.pesquisarRegistro(usuario);

				AOP.setUsuario(list.get(0));
				MainCT.getFrameLogin().setVisible(false);

			} else {
				Msg.avisoUsuarioInvalido();
				++tentativas;

				if (tentativas >= LoginCT.MAXIMO_LOGIN_TENTATIVAS) {
					Msg.avisoFecharSistema();
					System.exit(0);
				}
			}
		}
	}

	public class ButtonEntrarTecladoHandle extends KeyAdapter {

		@Override
		public void keyPressed(final KeyEvent evt) {
			final int key = evt.getKeyCode();
			if (key == KeyEvent.VK_ENTER) {
				evt.getComponent().requestFocus();
				loginPC.validarCamposCadastro();
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			MainCT.getFrameLogin().setVisible(false);
		}
	}

	private static final int MAXIMO_LOGIN_TENTATIVAS = 3;

	public static int getMaximoLoginTentativas() {
		return LoginCT.MAXIMO_LOGIN_TENTATIVAS;
	}

	private int tentativas = 0;
	private Usuario usuario;

}
