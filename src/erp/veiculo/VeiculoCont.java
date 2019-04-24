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
			getVeiculoPc().getPlacaGui().requestFocus();
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
				String placa = getVeiculoPc().getPlacaGui().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoPc().getPlacaGui().requestFocus();
					Msg.avisoCampoObrigatorio("PLACA");
					return;
				}
				
				Veiculo veiculoPesquisa = new Veiculo();
				veiculoPesquisa.setPlaca(getVeiculoPc().getPlacaGui().getText());
				Veiculo veiculoPesquisaRetornado = VeiculoFac.consultarRegistro(veiculoPesquisa);

				if (veiculo.getId() == null && veiculoPesquisa.getPlaca() != null
						&& veiculoPesquisaRetornado.getPlaca() != null) {
					if (veiculoPesquisa.getPlaca().equals(veiculoPesquisaRetornado.getPlaca())) {
						Msg.avisoCampoDuplicado("PLACA", veiculoPesquisa.getPlaca());
						getVeiculoPc().getPlacaGui().requestFocus();
						return;
					}
				}

				if (veiculo.getId() != null && veiculoPesquisa.getPlaca() != null
						&& veiculoPesquisaRetornado.getPlaca() != null) {
					if (!veiculo.getPlaca().equals(veiculoPesquisa.getPlaca())) {
						if (veiculoPesquisa.getPlaca().equals(veiculoPesquisaRetornado.getPlaca())) {
							Msg.avisoCampoDuplicado("PLACA", veiculoPesquisa.getPlaca());
							getVeiculoPc().getPlacaGui().requestFocus();
						}
						return;
					}
				}

				veiculoPesquisa = new Veiculo();
				veiculoPesquisa.setChassi(getVeiculoPc().getChassiGui().getText());
				veiculoPesquisaRetornado = VeiculoFac.consultarRegistro(veiculoPesquisa);

				if (veiculo.getId() == null && veiculoPesquisa.getChassi() != null
						&& veiculoPesquisaRetornado.getChassi() != null) {
					if (veiculoPesquisa.getChassi().equals(veiculoPesquisaRetornado.getChassi())) {
						Msg.avisoCampoDuplicado("CHASSI", veiculoPesquisa.getChassi());
						getVeiculoPc().getChassiGui().requestFocus();
						return;
					}
				}

				if (veiculo.getId() != null && veiculoPesquisa.getChassi() != null
						&& veiculoPesquisaRetornado.getChassi() != null) {
					if (!veiculo.getChassi().equals(veiculoPesquisa.getChassi())) {
						if (veiculoPesquisa.getChassi().equals(veiculoPesquisaRetornado.getChassi())) {
							Msg.avisoCampoDuplicado("CHASSI", veiculoPesquisa.getChassi());
							getVeiculoPc().getChassiGui().requestFocus();
						}
						return;
					}
				}

				veiculoPesquisa = new Veiculo();
				veiculoPesquisa.setRenavam(getVeiculoPc().getRenavamGui().getText());
				veiculoPesquisaRetornado = VeiculoFac.consultarRegistro(veiculoPesquisa);

				if (veiculo.getId() == null && veiculoPesquisa.getRenavam() != null
						&& veiculoPesquisaRetornado.getRenavam() != null) {
					if (veiculoPesquisa.getRenavam().equals(veiculoPesquisaRetornado.getRenavam())) {
						Msg.avisoCampoDuplicado("RENAVAM", veiculoPesquisa.getRenavam());
						getVeiculoPc().getRenavamGui().requestFocus();
						return;
					}
				}

				if (veiculo.getId() != null && veiculoPesquisa.getChassi() != null
						&& veiculoPesquisaRetornado.getChassi() != null) {
					if (!veiculo.getChassi().equals(veiculoPesquisa.getChassi())) {
						if (veiculoPesquisa.getChassi().equals(veiculoPesquisaRetornado.getChassi())) {
							Msg.avisoCampoDuplicado("RENAVAM", veiculoPesquisa.getChassi());
							getVeiculoPc().getChassiGui().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoFac.salvarRegistro(veiculo);
					veiculo = new Veiculo();
					MainCont.getVeiculoFc().limparGui();
					getVeiculoPc().getPlacaGui().requestFocus();
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
		getVeiculoPc().getAtividadeGui().setSelectedItem(veiculo.getAtividade());
		getVeiculoPc().getCarroceriaGui().setSelectedItem(veiculo.getCarroceria());
		getVeiculoPc().getCategoriaGui().setSelectedItem(veiculo.getCategoria());
		getVeiculoPc().getChassiRemarcadoGui().setSelectedItem(veiculo.getChassiRemarcado());
		getVeiculoPc().getCombustivelGui().setSelectedItem(veiculo.getCombustivel());
		getVeiculoPc().getCorGui().setSelectedItem(veiculo.getCor());
		getVeiculoPc().getEspecieGui().setSelectedItem(veiculo.getEspecie());
		getVeiculoPc().getFabricacaoGui().setSelectedItem(veiculo.getFabricacao());
		getVeiculoPc().getIpvaGui().setSelectedItem(veiculo.getIpva());
		getVeiculoPc().getRestricoesGui().setSelectedItem(veiculo.getRestricoes());
		getVeiculoPc().getTipoGui().setSelectedItem(veiculo.getTipo());
		getVeiculoPc().getAnoFabricacaoGui().setText(veiculo.getAnoFabricacao());
		getVeiculoPc().getAnoModeloGui().setText(veiculo.getAnoModelo());
		getVeiculoPc().getBairroGui().setText(veiculo.getBairro());
		getVeiculoPc().getCapCargaGui().setText(veiculo.getCapCarga());
		getVeiculoPc().getCapacidadePassageirosGui().setText(veiculo.getCapacidadePassageiros());
		getVeiculoPc().getCategoriaGui().setSelectedItem(veiculo.getCategoria());
		getVeiculoPc().getCepGui().setText(veiculo.getCep());
		getVeiculoPc().getChassiGui().setText(veiculo.getChassi());
		getVeiculoPc().getCilindradaGui().setText(veiculo.getCilindrada());
		getVeiculoPc().getCilindrosGui().setText(veiculo.getCilindros());
		getVeiculoPc().getCmtTonGui().setText(veiculo.getCmtTon());
		getVeiculoPc().getComplementoGui().setText(veiculo.getComplemento());
		getVeiculoPc().getDataCompraGui().setText(veiculo.getDataCompra());
		getVeiculoPc().getDataVendaGui().setText(veiculo.getDataVenda());
		getVeiculoPc().getEixosGui().setText(veiculo.getEixos());
		getVeiculoPc().getEstadoGui().setText(veiculo.getEstado());
		getVeiculoPc().getLogradouroGui().setText(veiculo.getLogradouro());
		getVeiculoPc().getBoxVeiculoMarca().setSelectedItem(veiculo.getMarca());
		getVeiculoPc().getBoxVeiculoModelo().setSelectedItem(veiculo.getModelo());
		getVeiculoPc().getMunicipioEmplacamentoGui().setText(veiculo.getMunicipioEmplacamento());
		getVeiculoPc().getPaisGui().setText(veiculo.getPais());
		getVeiculoPc().getPlacaGui().setText(veiculo.getPlaca());
		getVeiculoPc().getPotenciaGui().setText(veiculo.getPotencia());
		getVeiculoPc().getProprietarioAnteriorCnpjGui().setText(veiculo.getProprietarioAnteriorCnpj());
		getVeiculoPc().getProprietarioAnteriorCpfGui().setText(veiculo.getProprietarioAnteriorCpf());
		getVeiculoPc().getProprietarioAnteriorEmailGui().setText(veiculo.getProprietarioAnteriorEmail());
		getVeiculoPc().getTextFieldProprietarioAnteriorFaxGui().setText(veiculo.getProprietarioAnteriorFax());
		getVeiculoPc().getProprietarioAnteriorNomeGui().setText(veiculo.getProprietarioAnteriorNome());
		getVeiculoPc().getProprietarioAnteriorFone1Gui().setText(veiculo.getProprietarioAnteriorFone1());
		getVeiculoPc().getProprietarioAnteriorFone2Gui().setText(veiculo.getProprietarioAnteriorFone2());
		getVeiculoPc().getProprietarioCnpjGui().setText(veiculo.getProprietarioCNPJ());
		getVeiculoPc().getProprietarioCpfGui().setText(veiculo.getProprietarioCpf());
		getVeiculoPc().getProprietarioEmailGui().setText(veiculo.getProprietarioEmail());
		getVeiculoPc().getProprietarioFaxGui().setText(veiculo.getProprietarioFax());
		getVeiculoPc().getProprietarioFone1Gui().setText(veiculo.getProprietarioFone1());
		getVeiculoPc().getProprietarioFone2Gui().setText(veiculo.getProprietarioFone2());
		getVeiculoPc().getProprietarioNomeGui().setText(veiculo.getProprietarioNome());
		getVeiculoPc().getProprietarioRGNumeroGui().setText(veiculo.getProprietarioRGNumero());
		getVeiculoPc().getProprietarioRGOrgaoEmisssorGui().setText(veiculo.getProprietarioRGOrgaoEmisssor());
		getVeiculoPc().getValorCompraGui().setText(veiculo.getValorCompra());
		getVeiculoPc().getValorVendaGui().setText(veiculo.getValorVenda());
		getVeiculoPc().getRenavamGui().setText(veiculo.getRenavam());
		getVeiculoPc().getCidadeGui().setText(veiculo.getCidade());
	}

	public void atualizarObjeto() {
		veiculo.setAnoFabricacao(getVeiculoPc().getAnoFabricacaoGui().getText());
		veiculo.setAnoModelo(getVeiculoPc().getAnoModeloGui().getText());
		veiculo.setAtividade((String) getVeiculoPc().getAtividadeGui().getSelectedItem());
		veiculo.setBairro(getVeiculoPc().getBairroGui().getText());
		veiculo.setCapCarga(getVeiculoPc().getCapCargaGui().getText());
		veiculo.setCapacidadePassageiros(getVeiculoPc().getCapacidadePassageirosGui().getText());
		veiculo.setCarroceria((String) getVeiculoPc().getCarroceriaGui().getSelectedItem());
		veiculo.setCategoria((String) getVeiculoPc().getCategoriaGui().getSelectedItem());
		veiculo.setCep(getVeiculoPc().getCepGui().getText());
		veiculo.setChassi(getVeiculoPc().getChassiGui().getText());
		veiculo.setChassiRemarcado((String) getVeiculoPc().getChassiRemarcadoGui().getSelectedItem());
		veiculo.setCidade(getVeiculoPc().getCidadeGui().getText());
		veiculo.setCilindrada(getVeiculoPc().getCilindradaGui().getText());
		veiculo.setCilindros(getVeiculoPc().getCilindrosGui().getText());
		veiculo.setCmtTon(getVeiculoPc().getCmtTonGui().getText());
		veiculo.setCombustivel((String) getVeiculoPc().getCombustivelGui().getSelectedItem());
		veiculo.setComplemento(getVeiculoPc().getComplementoGui().getText());
		veiculo.setCor((String) getVeiculoPc().getCorGui().getSelectedItem());
		veiculo.setDataCompra(getVeiculoPc().getDataCompraGui().getText());
		veiculo.setDataVenda(getVeiculoPc().getDataVendaGui().getText());
		veiculo.setEixos(getVeiculoPc().getEixosGui().getText());
		veiculo.setEspecie((String) getVeiculoPc().getEspecieGui().getSelectedItem());
		veiculo.setEstado(getVeiculoPc().getEstadoGui().getText());
		veiculo.setFabricacao((String) getVeiculoPc().getFabricacaoGui().getSelectedItem());
		veiculo.setIpva((String) getVeiculoPc().getIpvaGui().getSelectedItem());
		veiculo.setLogradouro(getVeiculoPc().getLogradouroGui().getText());
		veiculo.setMarca((VeiculoMarca) getVeiculoPc().getBoxVeiculoMarca().getSelectedItem());
		veiculo.setModelo((VeiculoModelo) getVeiculoPc().getBoxVeiculoModelo().getSelectedItem());
		veiculo.setMunicipioEmplacamento(getVeiculoPc().getMunicipioEmplacamentoGui().getText());
		veiculo.setPais(getVeiculoPc().getPaisGui().getText());
		veiculo.setPlaca(getVeiculoPc().getPlacaGui().getText());
		veiculo.setPotencia(getVeiculoPc().getPotenciaGui().getText());
		veiculo.setProprietarioAnteriorCnpj(getVeiculoPc().getProprietarioAnteriorCnpjGui().getText());
		veiculo.setProprietarioAnteriorCpf(getVeiculoPc().getProprietarioAnteriorCpfGui().getText());
		veiculo.setProprietarioAnteriorEmail(getVeiculoPc().getProprietarioAnteriorEmailGui().getText());
		veiculo.setProprietarioAnteriorFax(getVeiculoPc().getTextFieldProprietarioAnteriorFaxGui().getText());
		veiculo.setProprietarioAnteriorFone1(getVeiculoPc().getProprietarioAnteriorFone1Gui().getText());
		veiculo.setProprietarioAnteriorFone2(getVeiculoPc().getProprietarioAnteriorFone2Gui().getText());
		veiculo.setProprietarioAnteriorNome(getVeiculoPc().getProprietarioAnteriorNomeGui().getText());
		veiculo.setProprietarioCnpj(getVeiculoPc().getProprietarioCnpjGui().getText());
		veiculo.setProprietarioCpf(getVeiculoPc().getProprietarioCpfGui().getText());
		veiculo.setProprietarioEmail(getVeiculoPc().getProprietarioEmailGui().getText());
		veiculo.setProprietarioFax(getVeiculoPc().getProprietarioFaxGui().getText());
		veiculo.setProprietarioFone1(getVeiculoPc().getProprietarioFone1Gui().getText());
		veiculo.setProprietarioFone2(getVeiculoPc().getProprietarioFone2Gui().getText());
		veiculo.setProprietarioNome(getVeiculoPc().getProprietarioNomeGui().getText());
		veiculo.setProprietarioRGNumero(getVeiculoPc().getProprietarioRGNumeroGui().getText());
		veiculo.setProprietarioRGOrgaoEmisssor(getVeiculoPc().getProprietarioRGOrgaoEmisssorGui().getText());
		veiculo.setRenavam(getVeiculoPc().getRenavamGui().getText());
		veiculo.setRestricoes((String) getVeiculoPc().getRestricoesGui().getSelectedItem());
		veiculo.setTipo((String) getVeiculoPc().getTipoGui().getSelectedItem());
		veiculo.setValorCompra(getVeiculoPc().getValorCompraGui().getText());
		veiculo.setValorVenda(getVeiculoPc().getValorVendaGui().getText());
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
