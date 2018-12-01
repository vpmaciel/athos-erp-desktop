package erp.veiculo.veiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainGerenteEventos;

final class VeiculoGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (veiculo == null || veiculo.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				VeiculoDaoFacade.deletarRegistro(veiculo);
				getFrameCadastroVeiculo().limparGui();
				veiculo = new Veiculo();
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
				getFrameCadastroVeiculo().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroVeiculo().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroVeiculo().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			veiculo = new Veiculo();
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
			List<Veiculo> veiculos = new LinkedList<>();

			if (veiculo.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (veiculos.add(VeiculoDaoFacade.getRegistro(veiculo))) {
					VeiculoRelatorio veiculoRelatorio = new VeiculoRelatorio(veiculos);
					veiculoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Veiculo> veiculos = new LinkedList<>();

			try {
				veiculos = new LinkedList<>(VeiculoDaoFacade.pesquisarRegistro(veiculo));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoRelatorio veiculoRelatorio = new VeiculoRelatorio(veiculos);
			veiculoRelatorio.retornarRelatorio(true);
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			getFrameCadastroVeiculo().limparGui();
			getPanelCadastroVeiculo().getTextFieldPlaca().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			atualizarObjeto();
			getPanelPesquisaVeiculo().pesquisarRegistroVeiculo(veiculo);

			MainGerenteEventos.mostrarFrame(getFramePesquisaVeiculo());
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
				String placa = getPanelCadastroVeiculo().getTextFieldPlaca().getText();
				if (placa == null || placa.length() == 0) {
					getPanelCadastroVeiculo().getTextFieldPlaca().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoDaoFacade.salvarRegistro(veiculo);
					veiculo = new Veiculo();
					MainGerenteEventos.getFrameCadastroVeiculo().limparGui();
					getPanelCadastroVeiculo().getTextFieldPlaca().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private static Veiculo veiculo;

	public void atualizarGui() {
		if (veiculo == null) {
			return;
		}
		getPanelCadastroVeiculo().getBoxAtividade().setSelectedItem(veiculo.getAtividade());
		getPanelCadastroVeiculo().getBoxCarroceria().setSelectedItem(veiculo.getCarroceria());
		getPanelCadastroVeiculo().getBoxCategoria().setSelectedItem(veiculo.getCategoria());
		getPanelCadastroVeiculo().getBoxChassiRemarcado().setSelectedItem(veiculo.getChassiRemarcado());
		getPanelCadastroVeiculo().getBoxCombustivel().setSelectedItem(veiculo.getCombustivel());
		getPanelCadastroVeiculo().getBoxCor().setSelectedItem(veiculo.getCor());
		getPanelCadastroVeiculo().getBoxEspecie().setSelectedItem(veiculo.getEspecie());
		getPanelCadastroVeiculo().getBoxFabricacao().setSelectedItem(veiculo.getFabricacao());
		getPanelCadastroVeiculo().getBoxIpva().setSelectedItem(veiculo.getIpva());
		getPanelCadastroVeiculo().getBoxRestricoes().setSelectedItem(veiculo.getRestricoes());
		getPanelCadastroVeiculo().getBoxTipo().setSelectedItem(veiculo.getTipo());
		getPanelCadastroVeiculo().getTextFieldAnoFabricacao().setText(veiculo.getAnoFabricacao());
		getPanelCadastroVeiculo().getTextFieldAnoModelo().setText(veiculo.getAnoModelo());
		getPanelCadastroVeiculo().getTextFieldBairro().setText(veiculo.getBairro());
		getPanelCadastroVeiculo().getTextFieldCapCarga().setText(veiculo.getCapCarga());
		getPanelCadastroVeiculo().getTextFieldCapacidadePassageiros().setText(veiculo.getCapacidadePassageiros());
		getPanelCadastroVeiculo().getBoxCategoria().setSelectedItem(veiculo.getCategoria());
		getPanelCadastroVeiculo().getTextFieldCep().setText(veiculo.getCep());
		getPanelCadastroVeiculo().getTextFieldChassi().setText(veiculo.getChassi());
		getPanelCadastroVeiculo().getTextFieldCilindrada().setText(veiculo.getCilindrada());
		getPanelCadastroVeiculo().getTextFieldCilindros().setText(veiculo.getCilindros());
		getPanelCadastroVeiculo().getTextFieldCmtTon().setText(veiculo.getCmtTon());
		getPanelCadastroVeiculo().getTextFieldComplemento().setText(veiculo.getComplemento());
		getPanelCadastroVeiculo().getTextFieldDataCompra().setText(veiculo.getDataCompra());
		getPanelCadastroVeiculo().getTextFieldDataVenda().setText(veiculo.getDataVenda());
		getPanelCadastroVeiculo().getTextFieldEixos().setText(veiculo.getEixos());
		getPanelCadastroVeiculo().getTextFieldEstado().setText(veiculo.getEstado());
		getPanelCadastroVeiculo().getTextFieldLogradouro().setText(veiculo.getLogradouro());
		getPanelCadastroVeiculo().getTextFieldMarca().setText(veiculo.getMarca());
		getPanelCadastroVeiculo().getTextFieldModelo().setText(veiculo.getModelo());
		getPanelCadastroVeiculo().getTextFieldMunicipioEmplacamento().setText(veiculo.getMunicipioEmplacamento());
		getPanelCadastroVeiculo().getTextFieldPais().setText(veiculo.getPais());
		getPanelCadastroVeiculo().getTextFieldPlaca().setText(veiculo.getPlaca());
		getPanelCadastroVeiculo().getTextFieldPotencia().setText(veiculo.getPotencia());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorCNPJ().setText(veiculo.getProprietarioAnteriorCNPJ());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorCPF().setText(veiculo.getProprietarioAnteriorCPF());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorEmail()
				.setText(veiculo.getProprietarioAnteriorEmail());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFax().setText(veiculo.getProprietarioAnteriorFax());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorNome().setText(veiculo.getProprietarioAnteriorNome());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFone1()
				.setText(veiculo.getProprietarioAnteriorFone1());
		getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFone2()
				.setText(veiculo.getProprietarioAnteriorFone2());
		getPanelCadastroVeiculo().getTextFieldProprietarioCNPJ().setText(veiculo.getProprietarioCNPJ());
		getPanelCadastroVeiculo().getTextFieldProprietarioCPF().setText(veiculo.getProprietarioCPF());
		getPanelCadastroVeiculo().getTextFieldProprietarioEmail().setText(veiculo.getProprietarioEmail());
		getPanelCadastroVeiculo().getTextFieldProprietarioFax().setText(veiculo.getProprietarioFax());
		getPanelCadastroVeiculo().getTextFieldProprietarioFone1().setText(veiculo.getProprietarioFone1());
		getPanelCadastroVeiculo().getTextFieldProprietarioFone2().setText(veiculo.getProprietarioFone2());
		getPanelCadastroVeiculo().getTextFieldProprietarioNome().setText(veiculo.getProprietarioNome());
		getPanelCadastroVeiculo().getTextFieldProprietarioRGNumero().setText(veiculo.getProprietarioRGNumero());
		getPanelCadastroVeiculo().getTextFieldProprietarioRGOrgaoEmisssor()
				.setText(veiculo.getProprietarioRGOrgaoEmisssor());
		getPanelCadastroVeiculo().getTextFieldValorCompra().setText(veiculo.getValorCompra());
		getPanelCadastroVeiculo().getTextFieldValorVenda().setText(veiculo.getValorVenda());
		getPanelCadastroVeiculo().getTextFieldRenavam().setText(veiculo.getRenavam());
		getPanelCadastroVeiculo().getTextFieldCidade().setText(veiculo.getCidade());
	}

	public void atualizarObjeto() {
		veiculo.setAnoFabricacao(getPanelCadastroVeiculo().getTextFieldAnoFabricacao().getText());
		veiculo.setAnoModelo(getPanelCadastroVeiculo().getTextFieldAnoModelo().getText());
		veiculo.setAtividade((String) getPanelCadastroVeiculo().getBoxAtividade().getSelectedItem());
		veiculo.setBairro(getPanelCadastroVeiculo().getTextFieldBairro().getText());
		veiculo.setCapCarga(getPanelCadastroVeiculo().getTextFieldCapCarga().getText());
		veiculo.setCapacidadePassageiros(getPanelCadastroVeiculo().getTextFieldCapacidadePassageiros().getText());
		veiculo.setCarroceria((String) getPanelCadastroVeiculo().getBoxCategoria().getSelectedItem());
		veiculo.setCategoria((String) getPanelCadastroVeiculo().getBoxCategoria().getSelectedItem());
		veiculo.setCep(getPanelCadastroVeiculo().getTextFieldCep().getText());
		veiculo.setChassi(getPanelCadastroVeiculo().getTextFieldChassi().getText());
		veiculo.setChassiRemarcado((String) getPanelCadastroVeiculo().getBoxChassiRemarcado().getSelectedItem());
		veiculo.setCidade(getPanelCadastroVeiculo().getTextFieldCidade().getText());
		veiculo.setCilindrada(getPanelCadastroVeiculo().getTextFieldCilindrada().getText());
		veiculo.setCilindros(getPanelCadastroVeiculo().getTextFieldCilindros().getText());
		veiculo.setCmtTon(getPanelCadastroVeiculo().getTextFieldCmtTon().getText());
		veiculo.setCombustivel((String) getPanelCadastroVeiculo().getBoxCombustivel().getSelectedItem());
		veiculo.setComplemento(getPanelCadastroVeiculo().getTextFieldComplemento().getText());
		veiculo.setCor((String) getPanelCadastroVeiculo().getBoxCor().getSelectedItem());
		veiculo.setDataCompra(getPanelCadastroVeiculo().getTextFieldDataCompra().getText());
		veiculo.setDataVenda(getPanelCadastroVeiculo().getTextFieldDataVenda().getText());
		veiculo.setEixos(getPanelCadastroVeiculo().getTextFieldEixos().getText());
		veiculo.setEspecie((String) getPanelCadastroVeiculo().getBoxEspecie().getSelectedItem());
		veiculo.setEstado(getPanelCadastroVeiculo().getTextFieldEstado().getText());
		veiculo.setFabricacao((String) getPanelCadastroVeiculo().getBoxFabricacao().getSelectedItem());
		veiculo.setIpva((String) getPanelCadastroVeiculo().getBoxIpva().getSelectedItem());
		veiculo.setLogradouro(getPanelCadastroVeiculo().getTextFieldLogradouro().getText());
		veiculo.setMarca(getPanelCadastroVeiculo().getTextFieldMarca().getText());
		veiculo.setModelo(getPanelCadastroVeiculo().getTextFieldModelo().getText());
		veiculo.setMunicipioEmplacamento(getPanelCadastroVeiculo().getTextFieldMunicipioEmplacamento().getText());
		veiculo.setPais(getPanelCadastroVeiculo().getTextFieldPais().getText());
		veiculo.setPlaca(getPanelCadastroVeiculo().getTextFieldPlaca().getText());
		veiculo.setPotencia(getPanelCadastroVeiculo().getTextFieldPotencia().getText());
		veiculo.setProprietarioAnteriorCNPJ(getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorCNPJ().getText());
		veiculo.setProprietarioAnteriorCPF(getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorCPF().getText());
		veiculo.setProprietarioAnteriorEmail(
				getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorEmail().getText());
		veiculo.setProprietarioAnteriorFax(getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFax().getText());
		veiculo.setProprietarioAnteriorFone1(
				getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFone1().getText());
		veiculo.setProprietarioAnteriorFone2(
				getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorFone2().getText());
		veiculo.setProprietarioAnteriorNome(getPanelCadastroVeiculo().getTextFieldProprietarioAnteriorNome().getText());
		veiculo.setProprietarioCNPJ(getPanelCadastroVeiculo().getTextFieldProprietarioCNPJ().getText());
		veiculo.setProprietarioCPF(getPanelCadastroVeiculo().getTextFieldProprietarioCPF().getText());
		veiculo.setProprietarioEmail(getPanelCadastroVeiculo().getTextFieldProprietarioEmail().getText());
		veiculo.setProprietarioFax(getPanelCadastroVeiculo().getTextFieldProprietarioFax().getText());
		veiculo.setProprietarioFone1(getPanelCadastroVeiculo().getTextFieldProprietarioFone1().getText());
		veiculo.setProprietarioFone2(getPanelCadastroVeiculo().getTextFieldProprietarioFone2().getText());
		veiculo.setProprietarioNome(getPanelCadastroVeiculo().getTextFieldProprietarioNome().getText());
		veiculo.setProprietarioRGNumero(getPanelCadastroVeiculo().getTextFieldProprietarioRGNumero().getText());
		veiculo.setProprietarioRGOrgaoEmisssor(
				getPanelCadastroVeiculo().getTextFieldProprietarioRGOrgaoEmisssor().getText());
		veiculo.setRenavam(getPanelCadastroVeiculo().getTextFieldRenavam().getText());
		veiculo.setRestricoes((String) getPanelCadastroVeiculo().getBoxRestricoes().getSelectedItem());
		veiculo.setTipo((String) getPanelCadastroVeiculo().getBoxTipo().getSelectedItem());
		veiculo.setValorCompra(getPanelCadastroVeiculo().getTextFieldValorCompra().getText());
		veiculo.setValorVenda(getPanelCadastroVeiculo().getTextFieldValorVenda().getText());
	}

	public FrameCadastroVeiculo getFrameCadastroVeiculo() {
		return MainGerenteEventos.getFrameCadastroVeiculo();
	}

	public PanelCadastroVeiculo getPanelCadastroVeiculo() {
		return MainGerenteEventos.getFrameCadastroVeiculo().getPanelCadastroVeiculo();
	}

	public FramePesquisaVeiculo getFramePesquisaVeiculo() {
		return MainGerenteEventos.getFramePesquisaVeiculo();
	}

	public PanelPesquisaVeiculo getPanelPesquisaVeiculo() {
		return MainGerenteEventos.getFramePesquisaVeiculo().getPanelPesquisaVeiculo();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		VeiculoGerenteEventos.veiculo = veiculo;
	}
}
