package erp.usuario;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import erp.aop.gui.Msg;
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class UsuarioGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (usuario == null || usuario.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				UsuarioDaoFacade.deletarRegistro(usuario);
				getFrameCadastroUsuario().limparGui();
				usuario = new Usuario();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				getFrameCadastroUsuario().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroUsuario().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroUsuario().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			usuario = new Usuario();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Usuario> usuarios = new LinkedList<>();

			if (usuario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (usuarios.add(UsuarioDaoFacade.getRegistro(usuario))) {
					UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(usuarios);
					usuarioRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Usuario> usuarios = new LinkedList<>();

			try {
				usuarios = new LinkedList<>(UsuarioDaoFacade.pesquisarRegistro(usuario));
			} catch (Exception e) {
				System.out.println(e);
			}
			UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(usuarios);
			usuarioRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameUsuario extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroUsuario());
			} else {
				MainGerenteEventos.getFrameCadastroUsuario().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			getFrameCadastroUsuario().limparGui();
			getPanelCadastroUsuario().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			atualizarObjeto();
			getPanelPesquisaUsuario().pesquisarRegistroUsuario(usuario);
			MainGerenteEventos.mostrarFrame(getFramePesquisaUsuario());
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSairDoSistema();
				if (mensagem == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Salva implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {

				int mensagem = Msg.confirmarSalvarRegistro();
				if (mensagem != JOptionPane.YES_OPTION) {
					return;
				}

				if ((getPanelCadastroUsuario().getTextFieldNome().getText()) == null
						|| getPanelCadastroUsuario().getTextFieldNome().getText().length() == 0) {
					getPanelCadastroUsuario().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					UsuarioDaoFacade.salvarRegistro(usuario);
					usuario = new Usuario();
					MainGerenteEventos.getFrameCadastroUsuario().limparGui();
					getPanelCadastroUsuario().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (HeadlessException e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Usuario usuario;

	UsuarioGerenteEventos() {
	}

	public void atualizarGUI() {
		if (usuario == null) {
			return;
		}
		getPanelCadastroUsuario().getTextFieldNome().setText(usuario.getNome());
		getPanelCadastroUsuario().getTextFieldSenha().setText(usuario.getSenha());
	}

	public void atualizarObjeto() {

		usuario.setSenha(getPanelCadastroUsuario().getTextFieldSenha().getText());
		usuario.setNome(getPanelCadastroUsuario().getTextFieldNome().getText());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FrameCadastroUsuario getFrameCadastroUsuario() {
		return MainGerenteEventos.getFrameCadastroUsuario();
	}

	public PanelCadastroUsuario getPanelCadastroUsuario() {
		return MainGerenteEventos.getFrameCadastroUsuario().getPanelCadastroUsuario();
	}

	public FramePesquisaUsuario getFramePesquisaUsuario() {
		return MainGerenteEventos.getFramePesquisaUsuario();
	}

	public PanelPesquisaUsuario getPanelPesquisaUsuario() {
		return MainGerenteEventos.getFramePesquisaUsuario().getPanelPesquisaUsuario();
	}
}