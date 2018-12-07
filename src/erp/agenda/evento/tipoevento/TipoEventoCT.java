package erp.agenda.evento.tipoevento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class TipoEventoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (tipoEvento == null || tipoEvento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TipoEventoFAC.deletarRegistro(tipoEvento);
				getTipoEventoFC().limparGUI();
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
				getTipoEventoFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTipoEventoFC().reiniciarGUI();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTipoEventoFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			if (tipoEvento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (tipoEventos.add(TipoEventoFAC.getRegistro(tipoEvento))) {
					TipoEventoREL tipoEventoREL = new TipoEventoREL(tipoEventos);
					tipoEventoREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			try {
				tipoEventos = new LinkedList<>(TipoEventoFAC.pesquisarRegistro(tipoEvento));
			} catch (Exception e) {
				System.out.println(e);
			}
			TipoEventoREL tipoEventoREL = new TipoEventoREL(tipoEventos);
			tipoEventoREL.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			MainCT.getAgendaTipoEventoPC().limparGUI();
			getTipoEventoPC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			atualizarObjeto();
			getTipoEventoPP().pesquisarRegistroAgenda(tipoEvento);
			MainCT.mostrarFrame(MainCT.getAgendaTipoEventoPP());
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
				String nome = getTipoEventoPC().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getTipoEventoPC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TipoEventoFAC.salvarRegistro(tipoEvento);
					tipoEvento = new TipoEvento();
					MainCT.getAgendaTipoEventoPC().limparGUI();
					getTipoEventoPC().getNomeGUI().requestFocus();
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
		getTipoEventoPC().getNomeGUI().setText(tipoEvento.getNome());
	}

	public void atualizarObjeto() {
		tipoEvento.setNome(getTipoEventoPC().getNomeGUI().getText());
	}

	public TipoEvento getEvento() {
		return tipoEvento;
	}

	public void setAgenda(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public TipoEventoFC getTipoEventoFC() {
		return MainCT.getAgendaTipoEventoPC();
	}

	public TipoEventoPC getTipoEventoPC() {
		return MainCT.getAgendaTipoEventoPC().getTipoEventoPC();
	}

	public TipoEventoFP getTipoEventoFP() {
		return MainCT.getAgendaTipoEventoPP();
	}

	public TipoEventoPP getTipoEventoPP() {
		return MainCT.getAgendaTipoEventoPP().getTipoEventoPP();
	}
}
