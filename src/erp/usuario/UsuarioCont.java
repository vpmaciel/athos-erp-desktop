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
import erp.main.MainCont;

final class UsuarioCont {
	
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
				UsuarioFac.deletarRegistro(usuario);
				getUsuarioFc().limparGui();
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
				getUsuarioFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getUsuarioFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getUsuarioFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				if (usuarios.add(UsuarioFac.getRegistro(usuario))) {
					UsuarioRel usuarioRel = new UsuarioRel(usuarios);
					usuarioRel.retornarRelatorio(true);
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
				usuarios = new LinkedList<>(UsuarioFac.pesquisarRegistro(usuario));
			} catch (Exception e) {
				System.out.println(e);
			}
			UsuarioRel usuarioRel = new UsuarioRel(usuarios);
			usuarioRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameUsuario extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(MainCont.getUsuarioFc());
			} else {
				MainCont.getUsuarioFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			getUsuarioFc().limparGui();
			getUsuarioPc().getTextFieldNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			usuario = new Usuario();
			atualizarObjeto();
			getUsuarioPp().pesquisarRegistroUsuario(usuario);
			MainCont.mostrarFrame(getUsuarioFp());
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

				if ((getUsuarioPc().getTextFieldNome().getText()) == null
						|| getUsuarioPc().getTextFieldNome().getText().length() == 0) {
					getUsuarioPc().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					UsuarioFac.salvarRegistro(usuario);
					usuario = new Usuario();
					MainCont.getUsuarioFc().limparGui();
					getUsuarioPc().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (HeadlessException e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Usuario usuario;

	UsuarioCont() {
	}

	public void atualizarGUI() {
		if (usuario == null) {
			return;
		}
		getUsuarioPc().getTextFieldNome().setText(usuario.getNome());
		getUsuarioPc().getTextFieldSenha().setText(usuario.getSenha());
	}

	public void atualizarObjeto() {

		usuario.setSenha(getUsuarioPc().getTextFieldSenha().getText());
		usuario.setNome(getUsuarioPc().getTextFieldNome().getText());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioFc getUsuarioFc() {
		return MainCont.getUsuarioFc();
	}

	public UsuarioPc getUsuarioPc() {
		return MainCont.getUsuarioFc().getUsuarioPc();
	}

	public UsuarioFp getUsuarioFp() {
		return MainCont.getUsuarioFp();
	}

	public UsuarioPp getUsuarioPp() {
		return MainCont.getUsuarioFp().getUsuarioPp();
	}
}