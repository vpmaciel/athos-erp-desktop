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
import erp.main.MainCont;

final class EventoCont {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getEventoPc().getLabelTipoEvento()) {
				MainCont.mostrarFrame(MainCont.getAgendaTipoEventoFc());
			}
			//MainCont.getEmpresaFc().reiniciarGui();
		}
	}
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
			MainCont.mostrarFrame(MainCont.getMainFc());
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
					EventoRel eventoRelatorio = new EventoRel(eventos);
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
				eventos = new LinkedList<>(EventoFac.pesquisarRegistro(evento));
			} catch (Exception e) {
				System.out.println(e);
			}
			EventoRel eventoRelatorio = new EventoRel(eventos);
			eventoRelatorio.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			getEventoFc().limparGui();
			getEventoFc().getEventoPc().reiniciarGui();
			getEventoPc().getTipoEventoGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			atualizarObjeto();
			getEventoPp().pesquisarRegistroAgenda(evento);

			MainCont.mostrarFrame(MainCont.getAgendaEventoFp());
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
				String nome = getEventoPc().getDescricaoGUI().getText();
				if (nome == null || nome.length() == 0) {
					getEventoPc().getDescricaoGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EventoFac.salvarRegistro(evento);
					evento = new Evento();
					getEventoFc().limparGui();
					getEventoFc().getEventoPc().reiniciarGui();
					getEventoPc().getTipoEventoGUI().requestFocus();
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

		getEventoPc().getTipoEventoGUI().setSelectedItem(evento.getTipoEvento());
		getEventoPc().getDescricaoGUI().setText(evento.getDescricao());
		getEventoPc().getDataGUI().setText(evento.getData());
		getEventoPc().getHoraTerminoGUI().setText(evento.getHoraTermino());
		getEventoPc().getHoraInicioGUI().setText(evento.getHoraInicio());
	}

	public void atualizarObjeto() {
		evento.setTipoEvento((TipoEvento) getEventoPc().getTipoEventoGUI().getSelectedItem());
		evento.setDescricao(getEventoPc().getDescricaoGUI().getText());
		evento.setData(getEventoPc().getDataGUI().getText());
		evento.setHoraTermino(getEventoPc().getHoraTerminoGUI().getText());
		evento.setHoraInicio(getEventoPc().getHoraInicioGUI().getText());
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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
}
