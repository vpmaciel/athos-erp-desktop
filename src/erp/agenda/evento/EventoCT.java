package erp.agenda.evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.agenda.evento.tipoevento.TipoEvento;
import erp.main.MainCT;

final class EventoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (evento == null || evento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EventoFAC.deletarRegistro(evento);
				getEventoFC().limparGUI();
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
				getEventoFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getEventoFC().reiniciarGUI();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getEventoFC().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			evento = new Evento();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCT.mostrarFrame(MainCT.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			if (evento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (eventos.add(EventoFAC.getRegistro(evento))) {
					EventoREL eventoRelatorio = new EventoREL(eventos);
					eventoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			try {
				eventos = new LinkedList<>(EventoFAC.pesquisarRegistro(evento));
			} catch (Exception e) {
				System.out.println(e);
			}
			EventoREL eventoRelatorio = new EventoREL(eventos);
			eventoRelatorio.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			getEventoFC().limparGUI();
			getEventoFC().getEventoPC().reiniciarGUI();
			getEventoPC().getTipoEventoGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			atualizarObjeto();
			getEventoPP().pesquisarRegistroAgenda(evento);

			MainCT.mostrarFrame(MainCT.getAgendaEventoFP());
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
				String nome = getEventoPC().getDescricaoGUI().getText();
				if (nome == null || nome.length() == 0) {
					getEventoPC().getDescricaoGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EventoFAC.salvarRegistro(evento);
					evento = new Evento();
					getEventoFC().limparGUI();
					getEventoFC().getEventoPC().reiniciarGUI();
					getEventoPC().getTipoEventoGUI().requestFocus();
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

		getEventoPC().getTipoEventoGUI().setSelectedItem(evento.getTipoEvento());
		getEventoPC().getDescricaoGUI().setText(evento.getDescricao());
		getEventoPC().getDataGUI().setText(evento.getData());
		getEventoPC().getHoraTerminoGUI().setText(evento.getHoraTermino());
		getEventoPC().getHoraInicioGUI().setText(evento.getHoraInicio());
	}

	public void atualizarObjeto() {
		evento.setTipoEvento((TipoEvento) getEventoPC().getTipoEventoGUI().getSelectedItem());
		evento.setDescricao(getEventoPC().getDescricaoGUI().getText());
		evento.setData(getEventoPC().getDataGUI().getText());
		evento.setHoraTermino(getEventoPC().getHoraTerminoGUI().getText());
		evento.setHoraInicio(getEventoPC().getHoraInicioGUI().getText());
	}

	public Evento getEvento() {
		return evento;
	}

	public void setAgenda(Evento evento) {
		this.evento = evento;
	}

	public EventoFC getEventoFC() {
		return MainCT.getAgendaEventoFC();
	}

	public EventoPC getEventoPC() {
		return MainCT.getAgendaEventoFC().getEventoPC();
	}

	public EventoFP getEventoFP() {
		return MainCT.getAgendaEventoFP();
	}

	public EventoPP getEventoPP() {
		return MainCT.getAgendaEventoFP().getEventoPP();
	}
}
