package erp.agenda.evento.tipoevento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainControlador;

final class TipoEventoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (tipoEvento == null || tipoEvento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TipoEventoDaoFacade.deletarRegistro(tipoEvento);
				getFrameCadastroTipoEvento().limparGUI();
				tipoEvento = new TipoEvento();
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
				getFrameCadastroTipoEvento().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroTipoEvento().reiniciarGUI();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroTipoEvento().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			tipoEvento = new TipoEvento();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			if (tipoEvento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (tipoEventos.add(TipoEventoDaoFacade.getRegistro(tipoEvento))) {
					TipoEventoRelatorio tipoEventoRelatorio = new TipoEventoRelatorio(tipoEventos);
					tipoEventoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			try {
				tipoEventos = new LinkedList<>(TipoEventoDaoFacade.pesquisarRegistro(tipoEvento));
			} catch (Exception e) {
				System.out.println(e);
			}
			TipoEventoRelatorio tipoEventoRelatorio = new TipoEventoRelatorio(tipoEventos);
			tipoEventoRelatorio.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			MainControlador.getFrameCadastroAgendaTipoEvento().limparGUI();
			getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			atualizarObjeto();
			getPanelPesquisaTipoEvento().pesquisarRegistroAgenda(tipoEvento);
			MainControlador.mostrarFrame(MainControlador.getFramePesquisaAgendaTipoEvento());
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
				String nome = getPanelCadastroTipoEvento().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TipoEventoDaoFacade.salvarRegistro(tipoEvento);
					tipoEvento = new TipoEvento();
					MainControlador.getFrameCadastroAgendaTipoEvento().limparGUI();
					getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private TipoEvento tipoEvento;

	public void atualizarGui() {
		if (tipoEvento == null) {
			return;
		}
		getPanelCadastroTipoEvento().getTextFieldNome().setText(tipoEvento.getNome());
	}

	public void atualizarObjeto() {
		tipoEvento.setNome(getPanelCadastroTipoEvento().getTextFieldNome().getText());
	}

	public TipoEvento getEvento() {
		return tipoEvento;
	}

	public void setAgenda(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public FCTipoEvento getFrameCadastroTipoEvento() {
		return MainControlador.getFrameCadastroAgendaTipoEvento();
	}

	public PCTipoEvento getPanelCadastroTipoEvento() {
		return MainControlador.getFrameCadastroAgendaTipoEvento().getPanelCadastroTipoEvento();
	}

	public FPTipoEvento getFramePesquisaTipoEvento() {
		return MainControlador.getFramePesquisaAgendaTipoEvento();
	}

	public PPTipoEvento getPanelPesquisaTipoEvento() {
		return MainControlador.getFramePesquisaAgendaTipoEvento().getPanelPesquisaTipoEvento();
	}
}
