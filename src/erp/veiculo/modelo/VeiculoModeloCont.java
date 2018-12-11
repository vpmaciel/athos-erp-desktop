package erp.veiculo.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class VeiculoModeloCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
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
				VeiculoModeloFAC.deletarRegistro(veiculoModelo);
				getFrameCadastroVeiculoModelo().limparGUI();
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
			getFrameCadastroVeiculoModelo().reiniciarGUI();
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
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
				if (veiculoModelos.add(VeiculoModeloFAC.getRegistro(veiculoModelo))) {
					VeiculoModeloREL veiculoModeloREL = new VeiculoModeloREL(veiculoModelos);
					veiculoModeloREL.retornarRelatorio(true);
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
				veiculoModelos = new LinkedList<>(VeiculoModeloFAC.pesquisarRegistro(veiculoModelo));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoModeloREL veiculoModeloREL = new VeiculoModeloREL(veiculoModelos);
			veiculoModeloREL.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			getFrameCadastroVeiculoModelo().limparGUI();
			getPanelCadastroVeiculoModelo().getTextFieldModelo().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			atualizarObjeto();
			MainCT.getFramePesquisaVeiculoModelo().getPanelPesquisaVeiculoModelo()
					.pesquisarRegistroVeiculoModelo(veiculoModelo);
			MainCT.mostrarFrame(getFramePesquisaVeiculoModelo());
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
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoModeloFAC.salvarRegistro(veiculoModelo);
					veiculoModelo = new VeiculoModelo();
					getFrameCadastroVeiculoModelo().limparGUI();
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

	public VeiculoModeloFC getFrameCadastroVeiculoModelo() {
		return MainCT.getFrameCadastroVeiculoModelo();
	}

	public VeiculoModeloPC getPanelCadastroVeiculoModelo() {
		return MainCT.getFrameCadastroVeiculoModelo().getPanelCadastroVeiculoModelo();
	}

	public VeiculoModeloFP getFramePesquisaVeiculoModelo() {
		return MainCT.getFramePesquisaVeiculoModelo();
	}

	public VeiculoModeloPP getPanelPesquisaVeiculoModelo() {
		return MainCT.getFramePesquisaVeiculoModelo().getPanelPesquisaVeiculoModelo();
	}
}