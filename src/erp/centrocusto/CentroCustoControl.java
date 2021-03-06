package erp.centrocusto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainControl;

final class CentroCustoControl {

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
				getCentroCustoFc().limparGui();
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
			getCentroCustoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCentroCustoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			centroCusto = new CentroCusto();
			getCentroCustoPc().getGuiNome().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainControl.mostrarFrame(MainControl.getMainFc());
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
			getCentroCustoFc().limparGui();
			getCentroCustoPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCentroCustoPp().pesquisarRegistro(centroCusto);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getCentroCustoFp());
				getCentroCustoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCentroCustoPp().pesquisarRegistro(new CentroCusto());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getCentroCustoFp());
				getCentroCustoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<CentroCusto> centroCustos = new LinkedList<>();

			try {
				centroCustos = new LinkedList<>(CentroCustoFac.pesquisarRegistro(new CentroCusto()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			CentroCustoRel centroCustoRel = new CentroCustoRel(centroCustos);
			centroCustoRel.retornarRelatorio(true);

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
				if ((getCentroCustoPc().getGuiNome().getText()) == null
						|| getCentroCustoPc().getGuiNome().getText().length() == 0) {
					getCentroCustoPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CentroCustoFac.salvarRegistro(centroCusto);
					centroCusto = new CentroCusto();
					getCentroCustoFc().limparGui();
					getCentroCustoPc().getGuiNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_CENTRO_CUSTO_NOME")) {
						Msg.avisoCampoDuplicado("NOME");
						getCentroCustoPc().getGuiNome().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private CentroCusto centroCusto;

	public CentroCustoControl() {

	}

	public void atualizarGui() {
		if (centroCusto == null) {
			return;
		}
		getCentroCustoPc().getGuiNome().setText(centroCusto.getNome());
	}

	public void atualizarObjeto() {
		centroCusto.setNome(getCentroCustoPc().getGuiNome().getText());

		if (getCentroCustoPc().getGuiNome().getText().length() == 0) {
			centroCusto.setNome(null);
		}
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public CentroCustoFc getCentroCustoFc() {
		return MainControl.getCentroCustoFc();
	}

	public CentroCustoFp getCentroCustoFp() {
		return MainControl.getCentroCustoFp();
	}

	public CentroCustoPc getCentroCustoPc() {
		return MainControl.getCentroCustoFc().getCentroCustoPc();
	}

	public CentroCustoPp getCentroCustoPp() {
		return MainControl.getCentroCustoFp().getCentroCustoPp();
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
}
