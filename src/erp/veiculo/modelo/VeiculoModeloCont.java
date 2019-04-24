package erp.veiculo.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;
import erp.veiculo.modelo.VeiculoModelo;
import erp.veiculo.modelo.VeiculoModeloFac;

final class VeiculoModeloCont {

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
				VeiculoModeloFac.deletarRegistro(veiculoModelo);
				getVeiculoModeloFc().limparGui();
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
				getVeiculoModeloFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getVeiculoModeloFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getVeiculoModeloFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				if (veiculoModelos.add(VeiculoModeloFac.getRegistro(veiculoModelo))) {
					VeiculoModeloRel veiculoModeloRel = new VeiculoModeloRel(veiculoModelos);
					veiculoModeloRel.retornarRelatorio(true);
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
				veiculoModelos = new LinkedList<>(VeiculoModeloFac.pesquisarRegistro(veiculoModelo));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoModeloRel veiculoModeloRel = new VeiculoModeloRel(veiculoModelos);
			veiculoModeloRel.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			getVeiculoModeloFc().limparGui();
			getVeiculoModeloPc().getModeloGui().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculoModelo = new VeiculoModelo();
			atualizarObjeto();
			MainCont.getVeiculoModeloFp().getVeiculoModeloPp().pesquisarRegistroVeiculoModelo(veiculoModelo);
			MainCont.mostrarFrame(getVeiculoModeloFp());
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
				String placa = getVeiculoModeloPc().getModeloGui().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoModeloPc().getModeloGui().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				VeiculoModelo veiculoModeloPesquisa = new VeiculoModelo();
				veiculoModeloPesquisa.setModelo(getVeiculoModeloPc().getModeloGui().getText());
				VeiculoModelo veiculoModeloPesquisaRetornado = VeiculoModeloFac.consultarRegistro(veiculoModeloPesquisa);

				if (veiculoModelo.getId() == null && veiculoModeloPesquisa.getModelo() != null
						&& veiculoModeloPesquisaRetornado.getModelo() != null) {
					if (veiculoModeloPesquisa.getModelo().equals(veiculoModeloPesquisaRetornado.getModelo())) {
						Msg.avisoCampoDuplicado("NOME", veiculoModeloPesquisa.getModelo());
						getVeiculoModeloPc().getModeloGui().requestFocus();
						return;
					}
				}

				if (veiculoModelo.getId() != null && veiculoModeloPesquisa.getModelo() != null
						&& veiculoModeloPesquisaRetornado.getModelo() != null) {
					if (!veiculoModelo.getModelo().equals(veiculoModeloPesquisa.getModelo())) {
						if (veiculoModeloPesquisa.getModelo().equals(veiculoModeloPesquisaRetornado.getModelo())) {
							Msg.avisoCampoDuplicado("NOME", veiculoModeloPesquisa.getModelo());
							getVeiculoModeloPc().getModeloGui().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoModeloFac.salvarRegistro(veiculoModelo);
					veiculoModelo = new VeiculoModelo();
					getVeiculoModeloFc().limparGui();
					getVeiculoModeloPc().getModeloGui().requestFocus();
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
		getVeiculoModeloPc().getModeloGui().setText(veiculoModelo.getModelo());
	}

	public void atualizarObjeto() {
		veiculoModelo.setModelo(getVeiculoModeloPc().getModeloGui().getText());
		
		if(getVeiculoModeloPc().getModeloGui().getText().length() == 0) {
			veiculoModelo.setModelo(null);
		}
	}

	public VeiculoModelo getVeiculoModelo() {
		return veiculoModelo;
	}

	public void setVeiculoModelo(VeiculoModelo veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

	public VeiculoModeloFc getVeiculoModeloFc() {
		return MainCont.getVeiculoModeloFc();
	}

	public VeiculoModeloPc getVeiculoModeloPc() {
		return MainCont.getVeiculoModeloFc().getVeiculoModeloPc();
	}

	public VeiculoModeloFp getVeiculoModeloFp() {
		return MainCont.getVeiculoModeloFp();
	}

	public VeiculoModeloPp getVeiculoModeloPp() {
		return MainCont.getVeiculoModeloFp().getVeiculoModeloPp();
	}
}