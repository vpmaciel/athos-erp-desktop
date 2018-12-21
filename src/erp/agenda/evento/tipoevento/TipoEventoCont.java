package erp.agenda.evento.tipoevento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;

final class TipoEventoCont {
	
	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (TipoEvento == null || TipoEvento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TipoEventoFac.deletarRegistro(TipoEvento);
				getTipoEventoFc().limparGui();
				TipoEvento = new TipoEvento();
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
				getTipoEventoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTipoEventoFc().reiniciarGui();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTipoEventoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			TipoEvento = new TipoEvento();
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

			List<TipoEvento> TipoEventos = new LinkedList<>();

			try {
				TipoEventos = new LinkedList<>(TipoEventoFac.pesquisarRegistro(new TipoEvento()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TipoEventoRel TipoEventoRel = new TipoEventoRel(TipoEventos);
			TipoEventoRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> TipoEventos = new LinkedList<>();

			if (TipoEvento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (TipoEventos.add(TipoEventoFac.getRegistro(TipoEvento))) {
				TipoEventoRel TipoEventoRel = new TipoEventoRel(TipoEventos);
				TipoEventoRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			TipoEvento = new TipoEvento();
			MainCont.getAgendaTipoEventoFc().limparGui();
			getTipoEventoPc().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			TipoEvento = new TipoEvento();
			atualizarObjeto();
			getTipoEventoPp().pesquisarRegistroAgenda(TipoEvento);
			MainCont.mostrarFrame(MainCont.getAgendaTipoEventoFp());
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
				String nome = getTipoEventoPc().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getTipoEventoPc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TipoEventoFac.salvarRegistro(TipoEvento);
					TipoEvento = new TipoEvento();
					MainCont.getAgendaTipoEventoFc().limparGui();
					getTipoEventoPc().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private TipoEvento TipoEvento;

	public void atualizarGui() {
		if (TipoEvento == null) {
			return;
		}
		getTipoEventoPc().getNomeGUI().setText(TipoEvento.getNome());
	}

	public void atualizarObjeto() {
		TipoEvento.setNome(getTipoEventoPc().getNomeGUI().getText());
	}

	public TipoEvento getEvento() {
		return TipoEvento;
	}

	public void setTipoEvento(TipoEvento TipoEvento) {
		this.TipoEvento = TipoEvento;
	}

	public TipoEventoFc getTipoEventoFc() {
		return MainCont.getAgendaTipoEventoFc();
	}

	public TipoEventoPc getTipoEventoPc() {
		return MainCont.getAgendaTipoEventoFc().getTipoEventoPc();
	}

	public TipoEventoFp getTipoEventoFp() {
		return MainCont.getAgendaTipoEventoFp();
	}

	public TipoEventoPp getTipoEventoPp() {
		return MainCont.getAgendaTipoEventoFp().getTipoEventoPp();
	}
}
