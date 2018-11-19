package erp.veiculo.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import erp.aop.gui.Msg;
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class VeiculoModeloGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				JOptionPane.showMessageDialog(MainGerenteEventos.getFrameMain(), new PanelSobre(), "Sobre o Sistema",
						-1);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (veiculoModelo == null || veiculoModelo.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				VeiculoModeloDaoFacade.deletarRegistro(veiculoModelo);
				getFrameCadastroVeiculoModelo().limparGui();
				veiculoModelo = new VeiculoModelo();
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
				getFrameCadastroVeiculoModelo().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroVeiculoModelo().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroVeiculoModelo().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			veiculoModelo = new VeiculoModelo();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<VeiculoModelo> veiculoModelos = new LinkedList<>();

			if (veiculoModelo.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (veiculoModelos.add(VeiculoModeloDaoFacade.getRegistro(veiculoModelo))) {
					VeiculoModeloRelatorio veiculoModeloRelatorio = new VeiculoModeloRelatorio(veiculoModelos);
					veiculoModeloRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<VeiculoModelo> veiculoModelos = new LinkedList<>();

			try {
				veiculoModelos = new LinkedList<>(VeiculoModeloDaoFacade.pesquisarRegistro(veiculoModelo));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoModeloRelatorio veiculoModeloRelatorio = new VeiculoModeloRelatorio(veiculoModelos);
			veiculoModeloRelatorio.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			getFrameCadastroVeiculoModelo().limparGui();
			getPanelCadastroVeiculoModelo().getTextFieldModelo().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			atualizarObjeto();
			MainGerenteEventos.getFramePesquisaVeiculoModelo().getPanelPesquisaVeiculoModelo()
					.pesquisarRegistroVeiculoModelo(veiculoModelo);
			MainGerenteEventos.mostrarFrame(getFramePesquisaVeiculoModelo());
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
				String placa = getPanelCadastroVeiculoModelo().getTextFieldModelo().getText();
				if (placa == null || placa.length() == 0) {
					getPanelCadastroVeiculoModelo().getTextFieldModelo().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoModeloDaoFacade.salvarRegistro(veiculoModelo);
					veiculoModelo = new VeiculoModelo();
					getFrameCadastroVeiculoModelo().limparGui();
					getPanelCadastroVeiculoModelo().getTextFieldModelo().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private VeiculoModelo veiculoModelo;

	public void atualizarGui() {
		if (veiculoModelo == null) {
			return;
		}
		getPanelCadastroVeiculoModelo().getTextFieldModelo().setText(veiculoModelo.getModelo());
	}

	public void atualizarObjeto() {
		veiculoModelo.setModelo(getPanelCadastroVeiculoModelo().getTextFieldModelo().getText());
	}

	public VeiculoModelo getVeiculoModelo() {
		return veiculoModelo;
	}

	public void setVeiculoModelo(VeiculoModelo veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

	public FrameCadastroVeiculoModelo getFrameCadastroVeiculoModelo() {
		return MainGerenteEventos.getFrameCadastroVeiculoModelo();
	}

	public PanelCadastroVeiculoModelo getPanelCadastroVeiculoModelo() {
		return MainGerenteEventos.getFrameCadastroVeiculoModelo().getPanelCadastroVeiculoModelo();
	}

	public FramePesquisaVeiculoModelo getFramePesquisaVeiculoModelo() {
		return MainGerenteEventos.getFramePesquisaVeiculoModelo();
	}

	public PanelPesquisaVeiculoModelo getPanelPesquisaVeiculoModelo() {
		return MainGerenteEventos.getFramePesquisaVeiculoModelo().getPanelPesquisaVeiculoModelo();
	}
}