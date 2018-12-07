package erp.centrocusto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class CentroCustoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (centroCusto == null || centroCusto.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CentroCustoFAC.deletarRegistro(centroCusto);
				getCentroCustoFC().limparGUI();
				centroCusto = new CentroCusto();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCentroCustoFC().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCentroCustoFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCentroCustoFC().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			centroCusto = new CentroCusto();
			getCentroCustoPC().getNomeGUI().requestFocus();
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

			List<CentroCusto> centroCustos = new LinkedList<>();

			try {
				centroCustos = new LinkedList<>(CentroCustoFAC.pesquisarRegistro(new CentroCusto()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CentroCustoREL centroCustoREL = new CentroCustoREL(centroCustos);
			centroCustoREL.retornarRelatorio(true);
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<CentroCusto> centroCustos = new LinkedList<>();

			if (centroCusto.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (centroCustos.add(CentroCustoFAC.getRegistro(centroCusto))) {
				CentroCustoREL centroCustoREL = new CentroCustoREL(centroCustos);
				centroCustoREL.retornarRelatorio(true);
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			centroCusto = new CentroCusto();
			getCentroCustoFC().limparGUI();
			getCentroCustoPC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCentroCustoPP().pesquisarRegistroCentroCusto(centroCusto);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCT.mostrarFrame(getCentroCustoFP());
			}
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
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

				if ((getCentroCustoPC().getNomeGUI().getText()) == null
						|| getCentroCustoPC().getNomeGUI().getText().length() == 0) {
					getCentroCustoPC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CentroCustoFAC.salvarRegistro(centroCusto);
					centroCusto = new CentroCusto();
					getCentroCustoFC().limparGUI();
					getCentroCustoPC().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private CentroCusto centroCusto;

	public CentroCustoCT() {

	}

	public void atualizarGui() {
		if (centroCusto == null) {
			return;
		}
		getCentroCustoPC().getNomeGUI().setText(centroCusto.getNome());
	}

	public void atualizarObjeto() {
		centroCusto.setNome(getCentroCustoPC().getNomeGUI().getText());
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public CentroCustoFC getCentroCustoFC() {
		return MainCT.getCentroCustoFC();
	}

	public CentroCustoPC getCentroCustoPC() {
		return MainCT.getCentroCustoFC().getCentroCustoPC();
	}

	public CentroCustoFP getCentroCustoFP() {
		return MainCT.getCentroCustoFP();
	}

	public CentroCustoPP getCentroCustoPP() {
		return MainCT.getCentroCustoFP().getCentroCustoPP();
	}
}
