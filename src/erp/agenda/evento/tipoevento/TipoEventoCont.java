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
import erp.main.MainFc;

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
			if (tipoEvento == null || tipoEvento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TipoEventoFac.deletarRegistro(tipoEvento);
				getTipoEventoFc().limparGui();
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
			tipoEvento = new TipoEvento();
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

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			if (tipoEvento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (tipoEventos.add(TipoEventoFac.getRegistro(tipoEvento))) {
				TipoEventoRel tipoEventoRel = new TipoEventoRel(tipoEventos);
				tipoEventoRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			MainCont.getAgendaTipoEventoFc().limparGui();
			getTipoEventoPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTipoEventoPp().pesquisarRegistro(tipoEvento);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getTipoEventoFp());
				getTipoEventoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TipoEvento> tipoEventos = new LinkedList<>();

			try {
				tipoEventos = new LinkedList<>(TipoEventoFac.pesquisarRegistro(new TipoEvento()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TipoEventoRel tipoEventoRel = new TipoEventoRel(tipoEventos);
			tipoEventoRel.retornarRelatorio(true);

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

				String nome = getTipoEventoPc().getGuiNome().getText();

				if (nome == null || nome.length() == 0) {
					getTipoEventoPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}

				TipoEvento tipoEventoPesquisa = new TipoEvento();
				tipoEventoPesquisa.setNome(getTipoEventoPc().getGuiNome().getText());
				TipoEvento tipoEventoPesquisaRetornado = TipoEventoFac.consultarRegistro(tipoEventoPesquisa);

				if (tipoEvento.getId() == null && tipoEventoPesquisa.getNome() != null
						&& tipoEventoPesquisaRetornado.getNome() != null) {
					if (tipoEventoPesquisa.getNome().equals(tipoEventoPesquisaRetornado.getNome())) {
						Msg.avisoCampoDuplicado("NOME", tipoEventoPesquisa.getNome());
						getTipoEventoPc().getGuiNome().requestFocus();
						return;
					}
				}

				if (tipoEvento.getId() != null && tipoEventoPesquisa.getNome() != null
						&& tipoEventoPesquisaRetornado.getNome() != null) {
					if (!tipoEvento.getNome().equals(tipoEventoPesquisa.getNome())) {
						if (tipoEventoPesquisa.getNome().equals(tipoEventoPesquisaRetornado.getNome())) {
							Msg.avisoCampoDuplicado("NOME", tipoEventoPesquisa.getNome());
							getTipoEventoPc().getGuiNome().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TipoEventoFac.salvarRegistro(tipoEvento);
					tipoEvento = new TipoEvento();
					MainCont.getAgendaTipoEventoFc().limparGui();
					getTipoEventoPc().getGuiNome().requestFocus();
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
		getTipoEventoPc().getGuiNome().setText(tipoEvento.getNome());
	}

	public void atualizarObjeto() {
		tipoEvento.setNome(getTipoEventoPc().getGuiNome().getText());

		if (getTipoEventoPc().getGuiNome().getText().length() == 0) {
			tipoEvento.setNome(null);
		}
	}

	public TipoEvento getEvento() {
		return tipoEvento;
	}

	public TipoEventoFc getTipoEventoFc() {
		return MainCont.getAgendaTipoEventoFc();
	}

	public TipoEventoFp getTipoEventoFp() {
		return MainCont.getAgendaTipoEventoFp();
	}

	public TipoEventoPc getTipoEventoPc() {
		return MainCont.getAgendaTipoEventoFc().getTipoEventoPc();
	}

	public TipoEventoPp getTipoEventoPp() {
		return MainCont.getAgendaTipoEventoFp().getTipoEventoPp();
	}

	public void setTipoEvento(TipoEvento TipoEvento) {
		this.tipoEvento = TipoEvento;
	}
}
