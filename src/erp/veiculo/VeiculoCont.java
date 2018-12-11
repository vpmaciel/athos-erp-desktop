package erp.veiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

final class VeiculoCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (veiculo == null || veiculo.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				VeiculoFac.deletarRegistro(veiculo);
				getFrameCadastroVeiculo().limparGUI();
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
			getFrameCadastroVeiculo().reiniciarGUI();
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Veiculo> veiculos = new LinkedList<>();

			if (veiculo.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (veiculos.add(VeiculoFac.getRegistro(veiculo))) {
					VeiculoRel veiculoRel = new VeiculoRel(veiculos);
					veiculoRel.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Veiculo> veiculos = new LinkedList<>();

			try {
				veiculos = new LinkedList<>(VeiculoFac.pesquisarRegistro(veiculo));
			} catch (Exception e) {
				System.out.println(e);
			}
			VeiculoRel veiculoRel = new VeiculoRel(veiculos);
			veiculoRel.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			getFrameCadastroVeiculo().limparGUI();
			getVeiculoPC().getPlacaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			atualizarObjeto();
			getPanelPesquisaVeiculo().pesquisarRegistroVeiculo(veiculo);

			MainCT.mostrarFrame(getFramePesquisaVeiculo());
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
				String placa = getVeiculoPC().getPlacaGUI().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoPC().getPlacaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoFac.salvarRegistro(veiculo);
					veiculo = new Veiculo();
					MainCT.getFrameCadastroVeiculo().limparGUI();
					getVeiculoPC().getPlacaGUI().requestFocus();
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
		getVeiculoPC().getAtividadeGUI().setSelectedItem(veiculo.getAtividade());
		getVeiculoPC().getCarroceriaGUI().setSelectedItem(veiculo.getCarroceria());
		getVeiculoPC().getCategoriaGUI().setSelectedItem(veiculo.getCategoria());
		getVeiculoPC().getChassiRemarcadoGUI().setSelectedItem(veiculo.getChassiRemarcado());
		getVeiculoPC().getCombustivelGUI().setSelectedItem(veiculo.getCombustivel());
		getVeiculoPC().getCorGUI().setSelectedItem(veiculo.getCor());
		getVeiculoPC().getEspecieGUI().setSelectedItem(veiculo.getEspecie());
		getVeiculoPC().getFabricacaoGUI().setSelectedItem(veiculo.getFabricacao());
		getVeiculoPC().getIpvaGUI().setSelectedItem(veiculo.getIpva());
		getVeiculoPC().getRestricoesGUI().setSelectedItem(veiculo.getRestricoes());
		getVeiculoPC().getTipoGUI().setSelectedItem(veiculo.getTipo());
		getVeiculoPC().getAnoFabricacaoGUI().setText(veiculo.getAnoFabricacao());
		getVeiculoPC().getAnoModeloGUI().setText(veiculo.getAnoModelo());
		getVeiculoPC().getBairroGUI().setText(veiculo.getBairro());
		getVeiculoPC().getCapCargaGUI().setText(veiculo.getCapCarga());
		getVeiculoPC().getCapacidadePassageirosGUI().setText(veiculo.getCapacidadePassageiros());
		getVeiculoPC().getCategoriaGUI().setSelectedItem(veiculo.getCategoria());
		getVeiculoPC().getCepGUI().setText(veiculo.getCep());
		getVeiculoPC().getChassiGUI().setText(veiculo.getChassi());
		getVeiculoPC().getCilindradaGUI().setText(veiculo.getCilindrada());
		getVeiculoPC().getCilindrosGUI().setText(veiculo.getCilindros());
		getVeiculoPC().getCmtTonGUI().setText(veiculo.getCmtTon());
		getVeiculoPC().getComplementoGUI().setText(veiculo.getComplemento());
		getVeiculoPC().getDataCompraGUI().setText(veiculo.getDataCompra());
		getVeiculoPC().getDataVendaGUI().setText(veiculo.getDataVenda());
		getVeiculoPC().getEixosGUI().setText(veiculo.getEixos());
		getVeiculoPC().getEstadoGUI().setText(veiculo.getEstado());
		getVeiculoPC().getLogradouroGUI().setText(veiculo.getLogradouro());
		getVeiculoPC().getMarcaGUI().setSelectedItem((VeiculoMarca) veiculo.getMarca());
		getVeiculoPC().getModeloGUI().setSelectedItem((VeiculoModelo) veiculo.getModelo());
		getVeiculoPC().getMunicipioEmplacamentoGUI().setText(veiculo.getMunicipioEmplacamento());
		getVeiculoPC().getPaisGUI().setText(veiculo.getPais());
		getVeiculoPC().getPlacaGUI().setText(veiculo.getPlaca());
		getVeiculoPC().getPotenciaGUI().setText(veiculo.getPotencia());
		getVeiculoPC().getProprietarioAnteriorCnpjGUI().setText(veiculo.getProprietarioAnteriorCNPJ());
		getVeiculoPC().getProprietarioAnteriorCpfGUI().setText(veiculo.getProprietarioAnteriorCPF());
		getVeiculoPC().getProprietarioAnteriorEmailGUI().setText(veiculo.getProprietarioAnteriorEmail());
		getVeiculoPC().getTextFieldProprietarioAnteriorFaxGUI().setText(veiculo.getProprietarioAnteriorFax());
		getVeiculoPC().getProprietarioAnteriorNomeGUI().setText(veiculo.getProprietarioAnteriorNome());
		getVeiculoPC().getProprietarioAnteriorFone1GUI().setText(veiculo.getProprietarioAnteriorFone1());
		getVeiculoPC().getProprietarioAnteriorFone2GUI().setText(veiculo.getProprietarioAnteriorFone2());
		getVeiculoPC().getProprietarioCnpjGUI().setText(veiculo.getProprietarioCNPJ());
		getVeiculoPC().getProprietarioCpfGUI().setText(veiculo.getProprietarioCPF());
		getVeiculoPC().getProprietarioEmailGUI().setText(veiculo.getProprietarioEmail());
		getVeiculoPC().getProprietarioFaxGUI().setText(veiculo.getProprietarioFax());
		getVeiculoPC().getProprietarioFone1GUI().setText(veiculo.getProprietarioFone1());
		getVeiculoPC().getProprietarioFone2GUI().setText(veiculo.getProprietarioFone2());
		getVeiculoPC().getProprietarioNomeGUI().setText(veiculo.getProprietarioNome());
		getVeiculoPC().getProprietarioRGNumeroGUI().setText(veiculo.getProprietarioRGNumero());
		getVeiculoPC().getProprietarioRGOrgaoEmisssorGUI().setText(veiculo.getProprietarioRGOrgaoEmisssor());
		getVeiculoPC().getValorCompraGUI().setText(veiculo.getValorCompra());
		getVeiculoPC().getValorVendaGUI().setText(veiculo.getValorVenda());
		getVeiculoPC().getRenavamGUI().setText(veiculo.getRenavam());
		getVeiculoPC().getCidadeGUI().setText(veiculo.getCidade());
	}

	public void atualizarObjeto() {
		veiculo.setAnoFabricacao(getVeiculoPC().getAnoFabricacaoGUI().getText());
		veiculo.setAnoModelo(getVeiculoPC().getAnoModeloGUI().getText());
		veiculo.setAtividade((String) getVeiculoPC().getAtividadeGUI().getSelectedItem());
		veiculo.setBairro(getVeiculoPC().getBairroGUI().getText());
		veiculo.setCapCarga(getVeiculoPC().getCapCargaGUI().getText());
		veiculo.setCapacidadePassageiros(getVeiculoPC().getCapacidadePassageirosGUI().getText());
		veiculo.setCarroceria((String) getVeiculoPC().getCarroceriaGUI().getSelectedItem());
		veiculo.setCategoria((String) getVeiculoPC().getCategoriaGUI().getSelectedItem());
		veiculo.setCep(getVeiculoPC().getCepGUI().getText());
		veiculo.setChassi(getVeiculoPC().getChassiGUI().getText());
		veiculo.setChassiRemarcado((String) getVeiculoPC().getChassiRemarcadoGUI().getSelectedItem());
		veiculo.setCidade(getVeiculoPC().getCidadeGUI().getText());
		veiculo.setCilindrada(getVeiculoPC().getCilindradaGUI().getText());
		veiculo.setCilindros(getVeiculoPC().getCilindrosGUI().getText());
		veiculo.setCmtTon(getVeiculoPC().getCmtTonGUI().getText());
		veiculo.setCombustivel((String) getVeiculoPC().getCombustivelGUI().getSelectedItem());
		veiculo.setComplemento(getVeiculoPC().getComplementoGUI().getText());
		veiculo.setCor((String) getVeiculoPC().getCorGUI().getSelectedItem());
		veiculo.setDataCompra(getVeiculoPC().getDataCompraGUI().getText());
		veiculo.setDataVenda(getVeiculoPC().getDataVendaGUI().getText());
		veiculo.setEixos(getVeiculoPC().getEixosGUI().getText());
		veiculo.setEspecie((String) getVeiculoPC().getEspecieGUI().getSelectedItem());
		veiculo.setEstado(getVeiculoPC().getEstadoGUI().getText());
		veiculo.setFabricacao((String) getVeiculoPC().getFabricacaoGUI().getSelectedItem());
		veiculo.setIpva((String) getVeiculoPC().getIpvaGUI().getSelectedItem());
		veiculo.setLogradouro(getVeiculoPC().getLogradouroGUI().getText());
		veiculo.setMarca((VeiculoMarca) getVeiculoPC().getMarcaGUI().getSelectedItem());
		veiculo.setModelo((VeiculoModelo) getVeiculoPC().getModeloGUI().getSelectedItem());
		veiculo.setMunicipioEmplacamento(getVeiculoPC().getMunicipioEmplacamentoGUI().getText());
		veiculo.setPais(getVeiculoPC().getPaisGUI().getText());
		veiculo.setPlaca(getVeiculoPC().getPlacaGUI().getText());
		veiculo.setPotencia(getVeiculoPC().getPotenciaGUI().getText());
		veiculo.setProprietarioAnteriorCnpj(getVeiculoPC().getProprietarioAnteriorCnpjGUI().getText());
		veiculo.setProprietarioAnteriorCpf(getVeiculoPC().getProprietarioAnteriorCpfGUI().getText());
		veiculo.setProprietarioAnteriorEmail(getVeiculoPC().getProprietarioAnteriorEmailGUI().getText());
		veiculo.setProprietarioAnteriorFax(getVeiculoPC().getTextFieldProprietarioAnteriorFaxGUI().getText());
		veiculo.setProprietarioAnteriorFone1(getVeiculoPC().getProprietarioAnteriorFone1GUI().getText());
		veiculo.setProprietarioAnteriorFone2(getVeiculoPC().getProprietarioAnteriorFone2GUI().getText());
		veiculo.setProprietarioAnteriorNome(getVeiculoPC().getProprietarioAnteriorNomeGUI().getText());
		veiculo.setProprietarioCnpj(getVeiculoPC().getProprietarioCnpjGUI().getText());
		veiculo.setProprietarioCpf(getVeiculoPC().getProprietarioCpfGUI().getText());
		veiculo.setProprietarioEmail(getVeiculoPC().getProprietarioEmailGUI().getText());
		veiculo.setProprietarioFax(getVeiculoPC().getProprietarioFaxGUI().getText());
		veiculo.setProprietarioFone1(getVeiculoPC().getProprietarioFone1GUI().getText());
		veiculo.setProprietarioFone2(getVeiculoPC().getProprietarioFone2GUI().getText());
		veiculo.setProprietarioNome(getVeiculoPC().getProprietarioNomeGUI().getText());
		veiculo.setProprietarioRGNumero(getVeiculoPC().getProprietarioRGNumeroGUI().getText());
		veiculo.setProprietarioRGOrgaoEmisssor(getVeiculoPC().getProprietarioRGOrgaoEmisssorGUI().getText());
		veiculo.setRenavam(getVeiculoPC().getRenavamGUI().getText());
		veiculo.setRestricoes((String) getVeiculoPC().getRestricoesGUI().getSelectedItem());
		veiculo.setTipo((String) getVeiculoPC().getTipoGUI().getSelectedItem());
		veiculo.setValorCompra(getVeiculoPC().getValorCompraGUI().getText());
		veiculo.setValorVenda(getVeiculoPC().getValorVendaGUI().getText());
	}

	public VeiculoFc getFrameCadastroVeiculo() {
		return MainCT.getFrameCadastroVeiculo();
	}

	public VeiculoPc getVeiculoPC() {
		return MainCT.getFrameCadastroVeiculo().getPanelCadastroVeiculo();
	}

	public VeiculoFp getFramePesquisaVeiculo() {
		return MainCT.getFramePesquisaVeiculo();
	}

	public VeiculoPp getPanelPesquisaVeiculo() {
		return MainCT.getFramePesquisaVeiculo().getPanelPesquisaVeiculo();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		VeiculoCont.veiculo = veiculo;
	}
}
