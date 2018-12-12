package erp.centrocusto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;

final class CentroCustoCont {

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
				CentroCustoFac.deletarRegistro(centroCusto);
				getCentroCustoFc().limparGUI();
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
			getCentroCustoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCentroCustoFc().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCentroCustoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			centroCusto = new CentroCusto();
			getCentroCustoPc().getNomeGUI().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<CentroCusto> centroCustos = new LinkedList<>();

			try {
				centroCustos = new LinkedList<>(CentroCustoFac.pesquisarRegistro(new CentroCusto()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CentroCustoRel centroCustoRel = new CentroCustoRel(centroCustos);
			centroCustoRel.retornarRelatorio(true);
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
			if (centroCustos.add(CentroCustoFac.getRegistro(centroCusto))) {
				CentroCustoRel centroCustoRel = new CentroCustoRel(centroCustos);
				centroCustoRel.retornarRelatorio(true);
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			centroCusto = new CentroCusto();
			getCentroCustoFc().limparGUI();
			getCentroCustoPc().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCentroCustoPp().pesquisarRegistroCentroCusto(centroCusto);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCentroCustoFp());
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

				if ((getCentroCustoPc().getNomeGUI().getText()) == null
						|| getCentroCustoPc().getNomeGUI().getText().length() == 0) {
					getCentroCustoPc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CentroCustoFac.salvarRegistro(centroCusto);
					centroCusto = new CentroCusto();
					getCentroCustoFc().limparGUI();
					getCentroCustoPc().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private CentroCusto centroCusto;

	public CentroCustoCont() {

	}

	public void atualizarGui() {
		if (centroCusto == null) {
			return;
		}
		getCentroCustoPc().getNomeGUI().setText(centroCusto.getNome());
	}

	public void atualizarObjeto() {
		centroCusto.setNome(getCentroCustoPc().getNomeGUI().getText());
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public CentroCustoFc getCentroCustoFc() {
		return MainCont.getCentroCustoFc();
	}

	public CentroCustoPc getCentroCustoPc() {
		return MainCont.getCentroCustoFc().getCentroCustoPc();
	}

	public CentroCustoFp getCentroCustoFp() {
		return MainCont.getCentroCustoFp();
	}

	public CentroCustoPp getCentroCustoPp() {
		return MainCont.getCentroCustoFp().getCentroCustoPp();
	}
}
