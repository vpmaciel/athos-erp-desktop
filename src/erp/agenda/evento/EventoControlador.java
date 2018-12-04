package erp.agenda.evento;

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
import erp.agenda.evento.tipoevento.TipoEvento;
import erp.main.MainControlador;

final class EventoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (evento == null || evento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EventoDaoFacade.deletarRegistro(evento);
				getFrameCadastroEvento().limparGUI();
				evento = new Evento();
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
				getFrameCadastroEvento().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroEvento().reiniciarGUI();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroEvento().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			evento = new Evento();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainControlador.mostrarFrame(MainControlador.getFrameMain());
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			if (evento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (eventos.add(EventoDaoFacade.getRegistro(evento))) {
					EventoRelatorio eventoRelatorio = new EventoRelatorio(eventos);
					eventoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			try {
				eventos = new LinkedList<>(EventoDaoFacade.pesquisarRegistro(evento));
			} catch (Exception e) {
				System.out.println(e);
			}
			EventoRelatorio eventoRelatorio = new EventoRelatorio(eventos);
			eventoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControlador.mostrarFrame(MainControlador.getFrameCadastroEmpresa());
			} else {
				MainControlador.getFrameCadastroEmpresa().reiniciarGUI();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			getFrameCadastroEvento().limparGUI();
			getFrameCadastroEvento().getPanelCadastroEvento().reiniciarGUI();
			getPanelCadastroEvento().getBoxTipoEvento().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			atualizarObjeto();
			getPanelPesquisaEvento().pesquisarRegistroAgenda(evento);

			MainControlador.mostrarFrame(MainControlador.getFramePesquisaAgendaEvento());
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
				String nome = getPanelCadastroEvento().getTextFieldDescricao().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroEvento().getTextFieldDescricao().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EventoDaoFacade.salvarRegistro(evento);
					evento = new Evento();
					getFrameCadastroEvento().limparGUI();
					getFrameCadastroEvento().getPanelCadastroEvento().reiniciarGUI();
					getPanelCadastroEvento().getBoxTipoEvento().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Evento evento;

	public void atualizarGui() {
		if (evento == null) {
			return;
		}

		getPanelCadastroEvento().getBoxTipoEvento().setSelectedItem(evento.getTipoEvento());
		getPanelCadastroEvento().getTextFieldDescricao().setText(evento.getDescricao());
		getPanelCadastroEvento().getTextFieldData().setText(evento.getData());
		getPanelCadastroEvento().getTextFieldHoraTermino().setText(evento.getHoraTermino());
		getPanelCadastroEvento().getTextFieldHoraInicio().setText(evento.getHoraInicio());
	}

	public void atualizarObjeto() {
		evento.setTipoEvento((TipoEvento) getPanelCadastroEvento().getBoxTipoEvento().getSelectedItem());
		evento.setDescricao(getPanelCadastroEvento().getTextFieldDescricao().getText());
		evento.setData(getPanelCadastroEvento().getTextFieldData().getText());
		evento.setHoraTermino(getPanelCadastroEvento().getTextFieldHoraTermino().getText());
		evento.setHoraInicio(getPanelCadastroEvento().getTextFieldHoraInicio().getText());
	}

	public Evento getEvento() {
		return evento;
	}

	public void setAgenda(Evento evento) {
		this.evento = evento;
	}

	public FCEvento getFrameCadastroEvento() {
		return MainControlador.getFrameCadastroAgendaEvento();
	}

	public PCEvento getPanelCadastroEvento() {
		return MainControlador.getFrameCadastroAgendaEvento().getPanelCadastroEvento();
	}

	public FPEvento getFramePesquisaEvento() {
		return MainControlador.getFramePesquisaAgendaEvento();
	}

	public PPEvento getPanelPesquisaEvento() {
		return MainControlador.getFramePesquisaAgendaEvento().getPanelPesquisaEvento();
	}
}
