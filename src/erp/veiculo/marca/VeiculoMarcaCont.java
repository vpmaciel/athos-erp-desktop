package erp.veiculo.marca;

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

final class VeiculoMarcaCont {

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
				VeiculoMarcaFac.deletarRegistro(veiculoMarca);
				getVeiculoMarcaFc().limparGui();
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
				getVeiculoMarcaFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getVeiculoMarcaFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getVeiculoMarcaFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<VeiculoMarca> veiculoMarcas = new LinkedList<>();

			try {
				veiculoMarcas = new LinkedList<>(VeiculoMarcaFac.pesquisarRegistro(new VeiculoMarca()));
			} catch (Exception e) {
				System.out.println(e);
			}

			VeiculoMarcaRel veiculoMarcaRel = new VeiculoMarcaRel(veiculoMarcas);
			veiculoMarcaRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<VeiculoMarca> veiculoMarcas = new LinkedList<>();

			if (veiculoMarca.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (veiculoMarcas.add(VeiculoMarcaFac.getRegistro(veiculoMarca))) {
				VeiculoMarcaRel veiculoMarcaRel = new VeiculoMarcaRel(veiculoMarcas);
				veiculoMarcaRel.retornarRelatorio(true);
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoMarca = new VeiculoMarca();
			getVeiculoMarcaFc().limparGui();
			getVeiculoMarcaPc().getGuiMarca().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getVeiculoMarcaPp().pesquisarRegistroVeiculoMarca(veiculoMarca);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getVeiculoMarcaFp());
			}
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
				String placa = getVeiculoMarcaPc().getGuiMarca().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoMarcaPc().getGuiMarca().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				VeiculoMarca veiculoMarcaPesquisa = new VeiculoMarca();
				veiculoMarcaPesquisa.setMarca(getVeiculoMarcaPc().getGuiMarca().getText());
				VeiculoMarca veiculoMarcaPesquisaRetornado = VeiculoMarcaFac.consultarRegistro(veiculoMarcaPesquisa);

				if (veiculoMarca.getId() == null && veiculoMarcaPesquisa.getMarca() != null
						&& veiculoMarcaPesquisaRetornado.getMarca() != null) {
					if (veiculoMarcaPesquisa.getMarca().equals(veiculoMarcaPesquisaRetornado.getMarca())) {
						Msg.avisoCampoDuplicado("NOME", veiculoMarcaPesquisa.getMarca());
						getVeiculoMarcaPc().getGuiMarca().requestFocus();
						return;
					}
				}

				if (veiculoMarca.getId() != null && veiculoMarcaPesquisa.getMarca() != null
						&& veiculoMarcaPesquisaRetornado.getMarca() != null) {
					if (!veiculoMarca.getMarca().equals(veiculoMarcaPesquisa.getMarca())) {
						if (veiculoMarcaPesquisa.getMarca().equals(veiculoMarcaPesquisaRetornado.getMarca())) {
							Msg.avisoCampoDuplicado("NOME", veiculoMarcaPesquisa.getMarca());
							getVeiculoMarcaPc().getGuiMarca().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoMarcaFac.salvarRegistro(veiculoMarca);
					veiculoMarca = new VeiculoMarca();
					getVeiculoMarcaFc().limparGui();
					getVeiculoMarcaPc().getGuiMarca().requestFocus();
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
		getVeiculoMarcaPc().getGuiMarca().setText(veiculoMarca.getMarca());
	}

	public void atualizarObjeto() {
		veiculoMarca.setMarca(getVeiculoMarcaPc().getGuiMarca().getText());
		
		if(getVeiculoMarcaPc().getGuiMarca().getText().length() == 0) {
			veiculoMarca.setMarca(null);
		}

	}

	public VeiculoMarca getVeiculoMarca() {
		return veiculoMarca;
	}

	public void setVeiculoMarca(VeiculoMarca veiculoMarca) {
		this.veiculoMarca = veiculoMarca;
	}

	public VeiculoMarcaFc getVeiculoMarcaFc() {
		return MainCont.getVeiculoMarcaFc();
	}

	public VeiculoMarcaPc getVeiculoMarcaPc() {
		return MainCont.getVeiculoMarcaFc().getVeiculoMarcaPc();
	}

	public VeiculoMarcaFp getVeiculoMarcaFp() {
		return MainCont.getVeiculoMarcaFp();
	}

	public VeiculoMarcaPp getVeiculoMarcaPp() {
		return MainCont.getVeiculoMarcaFp().getVeiculoMarcaPp();
	}
}
