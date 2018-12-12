package erp.veiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;
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
				getVeiculoFc().limparGui();
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
				getVeiculoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getVeiculoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getVeiculoFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
			getVeiculoFc().limparGui();
			getVeiculoPc().getPlacaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			atualizarObjeto();
			getVeiculoPp().pesquisarRegistroVeiculo(veiculo);

			MainCont.mostrarFrame(getVeiculoFp());
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
				String placa = getVeiculoPc().getPlacaGUI().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoPc().getPlacaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoFac.salvarRegistro(veiculo);
					veiculo = new Veiculo();
					MainCont.getVeiculoFc().limparGui();
					getVeiculoPc().getPlacaGUI().requestFocus();
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
		getVeiculoPc().getAtividadeGUI().setSelectedItem(veiculo.getAtividade());
		getVeiculoPc().getCarroceriaGUI().setSelectedItem(veiculo.getCarroceria());
		getVeiculoPc().getCategoriaGUI().setSelectedItem(veiculo.getCategoria());
		getVeiculoPc().getChassiRemarcadoGUI().setSelectedItem(veiculo.getChassiRemarcado());
		getVeiculoPc().getCombustivelGUI().setSelectedItem(veiculo.getCombustivel());
		getVeiculoPc().getCorGUI().setSelectedItem(veiculo.getCor());
		getVeiculoPc().getEspecieGUI().setSelectedItem(veiculo.getEspecie());
		getVeiculoPc().getFabricacaoGUI().setSelectedItem(veiculo.getFabricacao());
		getVeiculoPc().getIpvaGUI().setSelectedItem(veiculo.getIpva());
		getVeiculoPc().getRestricoesGUI().setSelectedItem(veiculo.getRestricoes());
		getVeiculoPc().getTipoGUI().setSelectedItem(veiculo.getTipo());
		getVeiculoPc().getAnoFabricacaoGUI().setText(veiculo.getAnoFabricacao());
		getVeiculoPc().getAnoModeloGUI().setText(veiculo.getAnoModelo());
		getVeiculoPc().getBairroGUI().setText(veiculo.getBairro());
		getVeiculoPc().getCapCargaGUI().setText(veiculo.getCapCarga());
		getVeiculoPc().getCapacidadePassageirosGUI().setText(veiculo.getCapacidadePassageiros());
		getVeiculoPc().getCategoriaGUI().setSelectedItem(veiculo.getCategoria());
		getVeiculoPc().getCepGUI().setText(veiculo.getCep());
		getVeiculoPc().getChassiGUI().setText(veiculo.getChassi());
		getVeiculoPc().getCilindradaGUI().setText(veiculo.getCilindrada());
		getVeiculoPc().getCilindrosGUI().setText(veiculo.getCilindros());
		getVeiculoPc().getCmtTonGUI().setText(veiculo.getCmtTon());
		getVeiculoPc().getComplementoGUI().setText(veiculo.getComplemento());
		getVeiculoPc().getDataCompraGUI().setText(veiculo.getDataCompra());
		getVeiculoPc().getDataVendaGUI().setText(veiculo.getDataVenda());
		getVeiculoPc().getEixosGUI().setText(veiculo.getEixos());
		getVeiculoPc().getEstadoGUI().setText(veiculo.getEstado());
		getVeiculoPc().getLogradouroGUI().setText(veiculo.getLogradouro());
		getVeiculoPc().getMarcaGUI().setSelectedItem((VeiculoMarca) veiculo.getMarca());
		getVeiculoPc().getModeloGUI().setSelectedItem((VeiculoModelo) veiculo.getModelo());
		getVeiculoPc().getMunicipioEmplacamentoGUI().setText(veiculo.getMunicipioEmplacamento());
		getVeiculoPc().getPaisGUI().setText(veiculo.getPais());
		getVeiculoPc().getPlacaGUI().setText(veiculo.getPlaca());
		getVeiculoPc().getPotenciaGUI().setText(veiculo.getPotencia());
		getVeiculoPc().getProprietarioAnteriorCnpjGUI().setText(veiculo.getProprietarioAnteriorCNPJ());
		getVeiculoPc().getProprietarioAnteriorCpfGUI().setText(veiculo.getProprietarioAnteriorCPF());
		getVeiculoPc().getProprietarioAnteriorEmailGUI().setText(veiculo.getProprietarioAnteriorEmail());
		getVeiculoPc().getTextFieldProprietarioAnteriorFaxGUI().setText(veiculo.getProprietarioAnteriorFax());
		getVeiculoPc().getProprietarioAnteriorNomeGUI().setText(veiculo.getProprietarioAnteriorNome());
		getVeiculoPc().getProprietarioAnteriorFone1GUI().setText(veiculo.getProprietarioAnteriorFone1());
		getVeiculoPc().getProprietarioAnteriorFone2GUI().setText(veiculo.getProprietarioAnteriorFone2());
		getVeiculoPc().getProprietarioCnpjGUI().setText(veiculo.getProprietarioCNPJ());
		getVeiculoPc().getProprietarioCpfGUI().setText(veiculo.getProprietarioCPF());
		getVeiculoPc().getProprietarioEmailGUI().setText(veiculo.getProprietarioEmail());
		getVeiculoPc().getProprietarioFaxGUI().setText(veiculo.getProprietarioFax());
		getVeiculoPc().getProprietarioFone1GUI().setText(veiculo.getProprietarioFone1());
		getVeiculoPc().getProprietarioFone2GUI().setText(veiculo.getProprietarioFone2());
		getVeiculoPc().getProprietarioNomeGUI().setText(veiculo.getProprietarioNome());
		getVeiculoPc().getProprietarioRGNumeroGUI().setText(veiculo.getProprietarioRGNumero());
		getVeiculoPc().getProprietarioRGOrgaoEmisssorGUI().setText(veiculo.getProprietarioRGOrgaoEmisssor());
		getVeiculoPc().getValorCompraGUI().setText(veiculo.getValorCompra());
		getVeiculoPc().getValorVendaGUI().setText(veiculo.getValorVenda());
		getVeiculoPc().getRenavamGUI().setText(veiculo.getRenavam());
		getVeiculoPc().getCidadeGUI().setText(veiculo.getCidade());
	}

	public void atualizarObjeto() {
		veiculo.setAnoFabricacao(getVeiculoPc().getAnoFabricacaoGUI().getText());
		veiculo.setAnoModelo(getVeiculoPc().getAnoModeloGUI().getText());
		veiculo.setAtividade((String) getVeiculoPc().getAtividadeGUI().getSelectedItem());
		veiculo.setBairro(getVeiculoPc().getBairroGUI().getText());
		veiculo.setCapCarga(getVeiculoPc().getCapCargaGUI().getText());
		veiculo.setCapacidadePassageiros(getVeiculoPc().getCapacidadePassageirosGUI().getText());
		veiculo.setCarroceria((String) getVeiculoPc().getCarroceriaGUI().getSelectedItem());
		veiculo.setCategoria((String) getVeiculoPc().getCategoriaGUI().getSelectedItem());
		veiculo.setCep(getVeiculoPc().getCepGUI().getText());
		veiculo.setChassi(getVeiculoPc().getChassiGUI().getText());
		veiculo.setChassiRemarcado((String) getVeiculoPc().getChassiRemarcadoGUI().getSelectedItem());
		veiculo.setCidade(getVeiculoPc().getCidadeGUI().getText());
		veiculo.setCilindrada(getVeiculoPc().getCilindradaGUI().getText());
		veiculo.setCilindros(getVeiculoPc().getCilindrosGUI().getText());
		veiculo.setCmtTon(getVeiculoPc().getCmtTonGUI().getText());
		veiculo.setCombustivel((String) getVeiculoPc().getCombustivelGUI().getSelectedItem());
		veiculo.setComplemento(getVeiculoPc().getComplementoGUI().getText());
		veiculo.setCor((String) getVeiculoPc().getCorGUI().getSelectedItem());
		veiculo.setDataCompra(getVeiculoPc().getDataCompraGUI().getText());
		veiculo.setDataVenda(getVeiculoPc().getDataVendaGUI().getText());
		veiculo.setEixos(getVeiculoPc().getEixosGUI().getText());
		veiculo.setEspecie((String) getVeiculoPc().getEspecieGUI().getSelectedItem());
		veiculo.setEstado(getVeiculoPc().getEstadoGUI().getText());
		veiculo.setFabricacao((String) getVeiculoPc().getFabricacaoGUI().getSelectedItem());
		veiculo.setIpva((String) getVeiculoPc().getIpvaGUI().getSelectedItem());
		veiculo.setLogradouro(getVeiculoPc().getLogradouroGUI().getText());
		veiculo.setMarca((VeiculoMarca) getVeiculoPc().getMarcaGUI().getSelectedItem());
		veiculo.setModelo((VeiculoModelo) getVeiculoPc().getModeloGUI().getSelectedItem());
		veiculo.setMunicipioEmplacamento(getVeiculoPc().getMunicipioEmplacamentoGUI().getText());
		veiculo.setPais(getVeiculoPc().getPaisGUI().getText());
		veiculo.setPlaca(getVeiculoPc().getPlacaGUI().getText());
		veiculo.setPotencia(getVeiculoPc().getPotenciaGUI().getText());
		veiculo.setProprietarioAnteriorCnpj(getVeiculoPc().getProprietarioAnteriorCnpjGUI().getText());
		veiculo.setProprietarioAnteriorCpf(getVeiculoPc().getProprietarioAnteriorCpfGUI().getText());
		veiculo.setProprietarioAnteriorEmail(getVeiculoPc().getProprietarioAnteriorEmailGUI().getText());
		veiculo.setProprietarioAnteriorFax(getVeiculoPc().getTextFieldProprietarioAnteriorFaxGUI().getText());
		veiculo.setProprietarioAnteriorFone1(getVeiculoPc().getProprietarioAnteriorFone1GUI().getText());
		veiculo.setProprietarioAnteriorFone2(getVeiculoPc().getProprietarioAnteriorFone2GUI().getText());
		veiculo.setProprietarioAnteriorNome(getVeiculoPc().getProprietarioAnteriorNomeGUI().getText());
		veiculo.setProprietarioCnpj(getVeiculoPc().getProprietarioCnpjGUI().getText());
		veiculo.setProprietarioCpf(getVeiculoPc().getProprietarioCpfGUI().getText());
		veiculo.setProprietarioEmail(getVeiculoPc().getProprietarioEmailGUI().getText());
		veiculo.setProprietarioFax(getVeiculoPc().getProprietarioFaxGUI().getText());
		veiculo.setProprietarioFone1(getVeiculoPc().getProprietarioFone1GUI().getText());
		veiculo.setProprietarioFone2(getVeiculoPc().getProprietarioFone2GUI().getText());
		veiculo.setProprietarioNome(getVeiculoPc().getProprietarioNomeGUI().getText());
		veiculo.setProprietarioRGNumero(getVeiculoPc().getProprietarioRGNumeroGUI().getText());
		veiculo.setProprietarioRGOrgaoEmisssor(getVeiculoPc().getProprietarioRGOrgaoEmisssorGUI().getText());
		veiculo.setRenavam(getVeiculoPc().getRenavamGUI().getText());
		veiculo.setRestricoes((String) getVeiculoPc().getRestricoesGUI().getSelectedItem());
		veiculo.setTipo((String) getVeiculoPc().getTipoGUI().getSelectedItem());
		veiculo.setValorCompra(getVeiculoPc().getValorCompraGUI().getText());
		veiculo.setValorVenda(getVeiculoPc().getValorVendaGUI().getText());
	}

	public VeiculoFc getVeiculoFc() {
		return MainCont.getVeiculoFc();
	}

	public VeiculoPc getVeiculoPc() {
		return MainCont.getVeiculoFc().getVeiculoPc();
	}

	public VeiculoFp getVeiculoFp() {
		return MainCont.getVeiculoFp();
	}

	public VeiculoPp getVeiculoPp() {
		return MainCont.getVeiculoFp().getVeiculoPp();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		VeiculoCont.veiculo = veiculo;
	}
}
