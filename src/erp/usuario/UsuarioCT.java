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

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class UsuarioCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (usuario == null || usuario.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				UsuarioFAC.deletarRegistro(usuario);
				getFrameCadastroUsuario().limparGUI();
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
			getFrameCadastroUsuario().reiniciarGUI();
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Usuario> usuarios = new LinkedList<>();

			if (usuario.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (usuarios.add(UsuarioFAC.getRegistro(usuario))) {
					UsuarioREL usuarioREL = new UsuarioREL(usuarios);
					usuarioREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Usuario> usuarios = new LinkedList<>();

			try {
				usuarios = new LinkedList<>(UsuarioFAC.pesquisarRegistro(usuario));
			} catch (Exception e) {
				System.out.println(e);
			}
			UsuarioREL usuarioREL = new UsuarioREL(usuarios);
			usuarioREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameUsuario extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(MainCT.getFrameCadastroUsuario());
			} else {
				MainCT.getFrameCadastroUsuario().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			getFrameCadastroUsuario().limparGUI();
			getPanelCadastroUsuario().getTextFieldNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			atualizarObjeto();
			getPanelPesquisaUsuario().pesquisarRegistroUsuario(usuario);
			MainCT.mostrarFrame(getFramePesquisaUsuario());
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
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					UsuarioFAC.salvarRegistro(usuario);
					usuario = new Usuario();
					MainCT.getFrameCadastroUsuario().limparGUI();
					getPanelCadastroUsuario().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (HeadlessException e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Usuario usuario;

	UsuarioCT() {
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

	public UsuarioFC getFrameCadastroUsuario() {
		return MainCT.getFrameCadastroUsuario();
	}

	public UsuarioPC getPanelCadastroUsuario() {
		return MainCT.getFrameCadastroUsuario().getPanelCadastroUsuario();
	}

	public UsuarioFP getFramePesquisaUsuario() {
		return MainCT.getFramePesquisaUsuario();
	}

	public UsuarioPP getPanelPesquisaUsuario() {
		return MainCT.getFramePesquisaUsuario().getPanelPesquisaUsuario();
	}
}