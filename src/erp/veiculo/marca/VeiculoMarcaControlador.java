package erp.veiculo.marca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainControlador;

final class VeiculoMarcaControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (veiculoMarca == null || veiculoMarca.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				VeiculoMarcaDaoFacade.deletarRegistro(veiculoMarca);
				getFrameCadastroVeiculoMarca().limparGUI();
				veiculoMarca = new VeiculoMarca();
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
				getFrameCadastroVeiculoMarca().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroVeiculoMarca().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroVeiculoMarca().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			veiculoMarca = new VeiculoMarca();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<VeiculoMarca> veiculoMarcas = new LinkedList<>();

			if (veiculoMarca.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (veiculoMarcas.add(VeiculoMarcaDaoFacade.getRegistro(veiculoMarca))) {
					VeiculoMarcaRelatorio veiculoMarcaRelatorio = new VeiculoMarcaRelatorio(veiculoMarcas);
					veiculoMarcaRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<VeiculoMarca> veiculoMarcas = new LinkedList<>();

			try {
				veiculoMarcas = new LinkedList<>(VeiculoMarcaDaoFacade.pesquisarRegistro(veiculoMarca));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoMarcaRelatorio veiculoMarcaRelatorio = new VeiculoMarcaRelatorio(veiculoMarcas);
			veiculoMarcaRelatorio.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoMarca = new VeiculoMarca();
			getFrameCadastroVeiculoMarca().limparGUI();
			getPanelCadastroVeiculoMarca().getTextFieldMarca().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoMarca = new VeiculoMarca();
			atualizarObjeto();
			getPanelPesquisaVeiculoMarca().pesquisarRegistroVeiculoMarca(veiculoMarca);
			MainControlador.mostrarFrame(getFramePesquisaVeiculoMarca());
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
				String placa = getPanelCadastroVeiculoMarca().getTextFieldMarca().getText();
				if (placa == null || placa.length() == 0) {
					getPanelCadastroVeiculoMarca().getTextFieldMarca().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoMarcaDaoFacade.salvarRegistro(veiculoMarca);
					veiculoMarca = new VeiculoMarca();
					getFrameCadastroVeiculoMarca().limparGUI();
					getPanelCadastroVeiculoMarca().getTextFieldMarca().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private VeiculoMarca veiculoMarca;

	public void atualizarGui() {
		if (veiculoMarca == null) {
			return;
		}
		getPanelCadastroVeiculoMarca().getTextFieldMarca().setText(veiculoMarca.getMarca());
	}

	public void atualizarObjeto() {
		veiculoMarca.setMarca(getPanelCadastroVeiculoMarca().getTextFieldMarca().getText());
	}

	public VeiculoMarca getVeiculoMarca() {
		return veiculoMarca;
	}

	public void setVeiculoMarca(VeiculoMarca veiculoMarca) {
		this.veiculoMarca = veiculoMarca;
	}

	public FCVeiculoMarca getFrameCadastroVeiculoMarca() {
		return MainControlador.getFrameCadastroVeiculoMarca();
	}

	public PCVeiculoMarca getPanelCadastroVeiculoMarca() {
		return MainControlador.getFrameCadastroVeiculoMarca().getPanelCadastroVeiculoMarca();
	}

	public FPVeiculoMarca getFramePesquisaVeiculoMarca() {
		return MainControlador.getFramePesquisaVeiculoMarca();
	}

	public PPVeiculoMarca getPanelPesquisaVeiculoMarca() {
		return MainControlador.getFramePesquisaVeiculoMarca().getPanelPesquisaVeiculoMarca();
	}
}
