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
import erp.main.MainCont;

final class EventoCont {

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
				EventoFac.deletarRegistro(evento);
				getEventoFc().limparGui();
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
				getEventoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getEventoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getEventoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			evento = new Evento();
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
			List<Evento> eventos = new LinkedList<>();

			if (evento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (eventos.add(EventoFac.getRegistro(evento))) {
					EventoRel eventoRel = new EventoRel(eventos);
					eventoRel.retornarRelatorio(true);
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
				eventos = new LinkedList<>(EventoFac.pesquisarRegistro(evento));
			} catch (Exception e) {
				System.out.println(e);
			}
			EventoRel eventoRel = new EventoRel(eventos);
			eventoRel.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			getEventoFc().limparGui();
			getEventoPc().getDescricaoGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			atualizarObjeto();
			getEventoPp().pesquisarRegistroEvento(evento);

			MainCont.mostrarFrame(getEventoFp());
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
				String placa = getEventoPc().getDescricaoGui().getText();
				if (placa == null || placa.length() == 0) {
					getEventoPc().getDescricaoGui().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EventoFac.salvarRegistro(evento);
					evento = new Evento();
					MainCont.getAgendaEventoFc().limparGui();
					getEventoPc().getDescricaoGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private static Evento evento;

	public void atualizarGui() {
		if (evento == null) {
			return;
		}
		getEventoPc().getTipoEventoGui().setSelectedItem(evento.getTipoEvento());
		getEventoPc().getDataGui().setText(evento.getData());
		getEventoPc().getDescricaoGui().setText(evento.getDescricao());
		getEventoPc().getHoraInicioGui().setText(evento.getHoraInicio());
		getEventoPc().getHoraTerminoGui().setText(evento.getHoraTermino());
	}

	public void atualizarObjeto() {
		evento.setDescricao(getEventoPc().getDescricaoGui().getText());
		evento.setHoraTermino(getEventoPc().getHoraTerminoGui().getText());
		evento.setHoraInicio(getEventoPc().getHoraInicioGui().getText());
		evento.setData(getEventoPc().getDataGui().getText());
		evento.setTipoEvento((TipoEvento) getEventoPc().getTipoEventoGui().getSelectedItem());
	}

	public EventoFc getEventoFc() {
		return MainCont.getAgendaEventoFc();
	}

	public EventoPc getEventoPc() {
		return MainCont.getAgendaEventoFc().getEventoPc();
	}

	public EventoFp getEventoFp() {
		return MainCont.getAgendaEventoFp();
	}

	public EventoPp getEventoPp() {
		return MainCont.getAgendaEventoFp().getEventoPp();
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		EventoCont.evento = evento;
	}
}
