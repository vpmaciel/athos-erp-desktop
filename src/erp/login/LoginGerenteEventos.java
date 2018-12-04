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
import erp.main.MainControlador;
import erp.usuario.Usuario;
import erp.usuario.UsuarioDaoFacade;

public class LoginGerenteEventos {

	private PLogin pLogin = MainControlador.getFrameLogin().getPanelLogin();

	public class ButtonCancelarHandle implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			pLogin.limparGUI();
		}
	}

	public class ButtonEntrarHandle implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent actionEvent) {
			pLogin.validarCamposCadastro();
			usuario = new Usuario();
			usuario.setNome(pLogin.getTextFieldNome().getText());
			usuario.setSenha(new String(pLogin.getTextFieldSenha().getPassword()));

			if (UsuarioDaoFacade.isRegistroValido(usuario)) {
				List<Usuario> list = (List<Usuario>) UsuarioDaoFacade.pesquisarRegistro(usuario);

				AOP.setUsuario(list.get(0));
				MainControlador.getFrameLogin().setVisible(false);

			} else {
				Msg.avisoUsuarioInvalido();
				++tentativas;

				if (tentativas >= LoginGerenteEventos.MAXIMO_LOGIN_TENTATIVAS) {
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
				pLogin.validarCamposCadastro();
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			MainControlador.getFrameLogin().setVisible(false);
		}
	}

	private static final int MAXIMO_LOGIN_TENTATIVAS = 3;

	public static int getMaximoLoginTentativas() {
		return LoginGerenteEventos.MAXIMO_LOGIN_TENTATIVAS;
	}

	private int tentativas = 0;
	private Usuario usuario;

}
