package erp.centrocusto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainControlador;

final class CentroCustoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

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
				CentroCustoDaoFacade.deletarRegistro(centroCusto);
				getFrameCadastroCentroCusto().limparGui();
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
			getFrameCadastroCentroCusto().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroCentroCusto().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroCentroCusto().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			centroCusto = new CentroCusto();
			getPanelCadastroCentroCusto().getTextFieldNome().requestFocus();
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

			List<CentroCusto> centroCustos = new LinkedList<>();

			try {
				centroCustos = new LinkedList<>(CentroCustoDaoFacade.pesquisarRegistro(new CentroCusto()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CentroCustoRelatorio centroCustoRelatorio = new CentroCustoRelatorio(centroCustos);
			centroCustoRelatorio.retornarRelatorio(true);
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<CentroCusto> centroCustos = new LinkedList<>();

			if (centroCusto.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (centroCustos.add(CentroCustoDaoFacade.getRegistro(centroCusto))) {
				CentroCustoRelatorio centroCustoRelatorio = new CentroCustoRelatorio(centroCustos);
				centroCustoRelatorio.retornarRelatorio(true);
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			centroCusto = new CentroCusto();
			getFrameCadastroCentroCusto().limparGui();
			getPanelCadastroCentroCusto().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getPanelPesquisaCentroCusto().pesquisarRegistroCentroCusto(centroCusto);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControlador.mostrarFrame(getFramePesquisaCentroCusto());
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

				if ((getPanelCadastroCentroCusto().getTextFieldNome().getText()) == null
						|| getPanelCadastroCentroCusto().getTextFieldNome().getText().length() == 0) {
					getPanelCadastroCentroCusto().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CentroCustoDaoFacade.salvarRegistro(centroCusto);
					centroCusto = new CentroCusto();
					getFrameCadastroCentroCusto().limparGui();
					getPanelCadastroCentroCusto().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private CentroCusto centroCusto;

	public CentroCustoControlador() {

	}

	public void atualizarGui() {
		if (centroCusto == null) {
			return;
		}
		getPanelCadastroCentroCusto().getTextFieldNome().setText(centroCusto.getNome());
	}

	public void atualizarObjeto() {
		centroCusto.setNome(getPanelCadastroCentroCusto().getTextFieldNome().getText());
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public FCCentroCusto getFrameCadastroCentroCusto() {
		return MainControlador.getFrameCadastroCentroCusto();
	}

	public PCCentroCusto getPanelCadastroCentroCusto() {
		return MainControlador.getFrameCadastroCentroCusto().getPanelCadastroCentroCusto();
	}

	public FPCentroCusto getFramePesquisaCentroCusto() {
		return MainControlador.getFramePesquisaCentroCusto();
	}

	public PPCentroCusto getPanelPesquisaCentroCusto() {
		return MainControlador.getFramePesquisaCentroCusto().getPanelPesquisaCentroCusto();
	}
}
